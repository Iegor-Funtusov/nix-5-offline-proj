#!/bin/sh
javac -sourcepath ./consoleProject/src/main/java/ -d ./build/classes/ -cp ./libs/guava-30.1-jre.jar:./libs/commons-lang3-3.11.jar consoleProject/src/main/java/ua/com/Demo.java;
java -cp build/classes/:./libs/guava-30.1-jre.jar:./libs/commons-lang3-3.11.jar:. ua.com.Demo