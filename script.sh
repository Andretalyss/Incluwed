#!/bin/bash

mvn clean
mvn clean package -DskipTests
docker build -t incluwed .