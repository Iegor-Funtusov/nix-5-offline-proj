@ECHO Hello!
call mvn clean compile
ECHO 5 11 22 0 33 -44 55 | call mvn exec:java -Dexec.mainClass="Main"

PAUSE