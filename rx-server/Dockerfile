FROM openjdk:11
ADD target/rx-server-0.0.1-SNAPSHOT.jar /opt/spring/client-app.jar
EXPOSE 8081
WORKDIR /opt/spring/
ENTRYPOINT ["java", "-jar", "client-app.jar"]