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
                          subject: "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                          body: """<p>STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p><p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
                          recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']]
                        )
                }
            }

    }