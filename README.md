# nix-5-offline-proj

# JDK build
Execute "javac -sourcepath src\ -cp libs\commons-collections4-4.4.jar:libs\commons-lang3-3.12.0.jar
src\main\java\com\example\Class1.java" to compile from project root folder

Execute "java -cp libs\commons-collections4-4.4.jar:libs\commons-lang3-3.12.0.jar -cp 
src\main\java com.example.Class1" to execute compiled class


# Ant build
Execute "ant" in project folder, it creates myRunnableJAR.jar at project root folder

# Maven build
mvn clean package - creates executable "application-1.0-jar-with-dependencies.jar" at "targer" folder
