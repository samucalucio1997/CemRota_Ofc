import { useState, useMemo } from "react";
import "./styles.css"
type StyledMarkerProps = {
    imagemPonto: string,
    nomePonto: string,
    tipoPonto: string
}

function StyledMarker({ imagemPonto, nomePonto, tipoPonto }: StyledMarkerProps) {

    function defineColor(tipo: string) {
        switch (tipo) {
            case 'hospedagem':
                return '#EA7141';
            case 'comercio':
                return '#41EA8F';
            case 'ponto_turistico':
                return '#EA4177';
            case 'evento':
                return '#50DBD8';
            default:
                return undefined;
        }
    }

    const markerColor = useMemo(() => defineColor(tipoPonto), [tipoPonto]);

    return (
        <div className="marcador" style={{ backgroundColor: markerColor}}>
            <img src={imagemPonto} alt={`Imagem de ${nomePonto}`} />
        </div>
    )
}

export default StyledMarker;