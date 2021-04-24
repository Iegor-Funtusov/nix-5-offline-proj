# Команды для консоли
`javac -sourcepath ./src -d build/classes -cp ./libs/commons-lang3-3.12.0.jar;./libs/commons-io-2.4.jar src/ua/com/alevel/Game.java` - компиляция

`java -cp build/classes/;./libs/commons-lang3-3.12.0.jar;./libs/commons-io-2.4.jar;. ua.com.alevel.Game` - команда для запуска с библиотекой

#Команды для Ant
`ant clean` - очистить build

`ant build` - сбилдить классы

`ant jar` - создать jar

`ant run` - запустить ant

#Команды для Maven

`mvn clean install`

`mvn compile`

`java -jar target/app-1.0-SNAPSHOT.jar` - для запуска jar

