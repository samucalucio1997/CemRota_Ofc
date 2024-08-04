// Define the interface for the image object
interface Image {
    id: string;
    path: string;
}

// Define the interface for the attraction object
interface Attraction {
    id: string;
    icone: string;
    descricao: string;
}

// Define the main DTO interface
export interface PontoInteresseDTO {
    id: string;
    titulo: string;
    descricao: string;
    tipo: string;
    longitude: number;
    latitude: number;
    responsavel: string;
    qntd_cama_solteiro: number;
    qntd_cama_casal: number;
    aceita_animais: boolean;
    disponivel: boolean;
    imgs: Image[];
    atrativo: Attraction[];
    horarios: string;
    dias: string;
    valor_entrada: number;
}

