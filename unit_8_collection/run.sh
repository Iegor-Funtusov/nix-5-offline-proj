#!/bin/bash

mvn clean compile package
echo
java -jar target/unit_8_collection-1.0-SNAPSHOT.jar