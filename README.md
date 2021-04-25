console

javac -sourcepath ./src/ -d ./build/classes/ -cp ./libs/ commons-collections4-4.4.jar;./ commons-email-1.5.jar src/main/ua/com/firstClass.java


java -cp out/:libs/guava-30.1.1-jre.jar:libs/commons-collections4-4.4.jar;./ commons-email-1.5.jar com.exam.project.firstClass
