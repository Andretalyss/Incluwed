CREATE TABLE usuarios(
    id serial primary key,
    nome varchar(255),
    sobrenome varchar(255), 
    email varchar(255), 
    senha varchar(255),
    telefone varchar(255), 
    cep varchar(255), 
    estado varchar(255), 
    cidade varchar(255), 
    nascimento varchar(255)
);

INSERT INTO usuarios(nome, sobrenome, email, senha, telefone, cep, estado, cidade, nascimento) values(
    'André', 'Talysson', 'atvdiniz@gmail.com', '1234567819', '83999519413', '58070510', 'PB', 'João Pessoa', '08/10/1999'
);
INSERT INTO usuarios(nome, sobrenome, email, senha, telefone, cep, estado, cidade, nascimento) values(
    'Rafael', 'farias', 'rafael@gmail.com', '1234567819', '83999519413', '58070510', 'PB', 'João Pessoa', '08/10/1999'
);

DROP TABLE IF EXISTS postagens;

CREATE TABLE postagens(
    id serial primary key,
    usuario int,
    titulo varchar(255),
    conteudo varchar(255),
    nota int,
    dataP varchar(255),
    CONSTRAINT usuarios FOREIGN KEY (usuario) REFERENCES usuarios (id)
);

INSERT INTO postagens(usuario, titulo, conteudo, nota, dataP) values(1,'Testando','Vamos lá',5,'08/10/2020');
INSERT INTO postagens(usuario, titulo, conteudo, nota, dataP) values(1,'Testando2','Vamos lá',3,'08/10/2020');
INSERT INTO postagens(usuario, titulo, conteudo, nota, dataP) values(2,'Testando3','Vamos lá',4,'08/10/2020');
INSERT INTO postagens(usuario, titulo, conteudo, nota, dataP) values(2,'Testando4','Vamos lá',1,'08/10/2020');
