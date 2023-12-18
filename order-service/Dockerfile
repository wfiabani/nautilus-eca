FROM openjdk:17-oracle
VOLUME /tmp/order-service
RUN ls
ADD target/order-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8020
RUN bash -c 'touch app.jar'
ENTRYPOINT ["java", "-jar", "/app.jar", "-Dserver.port=8020"]