@ECHO Hello!
call mvn clean compile
call mvn exec:java -Dexec.mainClass="Main"
PAUSE