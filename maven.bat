@echo off
set MAVEN_OPTS=-Xmx2G -Dfile.encoding=UTF-8
set MAVEN_HOME=%~dp0maven\apache-maven-3.8.1
set PATH=%MAVEN_HOME%\bin;%PATH%
rem deleting CLASSPATH as a workaround for PLA-8702
set CLASSPATH=
cd unit_1 & mvn -version & cd maven & cd app & mvn clean install & java -jar target/app-1.0-SNAPSHOT.jar
