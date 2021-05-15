#! /bin/bash

rm -rf out/*

javac -sourcepath src/ -d out/ -cp libs/guava-30.1.1-jre.jar:libs/lombok.jar  src/com/Lapchenko_Kirill/project/*.java

java -cp out/:libs/guava-30.1.1-jre.jar:libs/lombok.jar com.Lapchenko_Kirill.project.Main
