FROM openjdk:17-oracle
VOLUME /tmp
ADD target/api-gateway-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8765
RUN bash -c 'touch app.jar'
ENTRYPOINT ["java", "-jar", "/app.jar", "-Dserver.port=8765"]