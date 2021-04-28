#!/bin/bash

if [[ -e "build/classes/*.class" ]]; then
    rm build/classes/*.class
fi

javac -sourcepath src/ -d build/classes/ -cp ./libs/jchardet-1.0.jar:./libs/json-smart-2.3.jar src/Main.java
java -cp build/classes/:./libs/jchardet-1.0.jar:./libs/json-smart-2.3.jar:. Main