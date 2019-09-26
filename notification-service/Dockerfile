FROM openjdk:11

ADD ./target/notification-service-1.0.0.jar /usr/src/notification-service-1.0.0.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "notification-service-1.0.0.jar"]
