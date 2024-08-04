import { createBrowserRouter } from "react-router-dom"
import App from "../App"
import PrivateRoute from "./privateRoute"
import PesquisarRota from "../pages/PesquisarRota"
import Mapa from "../components/mapa/Map"
import InputPesquisarRota from "../components/rota/pesquisar-rota/input-pesquisar-rota"
import RegisterPontoInteresse from "../pages/RegisterPontoInteresse"


export const router = createBrowserRouter([
    {
        path: "/",
        element: <App />,
        children: [
            {
                path: "/login",
                element: '',
            },
            {
                path: "/",
                element:<PesquisarRota/>
            },
            {
                path:"/pesquisa",
                element:<InputPesquisarRota/>
            },
                path: "register-ponto-interesse",
                element: <RegisterPontoInteresse/>

            }
        ]
    }
])