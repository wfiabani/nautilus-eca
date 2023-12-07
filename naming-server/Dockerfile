FROM openjdk:17-oracle
VOLUME /tmp2
ADD target/naming-server-0.0.1-SNAPSHOT.jar app2.jar
EXPOSE 8761
RUN bash -c 'touch app2.jar'
ENTRYPOINT ["java", "-jar", "/app2.jar" "-Dserver.port=8761"]