CREATE TABLE usuarios (
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

-- INSERT INTO usuarios(nome, sobrenome, email, senha, telefone, cep, estado, cidade, nascimento) values(
--     'André', 'Talysson', 'atvdiniz@gmail.com', '1234567819', '83999519413', '58070510', 'PB', 'João Pessoa', '08/10/1999'
-- );


DROP TABLE IF EXISTS postagens;

CREATE TABLE postagens(
    id serial primary key,
    usuario_id int,
    titulo varchar(255),
    conteudo varchar(255),
    nota int,
    dataP varchar(255),
    CONSTRAINT usuarios FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);

-- DROP TABLE IF EXISTS postagens_usuarios;

-- CREATE TABLE postagens_usuarios(
--     usuario_id int,
--     postagem_id int,
--     KEY usuarios (usuario_id),
--     KEY postagens (postagem_id),
--     CONSTRAINT usuario FOREIGN KEY usuario_id REFERENCES usuarios (id) ON DELETE CASCADE ON UPDATE,
--     CONSTRAINT postagens FOREIGN KEY postagem_id REFERENCES postagens (id) ON DELETE CASCADE ON UPDATE
-- );
