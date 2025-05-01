pipeline {
    agent any
    environment {
        DOCKER_IMAGE = 'java-spring'
        DOCKER_TAG = 'v1'
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
