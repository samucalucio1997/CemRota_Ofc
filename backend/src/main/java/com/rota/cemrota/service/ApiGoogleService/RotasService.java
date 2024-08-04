package com.rota.cemrota.service.ApiGoogleService;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.rota.cemrota.config.FileStoragePropPontoInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rota.cemrota.model.Comercio;
import com.rota.cemrota.model.Evento;
import com.rota.cemrota.model.Hospedagem;
import com.rota.cemrota.model.PontoTuristico;
import com.rota.cemrota.service.domain.ComercioService;
import com.rota.cemrota.service.domain.EventoService;
import com.rota.cemrota.service.domain.HospedagemService;
import com.rota.cemrota.service.domain.PontoRotaDto;
import com.rota.cemrota.service.domain.PontoTuristicoService;



@Component
public class RotasService implements RotasAbstService {

    @Autowired
    private HospedagemService hospedagemService;

    @Value("${chave}")
    private String key;

    @Autowired
    private EventoService eventoService;

    @Autowired
    private PontoTuristicoService pontoTuristico;

    @Autowired
    private ComercioService comercioService;

    private final Path caminho;

    public RotasService(FileStoragePropPontoInt fileStoragePropPontoInt) {
        this.caminho = Paths.get(fileStoragePropPontoInt.getUpfileDir()).toAbsolutePath().normalize();
    }

    @Override
    public List<PontoInteresseDTO> PegarRota(String origem, String destino, double filtroDistancia) throws URISyntaxException {
                PontoRotaDto coordenadasOrigem = Geocode(origem);
                PontoRotaDto coordenadasDestino = Geocode(destino);

                URI uri = new URI("https://api.mapbox.com/directions/v5/mapbox/driving/"+coordenadasOrigem.Longitude+","+coordenadasOrigem.Latitude+";"+coordenadasDestino.Longitude+","+coordenadasDestino.Latitude+"?access_token="+key);
                HttpGet httpget = new HttpGet(uri);
                httpget.setHeader("Content-Type", "application/json");
    
                try {
                    HttpClient httpclient = HttpClientBuilder.create().build();
                    HttpResponse response = httpclient.execute(httpget);
                    HttpEntity entity = response.getEntity();
                    String result = EntityUtils.toString(entity);
                    String encodeRoute = hashRoute(result);
                    List<PontoRotaDto> listRota = decode(encodeRoute);
                    for(PontoRotaDto pontos: listRota){
                         System.out.println("Latitude =>"+pontos.Latitude + " Longitude =>" + pontos.Longitude);
                    }
                    return filtroDistancia(listRota, filtroDistancia);
                } catch (Exception e) {
                    System.out.println("ERROR - K31" + e.getMessage());
                    throw new RuntimeException();
                }

    }

    private String hashRoute(String result) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode hashNode = mapper.readTree(result);
            JsonNode route = hashNode.path("routes").get(0).path("geometry");
            return route.asText();
        } catch (Exception e) {
            return null;
        }

    }

    private synchronized PontoRotaDto Geocode(String ponto) throws URISyntaxException {
        ponto = ponto.replace(" ", "%20");
        URI uri = new URI("https://api.mapbox.com/search/geocode/v6/forward?q="+ponto+"&access_token="+key);
        HttpGet httpget = new HttpGet(uri);
                httpget.setHeader("Content-Type", "application/json");
         try {
            HttpClient httpclient = HttpClientBuilder.create().build();
            HttpResponse response = httpclient.execute(httpget);
             HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            return getcoordenates(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private PontoRotaDto getcoordenates(String result) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(result);
        JsonNode coordinatesNode = rootNode.path("features").get(0).path("geometry").path("coordinates");
        if (coordinatesNode.isArray()){
            Double longitude = coordinatesNode.get(0).asDouble();
            Double latitude = coordinatesNode.get(1).asDouble();
            PontoRotaDto coordenadas = new PontoRotaDto(latitude, longitude);
            return coordenadas;
        } else {
            throw new IllegalArgumentException("Invalid coordinates format");
        }
    }

    private List<PontoInteresseDTO> filtroDistancia(List<PontoRotaDto> listRota, double distFiltro) {
        List<PontoInteresseDTO> listaInteresse = null;
        try {
            listaInteresse = new ArrayList<>();

                for (Comercio pontoInteresse : this.comercioService.findAll()) {
                    for (PontoRotaDto pontoRotaDto : listRota) {
                        if (RotasService.getDistanceBetweenPointsNew(pontoInteresse.getLatitude(), pontoInteresse.getLongitude(),
                                pontoRotaDto.Latitude, pontoRotaDto.Longitude, "kilometers") <= distFiltro) {
                            PontoInteresseDTO PTDO = new PontoInteresseDTO(pontoInteresse.getId(), pontoInteresse.getTitulo(),
                                    pontoInteresse.getDescricao(),"comercio", pontoInteresse.getLongitude(), pontoInteresse.getLatitude(), pontoInteresse.getResponsavel().getId(), 0,
                                    0, false, false,
                                    pontoInteresse.getImgs(), null, null, null, 0);
                            System.out.println(pontoInteresse.getId());
                            PTDO.setDias(pontoInteresse.getDias());
                            PTDO.setHorarios(pontoInteresse.getHorarios());
                            listaInteresse.add(PTDO);
                            break;
                        }
                    }
                }
                for (Evento pontoInteresse : this.eventoService.findAll()) {
                    for (PontoRotaDto pontoRotaDto : listRota) {
                        if (RotasService.getDistanceBetweenPointsNew(pontoInteresse.getLatitude(),
                                pontoInteresse.getLongitude(), pontoRotaDto.Latitude, pontoRotaDto.Longitude,
                                "kilometers") <= distFiltro) {
                            PontoInteresseDTO PTDO = new PontoInteresseDTO(pontoInteresse.getId(),
                                    pontoInteresse.getTitulo(), pontoInteresse.getDescricao(),"evento", pontoInteresse.getLongitude(), pontoInteresse.getLatitude(), pontoInteresse.getResponsavel().getId(), 0,
                                    0, false, false,
                                    pontoInteresse.getImgs(), null, null, null, 0);
                            PTDO.setDias(pontoInteresse.getDias());
                            PTDO.setHorarios(pontoInteresse.getHorarios());
                            listaInteresse.add(PTDO);
                            break;
                        }
                    }
                }
                for (Hospedagem pontoInteresse : this.hospedagemService.findAll()) {
                    for (PontoRotaDto pontoRotaDto : listRota) {
                        if (RotasService.getDistanceBetweenPointsNew(pontoInteresse.getLatitude(),
                                pontoInteresse.getLongitude(), pontoRotaDto.Latitude, pontoRotaDto.Longitude,
                                "kilometers") <= distFiltro) {

                            PontoInteresseDTO PTDO = new PontoInteresseDTO(pontoInteresse.getId(), pontoInteresse.getTitulo(),
                                    pontoInteresse.getDescricao(),"hospedagem", pontoInteresse.getLongitude(), pontoInteresse.getLatitude(), pontoInteresse.getResponsavel().getId(), pontoInteresse.getQntd_cama_solteiro(),
                                    pontoInteresse.getQntd_cama_casal(), pontoInteresse.isAceita_animais(), pontoInteresse.isDisponivel(),
                                    pontoInteresse.getImgs(), null, null, null, 0);
                            listaInteresse.add(PTDO);
                            break;
                        }
                    }
                }
                for (PontoTuristico pontoInteresse : this.pontoTuristico.findAll()) {
                    for (PontoRotaDto pontoRotaDto : listRota) {
                        if (RotasService.getDistanceBetweenPointsNew(pontoInteresse.getLatitude(),
                                pontoInteresse.getLongitude(), pontoRotaDto.Latitude, pontoRotaDto.Longitude,
                                "kilometers") <= distFiltro) {
                            PontoInteresseDTO PTDO = new PontoInteresseDTO(pontoInteresse.getId(), pontoInteresse.getTitulo(),
                                    pontoInteresse.getDescricao(),"ponto_turistico", pontoInteresse.getLongitude(), pontoInteresse.getLatitude(), pontoInteresse.getResponsavel().getId(), 0,
                                    0, false, false,
                                    pontoInteresse.getImgs(), null, null, null, 0);
                            PTDO.setValor_entrada(pontoInteresse.getValor_entrada());
                            listaInteresse.add(PTDO);
                            break;
                        }
                    }
                }

            return listaInteresse;
        } catch (Exception e) {
  
            throw e;
        }
    }

    private List<PontoRotaDto> decode(String encode) {
        List<PontoRotaDto> poly = new ArrayList<>();
        int index = 0;
        int len = encode.length();
        int lat = 0;
        int lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encode.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encode.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            PontoRotaDto p = new PontoRotaDto(((double) lat / 1E5), ((double) lng / 1E5));
            poly.add(p);
        }
        return poly;
    }

    private static double getDistanceBetweenPointsNew(double latitude1, double longitude1, double latitude2,
            double longitude2, String unit) {
        double theta = longitude1 - longitude2;
        double distance = Math.acos(
                Math.sin(Math.toRadians(latitude1)) * Math.sin(Math.toRadians(latitude2)) +
                        Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
                                * Math.cos(Math.toRadians(theta)));

        // Convertendo a distância de radianos para milhas ou quilômetros
        distance = Math.toDegrees(distance) * 60 * 1.1515;

        // Convertendo para quilômetros, se necessário
        if (unit.equals("kilometers")) {
            distance *= 1.609344;
        }

        // Arredondando para 2 casas decimais
        distance = Math.round(distance * 100.0) / 100.0;

        return distance;
    }

}
