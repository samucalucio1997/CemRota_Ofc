import "./styles.css"
type ButtonProps = {
    description: string
}

function Button({description}: ButtonProps){
    return(
        <button>
            {description}
        </button>
    )
}

export default Button;