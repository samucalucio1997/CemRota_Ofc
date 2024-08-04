package com.rota.cemrota.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rota.cemrota.model.PontoInteresse;
import com.rota.cemrota.service.ImageService;
import com.rota.cemrota.service.ApiGoogleService.PontoInteresseDTO;
import com.rota.cemrota.service.ApiGoogleService.RotasAbstService;
import com.rota.cemrota.service.ApiGoogleService.RotasService;
import com.rota.cemrota.service.domain.HospedagemService;
import com.rota.cemrota.service.domain.PontoInteresseService;
import com.rota.cemrota.service.request.HospedagemRequest;

@RestController
@RequestMapping("/ponto-interesse")
public class PontoInteresseController {
    @Autowired
    private PontoInteresseService pInteresseService;

    @Autowired
    private HospedagemService hospedagemService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private RotasService rotasServiceFa;

    @Autowired
    private RotasAbstService rotasService;

    @PostMapping("/registerHosp")
    public ResponseEntity<PontoInteresse> registerPontoInteresse(@RequestBody HospedagemRequest Hospedagem){
        PontoInteresse pInteresse = this.pInteresseService.cadastrarPonto(Hospedagem.getHospedagem());
        return ResponseEntity.ok(pInteresse);
    }
    
    @GetMapping("/pontos")
    public ResponseEntity<List<PontoInteresseDTO>> pontosInteresseRota(@RequestParam("origem") String origem, @RequestParam("destino") String destino, @RequestParam("filtro") double distancia){
        try {
            return ResponseEntity.status(200).body(this.rotasService.PegarRota(origem, destino,distancia));
        } catch (Exception e) {
  
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/pteste")
    public List<PontoInteresseDTO> TestGeocode(){
         try {
            return this.rotasServiceFa.PegarRota("natal,rn", "macaiba,rn", 4);
         } catch (Exception e) {

            throw new RuntimeException();
         }
    }

    @GetMapping("/path")
    public ResponseEntity<byte[]> pegarImagem(@RequestParam("caminho") String path){
        try {
            System.out.println(this.imageService.extrairImagem(path));
            return ResponseEntity.status(200).body(this.imageService.extrairImagem(path));
        } catch (Exception e) {

            return ResponseEntity.badRequest().build();
        }         
    }
    

}