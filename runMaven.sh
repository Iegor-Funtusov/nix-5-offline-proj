#!/bin/sh

cd MavenProject/

mvn clean package

java -jar target/maven-project.jar

mvn clean