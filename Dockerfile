FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

ADD target/jobexplorer.jar /app/jobexplorer.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "jobexplorer.jar"]