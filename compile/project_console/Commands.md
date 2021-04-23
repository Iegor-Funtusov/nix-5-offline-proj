## Run compile ##
javac -sourcepath ./src/ -d ./build/classes/ -cp ./libs/commons-io-2.8.0.jar;./libs/commons-lang3-3.12.0.jar  src/ua/com/nix/Human.java
## Run program ##
java -cp build/classes;./libs/commons-lang3-3.12.0.jar;./libs/commons-io-2.8.0.jar  ua.com.nix.Human
