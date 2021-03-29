def gv

pipeline {
    agent any 
    stages {
        stage('init') { 
            steps {
                sh '''
                

                #!/usr/bin/env bash

                shopt -s extglob

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
                echo 'build' 
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
