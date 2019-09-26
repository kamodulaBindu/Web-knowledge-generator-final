FROM openjdk:11

ADD ./target/fetch-webpage-service-1.0-SNAPSHOT.jar /usr/src/fetch-webpage-service-1.0-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "fetch-webpage-service-1.0-SNAPSHOT.jar"]
