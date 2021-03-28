pipeline {
    agent any 
    stages {
        stage('init') { 
            steps {
                script{
                  load "script.groovy"
                }
              
            }
        }
        stage('Test') { 
            steps {
                echo 'test' 
            }
        }
        stage('Deploy') { 
            steps {
                echo 'deploy'
            }
        }
    }
}
