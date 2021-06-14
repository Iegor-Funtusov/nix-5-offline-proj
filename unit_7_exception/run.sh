#!/bin/bash

mvn clean compile package
echo
java -jar target/unit_7_exception-1.0-SNAPSHOT.jar
echo