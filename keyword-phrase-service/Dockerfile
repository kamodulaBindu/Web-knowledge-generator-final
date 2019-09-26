FROM openjdk:11

ADD ./target/keyword-phrase-service-1.0.0.jar /usr/src/keyword-phrase-service-1.0.0.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "keyword-phrase-service-1.0.0.jar"]
