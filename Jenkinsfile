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
                    emailext (
                          subject: '$BUILD_STATUS',
                          body: 'This is a test email',
                          recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']]
                        )
                }
            }

    }