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

                    sh '''

                  // Default values
                  def colorName = 'RED'
                  def colorCode = '#FF0000'
                  def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
                  def summary = "${subject} (${env.BUILD_URL})"
                  def details = """<p>STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p><p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>"""

               // Override default values based on build status
               if (buildStatus == 'STARTED') {
                   color = 'YELLOW'
                   colorCode = '#FFFF00'
                  } else if (buildStatus == 'SUCCESS') {
                  color = 'GREEN'
                  colorCode = '#00FF00'
                 } else {
                 color = 'RED'
                 colorCode = '#FF0000'
             }
                    '''


                    emailext (
                          subject:subject ,
                          body:details ,
                          recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']]
                        )
                }
            }

    }