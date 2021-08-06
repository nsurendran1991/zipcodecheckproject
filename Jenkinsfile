pipeline {

  agent any 
    stages {      

        stage("deploy") {
            steps {
                echo 'deploying...'
            }
          post {
                always { 

                    jiraSendDeploymentInfo site: 'nsurendran1991.atlassian.net', environmentId: 'prod', environmentName: 'prod', environmentType: 'production'

                }
            }
            
        }
    }

}

