import { AxiosPromise } from "axios"
import { Api, SERVICE } from "../../../services/api"
import { PontoInteresseDTO } from "../../../interfaces/PontoInteresseDTO";

type GetAllPontoInteresse = {
    origem: string;
    destino: string;
    filtro: number;
}
class PesquisaRotaService {
    private baseUrl: String
    private apiCore: Api

    constructor(){
        this.baseUrl = SERVICE.CORE
        this.apiCore = new Api()
    }

    public async getAllPontoInteresse({...parametros}: GetAllPontoInteresse): AxiosPromise<PontoInteresseDTO[]> {
        return await this.apiCore.axios.get(`${this.baseUrl}ponto-interesse/pontos`, {
            params: {
                ...parametros
            }
        });
    }

    
}

export default PesquisaRotaService;