import "./styles.css"

type QuantidadeCamaHospedagemProps = {
    descricao: string;
    quantidade: number;
    setQuantidade: (quantidade: number) => void;
}

function QuantidadeCamaHospedagem(
    {
        descricao,
        quantidade,
        setQuantidade
    }: QuantidadeCamaHospedagemProps) {
    const handleLessClicked = () => {
        if (quantidade == 0) return;
        setQuantidade(quantidade - 1);
    }
    const handlePlusClicked = () => {
        setQuantidade(quantidade + 1);
    }
    return (
        <>
            <div className="container">
                <div className="descricao">
                    {descricao}
                </div>
                <div className="buttons">
                    <span className="button" onClick={handleLessClicked}>-</span>
                    <span>{quantidade}</span>
                    <span className="button" onClick={handlePlusClicked}>+</span>
                </div>
            </div>
        </>
    )
}

export default QuantidadeCamaHospedagem;