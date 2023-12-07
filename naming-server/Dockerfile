FROM openjdk:17-oracle
VOLUME /tmp
ADD target/naming-server-0.0.1-SNAPSHOT.jar naming-server.jar
EXPOSE 8761
RUN bash -c 'touch naming-server.jar'
ENTRYPOINT ["java", "-jar", "/naming-server.jar" "-Dserver.port=8761"]