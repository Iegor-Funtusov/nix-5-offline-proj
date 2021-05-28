#!/bin/bash

mvn clean compile package
echo
java -jar target/module_1-1.0-SNAPSHOT.jar
echo