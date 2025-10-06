pipeline {
    agent any
    tools {
        git 'git2'
        maven 'm3'
        jdk 'jdk17'
        
    }

    parameters {
        string(name: 'image', defaultValue: 'spring-boot', description: 'Enter docker image name')
        string(name: 'tag', defaultValue: 'v1', description: 'Enter docker image TAG')
    }

    environment {
        DOCKER_IMAGE = "${params.image}"
        DOCKER_TAG = "${params.tag}"
        // SONAR_HOST_URL = 'http://ec2-18-215-164-93.compute-1.amazonaws.com:9000'
        // SONAR_AUTH_TOKEN = credentials('squ_71b371877b164d811d4441d58b34a507d806a31a')
    }

    stages {
        stage('SCM CHECKOUT') {
            steps {
                git branch: 'main', url: 'https://github.com/vickydevo/springboot-hello.git'
            }
        }

        stage('Build Artifact') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Image') {
            steps {
                sh 'docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .'
            }
        }

        stage('DockerHub push') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'docker_cred',
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS'
                    )
                ]) {
                    sh '''
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker tag ${DOCKER_IMAGE}:${DOCKER_TAG} $DOCKER_USER/${DOCKER_IMAGE}:${DOCKER_TAG}
                        docker push $DOCKER_USER/${DOCKER_IMAGE}:${DOCKER_TAG}
                    '''
                }
            }
        }
    }
}

