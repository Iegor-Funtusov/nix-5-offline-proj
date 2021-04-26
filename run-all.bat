echo 1
javac -sourcepath src\ -cp libs\commons-collections4-4.4.jar:libs\commons-lang3-3.12.0.jar src\main\java\com\example\Class1.java
java -cp libs\commons-collections4-4.4.jar:libs\commons-lang3-3.12.0.jar -cp src\main\java com.example.Class1

echo 2
call ant
java -jar myRunnableJAR.jar

echo 3
call mvn clean package
java -jar target\application-1.0-jar-with-dependencies.jar
