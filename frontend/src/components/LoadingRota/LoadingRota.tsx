import React from 'react';
import './styles.css';
import { CircularProgress } from '@mui/material';

const Loading: React.FC<{ loading: boolean }> = ({ loading }) => {
    return (
        <div className={`loading-container ${loading ? 'show' : ''}`}>
            <div className="loading-text">
                <CircularProgress size={50} />
                Buscando a melhor rota
            </div>
        </div>
    );
};

export default Loading;
