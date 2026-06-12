CREATE DATABASE ebac_jdbc;

USE ebac_jdbc;

CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    email VARCHAR(100)
);