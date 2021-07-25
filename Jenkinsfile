properties([[$class: 'HudsonNotificationProperty',
  endpoints: [[urlInfo: [urlOrId: 'https://4672e004-ff75-4851-b73f-37e35ccce067.hello.atlassian-dev.net/x0/eyJjdHgiOiJhcmk6Y2xvdWQ6amlyYTo6c2l0ZS8xMWUwY2QzYy00ZjIwLTRhYjEtYjhhMS1mM2I0ZWMyZTc0ODgiLCJleHQiOiJhcmk6Y2xvdWQ6ZWNvc3lzdGVtOjpleHRlbnNpb24vNDY3MmUwMDQtZmY3NS00ODUxLWI3M2YtMzdlMzVjY2NlMDY3L2FjNWQ0NjA4LTAwYjYtNDkwZC04YjFiLTJlMGNjNWU1ZWVlMS9zdGF0aWMvd2ViaG9vay1yZWNlaXZlciJ9', urlType: 'PUBLIC']]]]]
 )


pipeline {
  agent any
  tools {
        maven 'maven'
       
    }
     environment {
        AWS_ACCESS_KEY_ID     = credentials('jenkins-aws-secret-key-id')
        AWS_SECRET_ACCESS_KEY = credentials('jenkins-aws-secret-access-key')
       ARTIFACT_NAME = 'calculator.jar'
        AWS_S3_BUCKET = 'forge-aws-us-n-virginia'
        AWS_EB_APP_NAME = 'zipcodecheckproject'
        AWS_EB_ENVIRONMENT = 'Zipcodecheckproject-env.eba-u7wuhppm.eu-central-1.elasticbeanstalk.com'
        AWS_EB_APP_VERSION = '64'
    } 
    stages {
        stage("build") {
            steps {
              echo 'Now Archiving... ${env.BUILD_ID}'
                sh 'mvn clean install'
              
            }
          post {
               success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.jar'
                 
                   }
              } 
            
        }       
        stage("deploy") {
            steps {
                echo 'deploying...'
                 sh 'aws configure set region us-east-1'
                 sh 'aws s3 cp ./target/zipcodecheckproject-0.0.1-SNAPSHOT.jar s3://forge-aws-us-n-virginia/zipcodecheckproject.jar'
                 sh 'aws elasticbeanstalk create-application-version --application-name $AWS_EB_APP_NAME --version-label $AWS_EB_APP_VERSION --source-bundle S3Bucket=$AWS_S3_BUCKET,S3Key=$ARTIFACT_NAME'
              sh 'aws elasticbeanstalk update-environment --application-name $AWS_EB_APP_NAME --environment-name $AWS_EB_ENVIRONMENT --version-label $AWS_EB_APP_VERSION''
            }
           
        }
    }
}
