FROM openjdk:17-oracle
VOLUME /tmp
ADD target/naming-server-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8761
RUN bash -c 'touch app.jar'
ENTRYPOINT ["java", "-jar", "/app.jar", "-Dserver.port=8761"]