Comando SQL para criar o banco de dados: 

CREATE DATABASE sistema_alunos;

USE sistema_alunos;

CREATE TABLE aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    endereco VARCHAR(150),
    telefone VARCHAR(20),
    cpf VARCHAR(20),
    tipo_sanguineo VARCHAR(3),
    fator_rh CHAR(1),
    curso VARCHAR(50),
    contato_emergencia VARCHAR(100),
    telefone_emergencia VARCHAR(20),
    altura DOUBLE,
    peso DOUBLE,
    imc DOUBLE
);
