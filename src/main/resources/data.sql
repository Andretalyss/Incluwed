DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (id serial primary key, nome varchar(255), sobrenome varchar(255), email varchar(255), senha varchar(255),
    telefone varchar(255), cep varchar(255), estado varchar(255), cidade varchar(255), nascimento varchar(255)    
);

INSERT INTO usuarios(nome, sobrenome, email, senha, telefone, cep, estado, cidade, nascimento) values(
    'André', 'Talysson', 'atvdiniz@example.com', '1234567819', '839999999', '5838011', 'PB', 'João Pessoa', '12/11/1999'
);