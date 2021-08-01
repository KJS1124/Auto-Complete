FROM maven:3.6.3-jdk-8
WORKDIR '/usr/src/myapp'
COPY . .
RUN mvn clean package
ENTRYPOINT ["java","-jar","./target/autocomplete-0.0.1-SNAPSHOT.jar"]
