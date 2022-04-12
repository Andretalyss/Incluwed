#!/bin/bash

mvn clean
mvn clean package -DskipTests
sudo docker build -t incluwed .