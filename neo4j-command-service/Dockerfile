FROM openjdk:11

ADD ./target/neo4j-command-service-1.0.0.jar /usr/src/neo4j-command-service-1.0.0.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "neo4j-command-service-1.0.0.jar"]
