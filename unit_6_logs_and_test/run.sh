#!/bin/bash

mvn clean compile package
echo
java -jar target/unit_6_logs_and_test-1.0-SNAPSHOT.jar
echo