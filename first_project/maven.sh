#! /bin/bash

mvn clean
mvn compile
mvn package
java -cp target/project-1.0-SNAPSHOT.jar:libs/guava-30.1.1-jre.jar:libs/lombok.jar com.Lapchenko_Kirill.project.Main
