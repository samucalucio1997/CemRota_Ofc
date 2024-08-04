import DiasRegister, { DiasRegisterProps } from "../dias";
import HorarioRegister, { HorarioProps } from "../horario";
import EventSelect, { EventSelectProps } from "./select-tipo-evento";


function Evento({ ...d }: DiasRegisterProps & HorarioProps & EventSelectProps) {
    if(d.horaInicio > d.horaFim) d.setHoraInicio(d.horaFim)
    return (
        <>
            <DiasRegister
                domSelected={d.domSelected}
                setDomSelected={d.setDomSelected}
                segSelected={d.segSelected}
                setSegSelected={d.setSegSelected}
                terSelected={d.terSelected}
                setTerSelected={d.setTerSelected}
                quaSelected={d.quaSelected}
                setQuaSelected={d.setQuaSelected}
                quiSelected={d.quiSelected}
                setQuiSelected={d.setQuiSelected}
                sexSelected={d.sexSelected}
                setSexSelected={d.setSexSelected}
                sabSelected={d.sabSelected}
                setSabSelected={d.setSabSelected}
            />

            <HorarioRegister
                horaInicio={d.horaInicio}
                setHoraInicio={d.setHoraInicio}
                horaFim={d.horaFim}
                setHoraFim={d.setHoraFim}
            />

            <EventSelect
            eventoSelected={d.eventoSelected}
            setEventoSelected={d.setEventoSelected}
            />
        </>
    )
}

export default Evento;