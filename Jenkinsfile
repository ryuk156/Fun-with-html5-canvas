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
               script{
                gv.test()
                 sh "ls -l"
               }
            }
        }
        stage('Deploy') { 
            steps {
                script{
                gv.deploy()
               }
            }
        }
    }
}
