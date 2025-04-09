
# 🚀 Deploy Spring Boot Application on EC2 (Amazon Linux/Ubuntu)

## 🧰 Prerequisites

### Install Git
```bash
# Amazon Linux
sudo yum install git -y
```

### Install Maven
```bash
# Amazon Linux
sudo yum install maven -y
```

### Install Java 17

#### Amazon Linux
```bash
# Check current version
java --version

# Remove existing Java (if needed)
yum list installed | grep java
sudo yum remove <package-name>

# Install Amazon Corretto 17
sudo yum install java-17-amazon-corretto -y

# Configure default version
sudo update-alternatives --config java
```

#### Ubuntu
```bash
# Install OpenJDK 17
sudo apt install openjdk-17-jre-headless -y

# Remove older versions (if any)
sudo apt remove openjdk-8-jre-headless -y

# Configure default version
update-java-alternatives --list
sudo update-alternatives --config java
```

> **Note:** For Jenkins integration, add the Git executable path `/usr/bin/git` under Jenkins global tool configuration.

---

## ⬇️ Clone GitHub Repository

```bash
git clone https://github.com/vickydevo/springboot-hello.git
cd springboot-hello
```

---

## 🛠️ Build the Project with Maven

```bash
mvn clean install
```

---

## 🚀 Deploy the Spring Boot App

```bash
cd target
java -jar gs-spring-boot-0.1.0.jar
```

### Optional: Run in Background

```bash
nohup java -jar gs-spring-boot-0.1.0.jar > output.log 2>&1 &
ps aux | grep java
jobs
```

### Access the Application

```
http://<your-ec2-public-ip>:8080
http://localhost:8080
```

---

## 🐳 Run with Dockerfile (ARG & ENV)

```bash
docker build -t springboothello:v1 -f Dockerfile-with-ARG-ENV . --build-arg version=0.1.0
```


