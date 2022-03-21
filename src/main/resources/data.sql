DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (id serial primary key, nome varchar(255), sobrenome varchar(255), email varchar(255), senha varchar(255),
    telefone varchar(255), cep varchar(255), estado varchar(255), cidade varchar(255), nascimento varchar(255)    
);

INSERT INTO usuarios(nome, sobrenome, email, senha, telefone, cep, estado, cidade, nascimento) values(
    'André', 'Talysson', 'atvdiniz@gmail.com', '1234567819', '83999519413', '58070510', 'PB', 'João Pessoa', '08/10/1999'
);