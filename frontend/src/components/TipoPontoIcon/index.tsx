import React from "react";
import "./styles.css"

type TipoPontoIconProps = {
    icon: React.ReactNode;
    descricao: string;
    onClick: () => void; 
    isSelected: boolean;
}

function TipoPontoIcon(
    {
        icon,
        descricao,
        onClick,
        isSelected
    }: TipoPontoIconProps) {
    return (
        <div className={`icon-container ${isSelected ? 'selected' : ''}`} onClick={onClick}>
            <span className="icon">
                {icon}
            </span>
            <span className="description">
                {descricao}
            </span>
        </div>
    );
}


export default TipoPontoIcon;