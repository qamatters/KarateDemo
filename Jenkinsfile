pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'JDK 1.8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean test -DargLine=\'-Dkarate.env=e2e\' -Dkarate.options="--tags @Smoke" -Dtest=CucumberReport -DfailIfNoTests=false'
                  }
            }
        }

         post {
                always {
                    cucumber '**/target/karate-reports/*.json'
              emailext
              body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
                }
            }

    }