
#!/bin/bash

docker system prune -f
mvn clean
mvn clean package -DskipTests
docker build -t incluwed .
docker-compose up