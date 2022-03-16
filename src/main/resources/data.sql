create table usuarios (
    id serial primary key,
    nome varchar(255) not null,
    sobrenome varchar(255) not null,
    email varchar(255) not null,
    senha varchar(255) not null,
    telefone varchar(255) not null,
    cep varchar(255), not null,
    estado varchar(255) not null,
    cidade varchar(255) not null,
    nascimento varchar(255) not null
);