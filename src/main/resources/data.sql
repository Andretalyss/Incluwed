CREATE TABLE usuarios(
    id serial primary key,
    nome varchar(255),
    sobrenome varchar(255), 
    cpf varchar(255),
    email varchar(255), 
    senha varchar(255),
    nascimento varchar(10),
    ddd int,
    numero varchar(20)
);

CREATE TABLE enderecos(
    endereco_id serial primary key,
    rua varchar(50),
    numero int,
    bairro varchar(50),
    cidade varchar(50),
    estado varchar(50)
);

CREATE TABLE telefones(
    telefone_id serial primary key,
    ddd int,
    numero varchar(30)
);

CREATE TABLE postagens(
    post_id serial primary key,
    titulo varchar(30),
    n_local varchar(40),
    endereco varchar(70),
    texto varchar(255),
    nota int,
    data_criacao TIMESTAMP 
);

-- CREATE TABLE postagens(
--     id serial primary key,
--     usuario int,
--     nomelocal varchar(255),
--     titulo varchar(255),
--     lugar varchar(255),
--     conteudo varchar(255),
--     nota int,
--     dataP TIMESTAMP,
--     CONSTRAINT usuarios FOREIGN KEY (usuario) REFERENCES usuarios (id)
-- );


-- CREATE TABLE lugares(
--     id serial primary key,
--     nome_local varchar(255),
--     nome_rua varchar(255),
--     acesso numeric(3,2),
--     data_cadastro TIMESTAMP,
--     numero_posts int ,
--     nota_total int
-- );