#!/bin/bash

clear
mvn clean compile package
echo
java -jar target/unit_2_arithmetic-1.0-SNAPSHOT.jar
echo