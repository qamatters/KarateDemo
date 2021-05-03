pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean test -DargLine=\'-Dkarate.env=e2e\' -Dkarate.options="--tags @Smoke" -Dtest=CucumberReport -DfailIfNoTests=false'
                junit  '**/target/surefire-reports/*.xml'

                  }
            }
        }

    }