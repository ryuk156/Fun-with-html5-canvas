



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
       curl "https://api.GitHub.com/repos/ryuk156/Fun-with-html5-canvas/statuses/$GIT_COMMIT?access_token=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" \
  -H "Content-Type: application/json" \
  -X POST \
  -d "{\"state\": \"success\",\"context\": \"continuous-integration/jenkins\", \"description\": \"Jenkins\", \"target_url\": \"http://aab2c258a4c9.ngrok.io/job/gsoc-test/$BUILD_NUMBER/console\"}"


    }
    failure {
        curl "https://api.GitHub.com/repos/ryuk156/Fun-with-html5-canvas/statuses/$GIT_COMMIT?access_token=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" \
  -H "Content-Type: application/json" \
  -X POST \
  -d "{\"state\": \"failure\",\"context\": \"continuous-integration/jenkins\", \"description\": \"Jenkins\", \"target_url\": \"http://aab2c258a4c9.ngrok.io/job/gsoc-test/$BUILD_NUMBER/console\"}"
    }
  }

}


