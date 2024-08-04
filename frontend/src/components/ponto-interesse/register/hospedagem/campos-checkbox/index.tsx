import './styles.css';

type CheckboxComponentProps = {
    description: string;
    isChecked: boolean;
    setIsChecked: (isChecked: boolean) => void;
}

const CheckboxComponent = ({ description, isChecked, setIsChecked }: CheckboxComponentProps) => {
    const handleCheckClicked = () => {
        setIsChecked(!isChecked);
    };

    return <div className='container-check'>
        <span>{description}</span>
        <label className={`checkbox-label ${isChecked ? 'checked' : ''}`}>
            <input type="checkbox" checked={isChecked} onChange={handleCheckClicked} style={{ display: 'none' }} />
        </label>
    </div>

};

export default CheckboxComponent;