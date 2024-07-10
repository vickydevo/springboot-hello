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
             sh "cd springboot-hello"
             sh   "mvn clean install"
            }
        }//stage2 
        stage ('DOCKER BUILD') {
            steps {
                sh "docker build -t spring-boot . "
            }
        }// stage3
        stage ('DOCKER LOGIN PUSH') {
            steps (
                withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
                    sh 'docker push spring-boot'
                }
            )
        }// stage4
        // stage ('DOCKER BUILD') {}// stage5
        // stage ('DOCKER LOGIN') {}// stage6
        // stage ('DOCKER BUILD') {}// stage7
        // stage ('DOCKER LOGIN') {}// stage8
    } //stages
}//pipeline close
