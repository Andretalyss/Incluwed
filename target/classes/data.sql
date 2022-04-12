DROP TABLE IF EXISTS usuarios;

CREATE TABLE usuarios(
    id serial primary key,
    nome varchar(255),
    sobrenome varchar(255), 
    cpf varchar(255),
    email varchar(255), 
    senha varchar(255),
    telefone varchar(255), 
    cep varchar(255), 
    estado varchar(255), 
    cidade varchar(255), 
    nascimento DATE
);

INSERT INTO usuarios(nome, sobrenome, cpf, email, senha, telefone, cep, estado, cidade, nascimento) values(
    'André', 'Talysson', '999.999.999.99','atvdiniz@gmail.com', '1234567819', '8399999999', '59999059', 'PB', 'João Pessoa', '1999-08-10'
);
INSERT INTO usuarios(nome, sobrenome, cpf, email, senha, telefone, cep, estado, cidade, nascimento) values(
    'Rafael', 'farias', '123.543.221-21', 'rafael@gmail.com', '1234567819', '83777777777', '59291020', 'PB', 'João Pessoa', '1999-08-10'
);

DROP TABLE IF EXISTS postagens;

CREATE TABLE postagens(
    id serial primary key,
    usuario int,
    nomelocal varchar(255),
    titulo varchar(255),
    lugar varchar(255),
    conteudo varchar(255),
    nota int,
    dataP TIMESTAMP,
    CONSTRAINT usuarios FOREIGN KEY (usuario) REFERENCES usuarios (id)
);

INSERT INTO postagens(usuario,titulo,nomelocal, lugar, conteudo, nota, dataP) values(1,'Testando','Shopping', 'Mangabeira', 'Vamos lá', 5, '2020-10-08');

DROP TABLE IF EXISTS lugares;

CREATE TABLE lugares(
    id serial primary key,
    nome_local varchar(255),
    nome_rua varchar(255),
    acesso numeric(3,2),
    data_cadastro TIMESTAMP,
    numero_posts int ,
    nota_total int
);

-- INSERT INTO lugares(nome_local, nome_rua, acesso, data_cadastro) values('CI - UFPB', 'Rua dos escoteiros, 130, Mangaberia 7', 5,'10/02/2018');