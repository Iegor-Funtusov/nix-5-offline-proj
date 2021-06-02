#!/bin/sh

mvn install

cd target/

java -jar project-exception.jar