def gv

pipeline {
    agent any 
    stages {
        stage('init') { 
            steps {
                bash '''
                

                #!/usr/bin/env bash

               

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
