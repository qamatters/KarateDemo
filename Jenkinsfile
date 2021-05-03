pipeline {
    agent any

    stages {
        stage('Build') {
            step {
                 try {
                sh 'mvn clean test -DargLine=\'-Dkarate.env=e2e\' -Dkarate.options="--tags @Smoke" -Dtest=CucumberReport -DfailIfNoTests=false'
                     } finally {

                        junit  '**/target/surefire-reports/*.xml'

                    }
            }
        }

    }
}