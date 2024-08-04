import DiaCard from "./dia-card";
import "./styles.css"

export type DiasRegisterProps = {
    domSelected: boolean;
    setDomSelected: (domSelected: boolean) => void;
    segSelected: boolean;
    setSegSelected: (segSelected: boolean) => void;
    terSelected: boolean;
    setTerSelected: (terSelected: boolean) => void;
    quaSelected: boolean;
    setQuaSelected: (quaSelected: boolean) => void;
    quiSelected: boolean;
    setQuiSelected: (quiSelected: boolean) => void;
    sexSelected: boolean;
    setSexSelected: (sexSelected: boolean) => void;
    sabSelected: boolean;
    setSabSelected: (sabSelected: boolean) => void;
}


function DiasRegister({...d}: DiasRegisterProps) {

    return (
        <div className="dias-container">
            <DiaCard
                dia={"dom"}
                isSelected={d.domSelected}
                setIsSelected={d.setDomSelected}
            />
            <DiaCard
                dia={"seg"}
                isSelected={d.segSelected}
                setIsSelected={d.setSegSelected}
            />
            <DiaCard
                dia={"ter"}
                isSelected={d.terSelected}
                setIsSelected={d.setTerSelected}
            />
            <DiaCard
                dia={"qua"}
                isSelected={d.quaSelected}
                setIsSelected={d.setQuaSelected}
            />
            <DiaCard
                dia={"qui"}
                isSelected={d.quiSelected}
                setIsSelected={d.setQuiSelected}
            />
            <DiaCard
                dia={"sex"}
                isSelected={d.sexSelected}
                setIsSelected={d.setSexSelected}
            />
            <DiaCard
                dia={"sab"}
                isSelected={d.sabSelected}
                setIsSelected={d.setSabSelected}
            />

        </div>
    )
}

export default DiasRegister;