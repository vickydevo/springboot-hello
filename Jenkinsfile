pipeline{
    agent {label 'agent-sai'}
    stages{
        stage('GIT CHECKOUT'){
            steps{
                git url:"https://github.com/vickydevo/springboot-hello.git", branch:"main"
                
            }
            
        }
        stage('Build_Docker'){
            steps{
                sh "sudo docker build -t springboot:latest ."
                
            }
            
        }
        stage('Docker_push'){
            steps{
                
                withCredentials([usernamePassword(
                    credentialsId: "dockerhub_cred",
                    usernameVariable: "DOCKER_USER",
                    passwordVariable: 'DOCKER_PASS')]){
                sh '''
                echo "$DOCKER_PASS" |sudo docker login -u $DOCKER_USER --password-stdin
                sudo docker tag springboot:latest $DOCKER_USER/springboot:latest
                 sudo docker push $DOCKER_USER/springboot:latest
              '''  
                    }
            }
            
        }
        stage('Deploy'){
            steps{
                echo "git clone"
                
            }
            
        }
    }//stages
}//pipeline
