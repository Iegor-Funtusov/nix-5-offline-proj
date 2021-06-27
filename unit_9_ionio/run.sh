#!/bin/bash

mvn clean compile package
echo
java -jar target/unit_9_ionio-1.0-SNAPSHOT.jar
echo