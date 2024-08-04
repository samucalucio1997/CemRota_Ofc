import CheckboxComponent from "../campos-checkbox";
import QuantidadeCamaHospedagem from "../quantidade-cama-hospedagem";

type HospedagemDataProps = {
    quantidadeCamaKing: number;
    quantidadeCamaSolteiro: number;
    setQuantidadeCamaKing: (quantidadeCamaKing: number) => void;
    setQuantidadeCamaSolteiro: (quantidadeCamaSolteiro: number) => void;
    animaisCheck: boolean;
    disponivelCheck: boolean;
    setAnimaisCheck: (animaisCheck: boolean) => void;
    setDisponivelCheck: (disponivelCheck: boolean) => void;
}

function HospedagemData(
    {
        quantidadeCamaKing,
        quantidadeCamaSolteiro,
        setQuantidadeCamaKing,
        setQuantidadeCamaSolteiro,
        animaisCheck,
        disponivelCheck,
        setAnimaisCheck,
        setDisponivelCheck
    }: HospedagemDataProps) {
    return (
        <>
            <QuantidadeCamaHospedagem
                descricao={'Quantidade de camas king'}
                quantidade={quantidadeCamaKing}
                setQuantidade={setQuantidadeCamaKing}
            />

            <QuantidadeCamaHospedagem
                descricao={'Quantidade de camas king'}
                quantidade={quantidadeCamaSolteiro}
                setQuantidade={setQuantidadeCamaSolteiro}
            />

            <CheckboxComponent description="Tem espaço para animais" isChecked={animaisCheck} setIsChecked={setAnimaisCheck} />
            <CheckboxComponent description="Disponível" isChecked={disponivelCheck} setIsChecked={setDisponivelCheck} />
        </>
    )
}

export default HospedagemData;