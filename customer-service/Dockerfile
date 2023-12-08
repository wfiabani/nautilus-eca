FROM openjdk:17-oracle
VOLUME /tmp
#ADD target/customer-service-0.0.1-SNAPSHOT.jar app.jar
ADD /tmp/customer-service.jar /customer-service.jar
EXPOSE 8010
RUN bash -c 'touch app.jar'
ENTRYPOINT ["java", "-jar", "/customer-service.jar" "-Dserver.port=8010"]