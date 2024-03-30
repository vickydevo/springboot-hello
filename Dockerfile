# Use OpenJDK 8 as the base image
FROM openjdk:8

# Set the maintainer
LABEL maintainer="Your Name <your.email@example.com>"

# Set the working directory
WORKDIR /opt

# Copy all files from the Spring Boot app directory to the container
ADD . /opt

# Run multiple commands
RUN apt-get update \
    && apt-get install -y maven \
    && mvn clean install \
    && rm -rf /var/lib/apt/lists/*
    

# Copy the newly created JAR file to the current directory
COPY ./target/*.jar /opt

# Set the entry point to run the Java application
ENTRYPOINT ["java", "-jar", "/opt/gs-spring-boot-0.1.0.jar"]

# --------------------------------------------------------
# # Use Amazon Linux 2 as the base image
# FROM amazonlinux:2

# # Set the maintainer
# LABEL maintainer="Your Name <your.email@example.com>"

# # Set the working directory
# WORKDIR /opt

# # Install OpenJDK 8
# RUN amazon-linux-extras install java-openjdk8 -y

# # Install Maven and other dependencies
# RUN yum install -y maven \
#     && yum clean all

# # Copy all files from the Spring Boot app directory to the container
# COPY . /opt/

# # Run multiple commands
# RUN mvn clean install

# # Copy the newly created JAR file to the current directory
# COPY target/your-app.jar /opt/

# # Set the entry point to run the Java application
# ENTRYPOINT ["java", "-jar", "/opt/your-app.jar"]
