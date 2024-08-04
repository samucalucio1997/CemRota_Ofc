import { Link } from "react-router-dom";
import logo from "../../assets/logo.png"
import "./styles.css"
function Header(){
    return (
        <>
         <div className="container-header">
            <Link to={"/"}>
                <img src={logo} alt="Logomarca 100rota" />
            </Link>
         </div>
        </>
    )
}

export default Header;