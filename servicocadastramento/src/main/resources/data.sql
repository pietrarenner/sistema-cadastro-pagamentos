DROP TABLE aplicativo IF EXISTS;
DROP TABLE cliente IF EXISTS;

CREATE TABLE aplicativo (
    codigo BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    custo_mensal FLOAT NOT NULL
);

CREATE TABLE cliente (
    codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

INSERT INTO aplicativo (codigo, nome, custo_mensal) VALUES
(1, 'Aplicativo A', 100.50),
(2, 'Aplicativo B', 200.75),
(3, 'Aplicativo C', 300.00),
(4, 'Aplicativo D', 150.25),
(5, 'Aplicativo E', 250.60);

INSERT INTO cliente (codigo, nome, email) VALUES
(1, 'João Silva', 'joao.silva@example.com'),
(2, 'Maria Oliveira', 'maria.oliveira@example.com'),
(3, 'Carlos Pereira', 'carlos.pereira@example.com'),
(4, 'Ana Souza', 'ana.souza@example.com'),
(5, 'Paulo Lima', 'paulo.lima@example.com');

