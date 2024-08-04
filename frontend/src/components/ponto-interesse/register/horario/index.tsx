import HorarioCard from "./horario-card";
import "./styles.css"

export type HorarioProps = { 
    horaInicio: number, 
    setHoraInicio: (hora: number) => void,
    horaFim: number, 
    setHoraFim: (hora: number) => void
}


function HorarioRegister({...h}: HorarioProps){
    return (
        <div className="horarios">
        <HorarioCard hora={h.horaInicio} setHora={h.setHoraInicio}/>
        <HorarioCard hora={h.horaFim} setHora={h.setHoraFim}/>
        </div>
    )
}

export default HorarioRegister;