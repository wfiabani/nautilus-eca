FROM openjdk:17-oracle
VOLUME /tmp/config-server
RUN ls
ADD target/config-server-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8888
RUN bash -c 'touch app.jar'
ENTRYPOINT ["java", "-jar", "/app.jar", "-Dserver.port=8888"]