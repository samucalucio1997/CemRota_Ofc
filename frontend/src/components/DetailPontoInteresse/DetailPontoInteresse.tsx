import { PontoInteresseDTO } from "../../interfaces/PontoInteresseDTO";
import cabana from "../../assets/cabana3.jpg"
import star from "../../assets/estrela-full.png"
import star2 from "../../assets/estrela.png"
import "./styles.css"
import { MapPin } from "lucide-react";


function DetailPontoIntersse({...props}: PontoInteresseDTO){
    return (
        <div className="container-detail">
            <div className="imagem-ponto">
                <img src={cabana} alt={`Image de ${props.titulo}`} />
            </div>

            <div className="basic-info">
                <div className="titulo">
                    {props.titulo}
                </div>
                <div className="avaliacao">
                    <div className="qtd">
                        4.5
                    </div>
                    <div className="stars">
                        <span>
                            <img src={star} alt="" />
                            <img src={star} alt="" />
                            <img src={star} alt="" />
                            <img src={star} alt="" />
                            <img src={star2} alt="" />
                        </span>
                    </div>
                </div>
                <div className="endereco">
                    <div className="icon">
                        <MapPin color="#FF4B23" size={16}/>
                    </div>
                    <div className="endereco">
                    Rua Francisco Chagas, 2456 - Centro, Natal - RN
                    </div>
                </div>
            </div>
        </div>
    )
}   

export default DetailPontoIntersse;