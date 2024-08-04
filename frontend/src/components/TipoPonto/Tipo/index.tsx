import { ReactNode } from "react";
import "./styles.css"
type TipoPontoPros = {
    icone: ReactNode,
    descricao: string
}

function TipoPonto({ icone, descricao}: TipoPontoPros){
    return (
        <>
        <div className="tipo-ponto">
            <div className="icon">{icone}</div>
            <div>{descricao}</div>
        </div>
        </>
    )
}

export default TipoPonto;