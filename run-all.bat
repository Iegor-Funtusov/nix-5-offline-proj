echo 1
javac src\main\java\com\example\Class1.java
cd src\main\java
java com.example.Class1


echo 2
cd ..\..\..\
call ant
java -jar myRunnableJAR.jar


echo 3
call mvn clean package
java -jar target\application-1.0-jar-with-dependencies.jar
