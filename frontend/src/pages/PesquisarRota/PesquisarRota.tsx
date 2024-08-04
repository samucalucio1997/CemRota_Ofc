import Map from "../../components/mapa/Map"
import { useState, useEffect } from "react"
import directions from '@mapbox/mapbox-sdk/services/directions';
import geocoding from '@mapbox/mapbox-sdk/services/geocoding';
import "./styles.css"

import mapboxSdk from '@mapbox/mapbox-sdk';
import { Coordinates, ViewProps } from "../../interfaces/Map";
import { ChevronDown, ChevronUp, Search } from "lucide-react";
import Loading from "../../components/LoadingRota/LoadingRota";
import { PontoInteresseDTO } from "../../interfaces/PontoInteresseDTO";
import DetailPontoIntersse from "../../components/DetailPontoInteresse/DetailPontoInteresse";
import { CgClose } from "react-icons/cg";
import PesquisaRotaService from "./services/PesquisarRotaService";

const TOKEN: string = 'pk.eyJ1IjoicmVuYW5saXNib2EiLCJhIjoiY2x5ZWJndm11MDBzZDJtcHc5cmt5eGk5NyJ9.vVttItTEnoh1r1n9NCYwcg'

const MapboxClient = mapboxSdk({ accessToken: TOKEN });
const directionsClient = directions(MapboxClient);
const geocodingClient = geocoding(MapboxClient);

export default function PesquisarRota() {

  const pesquisarRotaService: PesquisaRotaService = new PesquisaRotaService(); 
  // Controle da pesquisa
  const [control, setControl] = useState<boolean>(false);
  const [loading, setLoading] = useState<boolean>(false);

  //controle modal
  const [modalOn, setModalOn] = useState<boolean>(true);

  //localização atual
  const [currLocalization, setCurrLocalization] = useState<Coordinates | null>(null)

  const [origem, setOrigem] = useState<string>('');
  const [destino, setDestino] = useState<string>('');

  const [coordOrigem, setCoordOrigem] = useState<Coordinates | null>(null);
  const [coordDestino, setCoordDestino] = useState<Coordinates | null>(null);

  // Marcador inicial (Extremoz) - vai sumir para virar a lista que vem do backend
  const [pontosInteresse, setPontosInteresse] = useState<Array<PontoInteresseDTO>>([]);

  // Para pegar a rota
  const [route, setRoute] = useState<GeoJSON.FeatureCollection<GeoJSON.Geometry>>({
    type: 'FeatureCollection',
    features: []
  });

  // Visualização inicial do mapa
  const [viewport, setViewport] = useState<ViewProps>({
    latitude: -5.687981,
    longitude: -35.273460,
    zoom: 15
  });

  useEffect(() => {
    if (coordOrigem && coordDestino) {
      getRoute();
    }

    navigator.geolocation.getCurrentPosition((position)=>{
      setCurrLocalization({
        latitude: position.coords.latitude,
        longitude: position.coords.longitude
      })
    })
  }, [coordOrigem, coordDestino]);

  const getRoute = async () => {
    try {
      if (coordOrigem && coordDestino) {
        setLoading(true);
        const response = await directionsClient.getDirections({
          profile: 'driving',
          geometries: 'geojson',
          waypoints: [
            { coordinates: [coordOrigem.longitude, coordOrigem.latitude] },
            { coordinates: [coordDestino.longitude, coordDestino.latitude] }
          ]
        }).send();
        setRoute(response.body.routes[0].geometry);
        setLoading(false)
      }
    } catch (error) {
      console.error('Error fetching directions:', error);
    }
  };

  const getCoordinates = async (address: string) => {
    try {
      const response = await geocodingClient.forwardGeocode({
        query: address,
        limit: 1
      }).send();

      const match = response.body.features[0];
      return {
        latitude: match.center[1],
        longitude: match.center[0]
      };
    } catch (error) {
      console.error('Error fetching coordinates:', error);
    }
  };

  function handleControlClick() {
    setControl(!control);
  }

  async function handleGetCoordinates() {
    const cOrigem = await getCoordinates(origem);
    const cDestino = await getCoordinates(destino);

    if (cOrigem && cDestino) {
      setCoordOrigem(cOrigem);
      setCoordDestino(cDestino);

      setViewport({
        latitude: (cOrigem.latitude + cDestino.latitude) / 2,
        longitude: (cOrigem.longitude + cDestino.longitude) / 2,
        zoom: 10
      });

      const resp = await pesquisarRotaService.getAllPontoInteresse({
        origem, destino, filtro: 10000
      })
      console.log(resp)
      setPontosInteresse(resp.data);
    }
  }

  return (
    <div className="container-inicio" style={{}}>
      <div className={`cabecalho-pesquisa ${control ? 'desativado' : ''}`}>
        <div className="form-group">
          <input className="input-origem" onChange={e => setOrigem(e.target.value)} placeholder="Origem" type="text" name="" id="" />
          <input className="input-destino" onChange={e => setDestino(e.target.value)} type="text" placeholder="Destino" name="" id="" />
        </div>

        <button onClick={handleGetCoordinates} className="s-button">
          <span>Buscar</span>
          <Search />
        </button>

        <div onClick={handleControlClick} className="controle">
          {control ? (
            <ChevronDown />
          ) : (
            <ChevronUp />
          )}
        </div>
      </div>

      <div className={`detail-ponto-interesse-modal ${modalOn ? 'modal-on' : ''}`}>
        <DetailPontoIntersse 
        id={""} 
        titulo={""} 
        descricao={""} 
        tipo={""} 
        longitude={0} 
        latitude={0} 
        responsavel={""} 
        qntd_cama_solteiro={0} 
        qntd_cama_casal={0} 
        aceita_animais={false} 
        disponivel={false} 
        imgs={[]} 
        atrativo={[]} 
        horarios={""} 
        dias={""} 
        valor_entrada={0}        />

        <div onClick={()=>setModalOn(!modalOn)} className="close-modal">
          <CgClose/>
        </div>
      </div>

      <div className={`sombra ${modalOn ? 'modal-on' : ''}`}>

      </div>


      {
        loading ? (
          <Loading loading={loading}/>
        ): (
          <Map
          viewport={viewport}
          pontosInteresse={pontosInteresse}
          setViewPort={setViewport}
          currentPosition={currLocalization}
          route={route}
          showPopup={modalOn}
          setShowPopup={setModalOn}
        />
        )
      }
      
    </div>
  );
}
