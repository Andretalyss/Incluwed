CREATE TABLE usuarios(
    id serial primary key,
    nome varchar(255),
    sobrenome varchar(255), 
    cpf varchar(255),
    email varchar(255), 
    senha varchar(255),
    nascimento varchar(10),
    token varchar(255)
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

-- INSERT INTO enderecos(rua, numero,bairro,cidade,estado) values(
--     'Teste', 444, 'testeb', 'testecidade','testeestado'
-- );

-- INSERT INTO telefones(ddd, numero) values(
--     83, '999519413'
-- );

-- INSERT INTO usuarios(nome, sobrenome, cpf, email, senha, telefone_id, endereco_id, nascimento) values(
--     'André', 'Talysson', '999.999.999.99','atv@gmail.com', '$2a$10$MGLlfZgOw1a9uEaqwSwvUe4ReynVlBiRFG7U/jbBnWkiECakvq.Zm', 1, 1, '1999/08/10'
-- );
