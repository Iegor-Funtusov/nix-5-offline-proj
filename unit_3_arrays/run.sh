#!/bin/bash

clear
mvn clean compile package
echo
java -jar target/unit_3_arrays-1.0-SNAPSHOT.jar
echo