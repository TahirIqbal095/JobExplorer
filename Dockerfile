FROM openjdk:17

ADD target/jobexplorer.jar jobexplorer.jar

ENTRYPOINT ["java", "-jar", "jobexplorer.jar"]

EXPOSE 8080