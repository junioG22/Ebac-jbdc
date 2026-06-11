CREATE DATABASE Empresa;

USE Empresa;

CREATE TABLE Funcionarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    cargo VARCHAR(100)
);

CREATE TABLE Salarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    funcionario_id INT,
    salario DECIMAL(10,2),
    data_pagamento DATE,

    FOREIGN KEY (funcionario_id)
    REFERENCES Funcionarios(id)
);

INSERT INTO Funcionarios(nome, cargo)
VALUES
    ('Carlos', 'Backend'),
    ('Ana', 'Frontend'),
    ('Pedro', 'Backend'),
    ('Marcos', 'DevOps'),
    ('Julia', 'QA');

INSERT INTO Salarios(funcionario_id, salario, data_pagamento)
VALUES
    (1, 4500.00, '2026-06-10'),
    (2, 4000.00, '2026-06-10'),
    (3, 5200.00, '2026-06-10'),
    (4, 6000.00, '2026-06-10'),
    (5, 3500.00, '2026-06-10');

UPDATE Salarios
SET salario = 7000.00
WHERE funcionario_id = 4;

DELETE FROM Salarios
WHERE funcionario_id = 5;

DELETE FROM Funcionarios
WHERE id = 5;

SELECT
    Funcionarios.nome,
    Funcionarios.cargo,
    Salarios.salario
FROM Funcionarios
JOIN Salarios
ON Funcionarios.id = Salarios.funcionario_id;

SELECT
    Funcionarios.cargo,
    AVG(Salarios.salario) AS media_salarial
FROM Funcionarios
JOIN Salarios
ON Funcionarios.id = Salarios.funcionario_id
GROUP BY Funcionarios.cargo;

SELECT
    Funcionarios.nome,
    Funcionarios.cargo,
    Salarios.salario,
    Salarios.data_pagamento
FROM Funcionarios
JOIN Salarios
ON Funcionarios.id = Salarios.funcionario_id;