pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'''
                 try {
                sh 'mvn clean test -DargLine=\'-Dkarate.env=e2e\' -Dkarate.options="--tags @Smoke" -Dtest=CucumberReport -DfailIfNoTests=false'
                     } finally {

                        junit  '**/target/surefire-reports/*.xml'

                    }
            }
        }

    }
}