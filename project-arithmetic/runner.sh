#!/bin/sh

mvn compile

mvn exec:java -Dexec.mainClass="ua.com.Demo"