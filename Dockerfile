# Use openjdk as the base image
FROM openjdk:24-slim-bullseye

# Set the maintainer
LABEL maintainer="Your Name <your.email@example.com>"

RUN useradd -ms /bin/bash devopsuser
USER devopsuser 
# Set the working directory
WORKDIR /home/devopsuser 


# Install Maven and other dependencies
RUN  apt update -y \ 
    && apt install -y maven 
    

# Copy all files from the Spring Boot app directory to the container
COPY . /opt

# Run multiple commands
RUN mvn clean package

# Copy the newly created JAR file to the current directory
#COPY target/your-app.jar /opt/

# Set the entry point to run the Java application
ENTRYPOINT [ "java", "-jar", "./target/gs-spring-boot-0.1.0.jar" ]
