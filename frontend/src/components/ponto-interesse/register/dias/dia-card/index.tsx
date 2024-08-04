import "./styles.css"

type DiaCardProps = {
    dia: string, 
    isSelected: boolean, 
    setIsSelected: (isSelected: boolean) => void; 
}

function DiaCard({dia, isSelected, setIsSelected}: DiaCardProps){
    const handleDiaSelected = ()=>{
        setIsSelected(!isSelected)
    }
    return (
        <div className={`dia-container ${isSelected ? 'dia-selected' : ''}`} onClick={handleDiaSelected}>
            {dia}
        </div>
    )
}

export default DiaCard;