import { formatHour } from "../../../../../utils/formatHour";
import "./styles.css"

export type HorarioControllerProps = {
    hora: number;
    setHora: (hora: number) => void;
}

function HorarioCard({hora, setHora}: HorarioControllerProps) {
    
    const handleHourLessClicked = () => {
        if(hora == 0) setHora(23);
        else setHora(hora-1);
    }

    const handleHourPlusClicked = () => {
        if(hora == 23) hora = 0;
        else setHora(hora+1);
    }

    return (

        <div className="horario-controller">
            <span className="button" onClick={handleHourLessClicked}>-</span>
            <span>{formatHour(hora)}</span>
            <span className="button" onClick={handleHourPlusClicked}>+</span>
        </div>
    )
}

export default HorarioCard;