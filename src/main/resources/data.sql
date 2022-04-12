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
    nascimento varchar(255)
);

INSERT INTO usuarios(nome, sobrenome, cpf, email, senha, telefone, cep, estado, cidade, nascimento) values(
    'André', 'Talysson', '122.953.834-80','atvdiniz@gmail.com', '1234567819', '83999519413', '58070510', 'PB', 'João Pessoa', '08/10/1999'
);
INSERT INTO usuarios(nome, sobrenome, cpf, email, senha, telefone, cep, estado, cidade, nascimento) values(
    'Rafael', 'farias', '123.543.221-21', 'rafael@gmail.com', '1234567819', '83999519413', '58070510', 'PB', 'João Pessoa', '08/10/1999'
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
    dataP varchar(255),
    CONSTRAINT usuarios FOREIGN KEY (usuario) REFERENCES usuarios (id)
);

INSERT INTO postagens(usuario,titulo,nomelocal, lugar, conteudo, nota, dataP) values(1,'Testando','Shopping', 'Mangabeira', 'Vamos lá', 5, '08/10/2020');

DROP TABLE IF EXISTS lugares;

CREATE TABLE lugares(
    id serial primary key,
    nome_local varchar(255),
    nome_rua varchar(255),
    acesso int,
    data_cadastro varchar(255),
    numero_posts int ,
    nota_total int
);

-- INSERT INTO lugares(nome_local, nome_rua, acesso, data_cadastro) values('CI - UFPB', 'Rua dos escoteiros, 130, Mangaberia 7', 5,'10/02/2018');