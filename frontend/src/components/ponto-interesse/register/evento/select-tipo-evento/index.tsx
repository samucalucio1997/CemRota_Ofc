import './styles.css';

export type EventSelectProps = {
    eventoSelected: string,
    setEventoSelected: (eventoSelected: string) => void;
}

const EventSelect = ({ eventoSelected, setEventoSelected }: EventSelectProps) => {
    return (
        <div className="evento">
            <select
                className="event-select"
                value={eventoSelected}
                onChange={(e) => setEventoSelected(e.target.value)}
            >
                <option value="Gala">Gala</option>
                <option value="Conferência">Conferência</option>
                <option value="Voluntariado">Voluntariado</option>
                <option value="Cultura">Cultura</option>
                <option value="Coquetel">Coquetel</option>
                <option value="Esporte">Esporte</option>
                <option value="Jantar">Jantar</option>
                <option value="Festa">Festa</option>
            </select>
        </div>

    );
};

export default EventSelect;
