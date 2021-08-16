pipeline {

  agent any 
    stages {      

        stage("deploy") {
          
      stage("build") {
            steps {
                echo 'deploying...'
            }

          post {
                always { 

                    jiraSendBuildInfo site: 'nsurendran1991.atlassian.net'

                }
            }
            
      }
            steps {
                echo 'deploying...'
            }
          post {
                always {

                    jiraSendDeploymentInfo site: 'nsurendran1991.atlassian.net', enableGating: false, environmentId: 'jenkins-testing-prod-1', environmentName: 'staging', environmentType: 'staging'

                }
            }
            
        }
    }


}

