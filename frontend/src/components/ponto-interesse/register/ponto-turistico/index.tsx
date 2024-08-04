import "./styles.css";
import { NumericFormat } from 'react-number-format';

type InputProps = {
    valor: number;
    setValor: (valor: number) => void;
}

function PontoTuristico({ valor, setValor }: InputProps) {
    const handleSetValue = (values: { floatValue?: number }) => {
        if (values.floatValue !== undefined) {
            setValor(values.floatValue);
        }
    }

    return (
        <div className="container-p-turistico">
            <NumericFormat
                placeholder={'R$ 10,00'}
                name={'valorEntrada'}
                value={valor}
                thousandSeparator={'.'}
                decimalSeparator={','}
                prefix={'R$ '}
                onValueChange={handleSetValue}
                className="input"
                type="text"
            />
        </div>
    )
}

export default PontoTuristico;