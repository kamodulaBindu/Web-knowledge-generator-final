FROM openjdk:11

ADD ./target/movie-names-service-1.0.0.jar /usr/src/movie-names-service-1.0.0.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "movie-names-service-1.0.0.jar"]
