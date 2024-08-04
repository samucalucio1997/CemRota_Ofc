import { useState } from "react";
import "./styles.css"
import TipoPontoIcon from "../../components/TipoPontoIcon";
import { LuHotel, LuPartyPopper } from "react-icons/lu";
import { CiShoppingBasket } from "react-icons/ci";
import { PiCamera } from "react-icons/pi";
import Button from "../../components/button";
import HospedagemData from "../../components/ponto-interesse/register/hospedagem/hospedagem-data";
import ComercioData from "../../components/ponto-interesse/register/comercio";
import Evento from "../../components/ponto-interesse/register/evento";
import PontoTuristico from "../../components/ponto-interesse/register/ponto-turistico";


function RegisterPontoInteresse() {
    //constantes de hospedagem
    const [titulo, setTitulo] = useState<string>();
    const [descricao, setDescricao] = useState<string>();
    const [selectedIcon, setSelectedIcon] = useState<string>('hospedagem');
    const [quantidadeCamaKing, setQuantidadeCamaKing] = useState<number>(0);
    const [quantidadeCamaSolteiro, setQuantidadeCamaSolteiro] = useState<number>(0);
    const [animaisCheck, setAnimaisCheck] = useState<boolean>(false);
    const [disponivelCheck, setDisponivelCheck] = useState<boolean>(false);

    //constantes de dias
    const [domSelected, setDomSelected] = useState<boolean>(false);
    const [segSelected, setSegSelected] = useState<boolean>(false);
    const [terSelected, setTerSelected] = useState<boolean>(false);
    const [quaSelected, setQuaSelected] = useState<boolean>(false);
    const [quiSelected, setQuiSelected] = useState<boolean>(false);
    const [sexSelected, setSexSelected] = useState<boolean>(false);
    const [sabSelected, setSabSelected] = useState<boolean>(false);

    //constantes de horario
    const [horaInicio, setHoraInicio] = useState<number>(10);
    const [horaFim, setHoraFim] = useState<number>(15);

    //constantes de evento
    const [eventoSelected, setEventoSelected] = useState<string>('Selecione um tipo');

    //constantes de evento
    const [valor, setValor] = useState<number>(0);

    const handleIconClick = (icon: string) => {
        setSelectedIcon(icon);
    };

    function renderizarComponenteSelecionado(icon: string) {
        switch (icon) {
            case 'hospedagem':
                return (
                    <HospedagemData
                        quantidadeCamaKing={quantidadeCamaKing}
                        quantidadeCamaSolteiro={quantidadeCamaSolteiro}
                        setQuantidadeCamaKing={setQuantidadeCamaKing}
                        setQuantidadeCamaSolteiro={setQuantidadeCamaSolteiro}
                        animaisCheck={animaisCheck}
                        disponivelCheck={disponivelCheck}
                        setAnimaisCheck={setAnimaisCheck}
                        setDisponivelCheck={setDisponivelCheck}
                    />
                );

            case 'comercio':
                return (
                    <ComercioData
                        domSelected={domSelected}
                        setDomSelected={setDomSelected}
                        segSelected={segSelected}
                        setSegSelected={setSegSelected}
                        terSelected={terSelected}
                        setTerSelected={setTerSelected}
                        quaSelected={quaSelected}
                        setQuaSelected={setQuaSelected}
                        quiSelected={quiSelected}
                        setQuiSelected={setQuiSelected}
                        sexSelected={sexSelected}
                        setSexSelected={setSexSelected}
                        sabSelected={sabSelected}
                        setSabSelected={setSabSelected}
                        horaInicio={horaInicio}
                        setHoraInicio={setHoraInicio}
                        horaFim={horaFim}
                        setHoraFim={setHoraFim}

                    />
                );

            case 'evento':
                return (
                    <Evento
                        domSelected={domSelected}
                        setDomSelected={setDomSelected}
                        segSelected={segSelected}
                        setSegSelected={setSegSelected}
                        terSelected={terSelected}
                        setTerSelected={setTerSelected}
                        quaSelected={quaSelected}
                        setQuaSelected={setQuaSelected}
                        quiSelected={quiSelected}
                        setQuiSelected={setQuiSelected}
                        sexSelected={sexSelected}
                        setSexSelected={setSexSelected}
                        sabSelected={sabSelected}
                        setSabSelected={setSabSelected}
                        horaInicio={horaInicio}
                        setHoraInicio={setHoraInicio}
                        horaFim={horaFim}
                        setHoraFim={setHoraFim}
                        eventoSelected={eventoSelected}
                        setEventoSelected={setEventoSelected}
                    />
                );

            case 'turistico':
                return (
                    <PontoTuristico
                        valor={valor}
                        setValor={setValor}
                    />
                )
            default:
                return null;
        }
    }

    return (
        <div className="container-register-ponto">
            <section className="card-section-register">
                <form className="form-register" action="">
                    <input
                        type={'text'}
                        placeholder={'Título do seu ponto'}
                        name={'titulo'}
                        value={titulo}
                        onChange={(e: any) => setTitulo(e.target.value)}
                        className="input input-text"
                    />
                    <textarea
                        placeholder={'Descreva seu ponto'}
                        name={'descricao'}
                        value={descricao}
                        onChange={(e: any) => setDescricao(e.target.value)}
                        className="input input-textarea"
                    />
                </form>

                <div className="tipos-servico">
                    <TipoPontoIcon
                        icon={<LuHotel />}
                        descricao={'Hospedagem'}
                        onClick={() => handleIconClick('hospedagem')}
                        isSelected={selectedIcon === 'hospedagem'} />

                    <TipoPontoIcon
                        icon={<CiShoppingBasket />}
                        descricao={'Comércio'}
                        onClick={() => handleIconClick('comercio')}
                        isSelected={selectedIcon === 'comercio'} />

                    <TipoPontoIcon
                        icon={<LuPartyPopper />}
                        descricao={'Evento'}
                        onClick={() => handleIconClick('evento')}
                        isSelected={selectedIcon === 'evento'} />

                    <TipoPontoIcon
                        icon={<PiCamera />}
                        descricao={'Ponto Turístico'}
                        onClick={() => handleIconClick('turistico')}
                        isSelected={selectedIcon === 'turistico'} />
                </div>
            </section>

            <section className="card-section-register">
                {renderizarComponenteSelecionado(selectedIcon)}
            </section>

            <Button description={'Cadastrar Novo Ponto'} />
        </div>
    )
}

export default RegisterPontoInteresse;