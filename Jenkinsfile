def gv

pipeline {
    agent any 
    stages {
        stage('init') { 
            steps {
                 sh '''
            #!/bin/bash
            
            a= curl   -H "Accept: application/vnd.github.v3+json"   https://api.github.com/users/ryuk156/repos
            echo '${a[0]}'

         '''
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
