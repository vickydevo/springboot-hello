# spring-boot-hello..!!!
line1 
line2
line3
## Pre-requisites:

```bash
- Install Java amazon linux
         java --version
        yum list installed | grep java
        sudo yum remove <package-name>
        sudo yum install java-1.8.0-amazon-corretto
        sudo update-alternatives --config java  # change the java version

- Install Java ubuntu linux
        java -version
       sudo apt install openjdk-8-jre-headless
        sudo apt remove <openjdk-8-jre-headless>
        update-java-alternatives --list
        update-java-alternatives --list


- Install GIT
- Install Maven
```

## Clone code from github:

```bash
git clone https://github.com/vickydevo/springboot-hello.git
cd springboot-hello

```

## Build Maven Artifact:

```bash
mvn clean install
```

## Deploy springboot application:

```bash
java -jar gs-spring-boot-0.1.0.jar

http://localhost:8080/
```

## If you want to run ```Dockerfile-with-ARG-ENV file```

```bash
docker build -t springboothello:v1 -f Dockerfile-with-ARG-ENV . --build-arg version=0.1.0
```
