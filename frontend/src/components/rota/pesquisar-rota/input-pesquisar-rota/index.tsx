import { Status, Wrapper } from "@googlemaps/react-wrapper";
import { useEffect, useState } from "react"
import Mapa from "../../../mapa/Map";
import api from "../apiGeocoding";
import { Marker } from "@react-google-maps/api";


// interface retorno {
  //    lat:number,
  //    lng:number
  // }
  
  //  async function Geocoding(origem :string) {
    //       const resp1: retorno = { lat: 0, lng: 0 };
    //       try {
      //         const retorno = await api.get(`geocode/json?address=${origem}`);
      
      //         if (retorno.status === 200) {
        //           const coordsFields1 = retorno.data.results[0].geometry.location;
        //           resp1.lat = coordsFields1.lat;
        //           resp1.lng = coordsFields1.lng;
        //         } 
        //       } catch (error) {
//         console.error("Erro ao processar a solicitação:", error); 
//       }
//       return resp1;
// }


export default function InputPesquisarRota() {
  const [origem,setOrigin] = useState('');
  const [destino,setDestination] = useState('');
  const [filtro,setFitro] = useState(0);
  
    return (<>
      <input type="text" onChange={e => { setOrigin(e.target.value) }} placeholder="ponto de origem"/>      
      <input type="text" onChange={e => {setDestination(e.target.value)}} placeholder="ponto de destino"/>
      <input type="text" onChange={e => {setFitro(e.target.value as unknown as number)}} placeholder="distancia"/>
      <Mapa 
        origin={origem} destino={destino} distancia={filtro}       
      >
        {/* <Marker position={}/> */}

      </Mapa>

    </>)
}
