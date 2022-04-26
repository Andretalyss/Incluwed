# Incluwed

  - BackEnd do serviço de auxílio ao deficiente físico.

## Instalando docker (Recomendado o uso de linux)
  Referência: https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04-pt

  Execute:
  
    sudo apt update
  
  Instale alguns pré-requisitos:
   
    sudo apt install apt-transport-https ca-certificates curl software-properties-common
    
  Adicione a chave GPG:
  
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
   
  Adicione o repositório docker ao APT:
  
    sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"
  
  Atualize seus repositórios:
  
    sudo apt update
   
  Instale o Docker:
  
    sudo apt install docker-ce
    
  Verifique se o serviço está rodando:
  
    sudo systemctl status docker
   

## Instalando docker-compose
  Execute:
  
    sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
  
  Definindo as permissões corretas:
  
    sudo chmod +x /usr/local/bin/docker-compose
  
  Verifique a instalação:
  
    docker-compose --version
  


## Subindo BackEnd e Banco de dados
  No diretório do projeto, onde se encontra o arquivo "docker-compose.yml", execute:
  
    docker-compose up -d
 
  Para validar os serviços, execute:
  
    docker ps
    
  O resultado deverá ser algo parecido com:
    
     CONTAINER ID   IMAGE                            COMMAND                  CREATED         STATUS         PORTS                                       NAMES
    a6b661fd2bb0   andrezin10/back-incluwed:1.0.0   "java -jar project.j…"   5 minutes ago   Up 5 minutes   0.0.0.0:8080->8080/tcp, :::8080->8080/tcp   incluwed_backend_1
    34d56e192985   postgres                         "docker-entrypoint.s…"   5 minutes ago   Up 5 minutes   0.0.0.0:5432->5432/tcp, :::5432->5432/tcp   postgres_db
    
    
