FROM openjdk:11

ADD ./target/domain-expert-authentication-service-1.0.0.jar /usr/src/domain-expert-authentication-service-1.0.0.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "domain-expert-authentication-service-1.0.0.jar"]
