def gv

pipeline {
    agent any 
    stages {
        stage('init') { 
            steps {
                sh '''#!/bin/bash


                USER=ryuk156;
                a=$(curl -s https://api.github.com/users/$USER/repos | jq -r '.[].name') 
               repos=()

               for i in $a; do
                repos+=("$i")
               done

               for x in "${repos[@]}"; do
              echo $x 
              done




         '''
            }
        }
         stage('build') { 
            steps {
               script{
                def response = sh(script: 'curl -s https://api.github.com/users/$USER/repos', returnStdout: true)
                println(response[0])
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



