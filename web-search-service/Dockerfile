#FROM openjdk:11
#
#ADD ./target/web-search-services-1.0.0.jar app.jar
#
##WORKDIR usr/src
#
#ENTRYPOINT ["java","-jar", "app.jar"]

FROM openjdk:11

ADD ./target/web-search-service-1.0.0.jar /usr/src/web-search-service-1.0.0.jar
WORKDIR usr/src

ENTRYPOINT ["java","-jar", "web-search-service-1.0.0.jar"]