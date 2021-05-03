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
--                junit  '**/target/karate-reports/*.json'

                  }
            }
        }

         post {
                always {
                    cucumber '**/target/karate-reports/karate-summary.html'
                }
            }

    }