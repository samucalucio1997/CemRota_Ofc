import React, { useState } from 'react';
import "mapbox-gl/dist/mapbox-gl.css";
import ReactMapGl, { Marker, Source, Layer, ViewState, Popup } from "react-map-gl";
import { Coordinates, ViewProps } from '../../interfaces/Map';
import StyledMarker from "../Marker/Marker";
import cabana from "../../assets/cabana3.jpg"
import cabana2 from "../../assets/cabana4.jpg"
import { MapPin } from 'lucide-react';
import { PontoInteresseDTO } from '../../interfaces/PontoInteresseDTO';
const TOKEN: string = 'pk.eyJ1IjoicmVuYW5saXNib2EiLCJhIjoiY2x5ZWJndm11MDBzZDJtcHc5cmt5eGk5NyJ9.vVttItTEnoh1r1n9NCYwcg';

type MapProps = {
  viewport: ViewProps,
  pontosInteresse: Array<PontoInteresseDTO>,
  setViewPort: (value: ViewState) => void,
  route: GeoJSON.FeatureCollection<GeoJSON.Geometry>,
  currentPosition: Coordinates | null,
  showPopup: boolean, 
  setShowPopup: (arg: boolean) => void
}

function Map({ viewport, setViewPort, pontosInteresse, route, currentPosition, setShowPopup, showPopup }: MapProps) {
  const [pInteresse, setPInteresse] = useState<PontoInteresseDTO | null>(null);

  function handleClickMarker (){
    setPInteresse(pInteresse)
    setShowPopup(!showPopup);
  }

  return (
    <ReactMapGl
      initialViewState={{ ...viewport }}
      mapboxAccessToken={TOKEN}
      style={{ width: "100%", height: "100%", animationDuration: "200" }}
      mapStyle={"mapbox://styles/mapbox/streets-v9"}
      onMove={evt => setViewPort(evt.viewState)}
    >

      {pontosInteresse.map((pInteresse, index) => (
        <Marker
          key={index}
          latitude={pInteresse.latitude}
          longitude={pInteresse.longitude}
          anchor="bottom"
          onClick={handleClickMarker}
        >
          <StyledMarker imagemPonto={cabana} nomePonto="Hospedagem Teste" tipoPonto="hospedagem" />
        </Marker>
      ))}

      {currentPosition && (
        <Marker
          latitude={currentPosition.latitude}
          longitude={currentPosition.longitude}
          anchor="bottom"
        >
          <MapPin color='#FF4B23' size={32} />
        </Marker>
      )}

      {route && (
        <Source id="route" type="geojson" data={route}>
          <Layer
            id="route"
            type="line"
            source="route"
            layout={{
              'line-join': 'round',
              'line-cap': 'round'
            }}
            paint={{
              'line-color': '#003C46',
              'line-width': 6
            }}
          />
        </Source>
      )}
    </ReactMapGl>
  );
}

export default Map;
