def gv

pipeline {
    agent any 
    stages {
        stage('init') { 
            steps {
                script{
                 gv= load "script.groovy"
                }
              
            }
        }
         stage('build') { 
            steps {
               script{
                gv.build()
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
