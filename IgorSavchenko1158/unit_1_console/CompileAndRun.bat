@ECHO hello
javac -cp ./libs/commons-lang3-3.12.0.jar;./libs/guava-30.1.1-jre.jar -sourcepath ./src -d classes src\Main.java
java -cp ./classes;./libs/commons-lang3-3.12.0.jar;./libs/guava-30.1.1-jre.jar Main
@PAUSE