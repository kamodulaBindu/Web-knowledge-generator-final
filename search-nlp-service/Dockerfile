FROM openjdk:11

ADD ./target/search-nlp-service-1.0.0.jar /usr/src/search-nlp-service-1.0.0.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "search-nlp-service-1.0.0.jar"]
