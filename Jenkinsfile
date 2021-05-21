



pipeline {
    agent any 
    stages {
        stage('init') { 
            steps {
               
                echo 'init'
               
            }
        }
         stage('build') { 
            steps {
               echo 'build'
            }
        }

        stage('Test') { 
            steps {
              
                echo 'Test'
            }
        }
        stage('Deploy') { 
            steps {
                echo 'deploy'
            }
        }
    }
    
    post {
    success {
        setBuildStatus("Build succeeded", "SUCCESS");
    }
    failure {
        setBuildStatus("Build failed", "FAILURE");
    }
  }

}


