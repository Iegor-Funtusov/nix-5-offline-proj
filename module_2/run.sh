#!/bin/bash

mvn clean compile package
echo
java -jar target/module_2-1.0-SNAPSHOT.jar
echo