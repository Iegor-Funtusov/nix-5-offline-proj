export M2_HOME=apache-maven-3.8.1/
export MAVEN_HOME=apache-maven-3.8.1/
export PATH=$MAVEN_HOME/bin:$PATH

mvn clean compile install
echo
java -jar target/app-1.0-SNAPSHOT.jar
echo