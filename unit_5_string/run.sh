#!/bin/bash

mvn clean compile package
java -jar application/target/application-1.0-SNAPSHOT.jar