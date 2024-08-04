CREATE TABLE Hospedagem (
    id UUID PRIMARY KEY NOT NULL,
    longitude REAL NOT NULL,
    latitude REAL NOT NULL,
    data_inicio DATE,
    data_fim DATE,
    hora_inicio TIME,
    hora_fim TIME,
    qtd_quartos INT,
    qtd_hospedes INT,
    servico VARCHAR(255) NOT NULL,
    valor_quarto REAL,
    endereco_id UUID NOT NULL,
    usuario_id UUID NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    FOREIGN KEY (endereco_id) REFERENCES Endereco (id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario (id)
);