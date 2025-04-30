Sure! Here’s the updated `README.md` content with explanations for `ps aux | grep java` and `jobs` included, formatted cleanly for GitHub or any documentation use

---

### ✅ Final `README.md`
```markdown
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

# Remove existing Java if any
yum list installed | grep java
sudo yum remove <package-name>

# Install Amazon Corretto 17
sudo yum install java-17-amazon-corretto -y

# Set default Java version
sudo update-alternatives --config java
```

#### Ubuntu
```bash
# Install Java 17
sudo apt install openjdk-17-jre-headless -y

# Remove older versions
sudo apt remove openjdk-8-jre-headless -y

# Configure Java version
update-java-alternatives --list
sudo update-alternatives --config java
```

> **Note:** For Jenkins integration, set Git executable path to `/usr/bin/git` in Jenkins > Global Tool Configuration.

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
```

### 🔎 Check Running Java Process

```bash
ps aux | grep java
```

- `ps aux`: Lists all running processes with details like user, CPU/memory usage, PID, etc.
- `grep java`: Filters output to show only Java-related processes.

### 📋 Check Background Jobs

```bash
jobs
```

- Shows a list of jobs running in the background of the current terminal session.
- Useful to check if your Spring Boot app is running after using `nohup`.

---

### 🌐 Access the Application on browser

```
http://<your-ec2-public-ip>:8080
http://localhost:8080
```

---

## 🐳 Run with Dockerfile (Using ARG & ENV)

```bash
docker build -t springboothello:v1 -f Dockerfile-with-ARG-ENV . --build-arg version=0.1.0
```


