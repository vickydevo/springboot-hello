pipeline {
    agent any
    stages {
        stage ('GIT CHECKOUT') {
            steps {
                git url:'https://github.com/vickydevo/springboot-hello.git', branch:'main'
            }
        }// stage1
        stage ('MAVEN BUILD') {
            steps {
             sh   "mvn clean install"
            }
        }//stage2 
        // stage ('DOCKER BUILD') {}
        // stage ('DOCKER LOGIN') {}
    } //stages
}//pipeline close