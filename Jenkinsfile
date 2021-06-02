node {

 properties(
    [
        parameters(
            [
             string(defaultValue: '@Smoke', name: 'Tags'),
             string(defaultValue: 'QA', name: 'Environment'),
             choice(name: 'Environment', choices:['QA', 'stage', 'dev'] ,defaultValue: 'e2e')
             ]
            )
    ]
  )
        stage('Build') {
         git branch: 'groovyChanges', url: 'https://github.com/qamatters/KarateDemo.git'
          try {
          currentBuild.displayName = "${params.Environment}";
          currentBuild.description = "${params.Tags}";

          if(isUnix()) {
                   def mvnHome = tool name: 'maven', type: 'maven'
                      tool name: 'JDK 1.8', type: 'jdk'
                      sh '''
                                          echo "PATH = ${PATH}"
                                          echo "M2_HOME = ${M2_HOME}"
                         '''
            /* ... existing build steps ... */

            println "-------------------------------------------------------------------------------------"
            println "Tag is ${params.Tags}"
            println "Environment is ${params.Environment}"

            println "----------------------------Print Environment variables in Linux machine---------------------------------------------------------"
            sh 'env'
            println "-------------------------------------------------------------------------------------"
            sh "${mvnHome}/bin/mvn clean test -DargLine=\'-Dkarate.env=${params.Environment}\' -Dkarate.options=\"--tags ${params.Tags}\" -Dtest=CucumberReport -DfailIfNoTests=false"

            } else {

            println "------------------------------Print Environment variables in Windows machine-------------------------------------------------------"
            bat 'set'
            println "-------------------------------------------------------------------------------------"
            bat "mvn clean test -DargLine=\'-Dkarate.env=${params.Environment}\' -Dkarate.options=\"--tags ${params.Tags}\" -Dtest=CucumberReport -DfailIfNoTests=false"
          }

        } catch (e) {
            // If there was an exception thrown, the build failed
            currentBuild.result = "FAILED"
            notifyBuild(currentBuild.result)
            throw e
          } finally {
          def fileexist = fileExists 'Summary.txt'
          if(fileexist)
          {
           String summaryFileContent =  readFile 'Summary.txt'
           println "${summaryFileContent}"
           Total_Scenarios   = summaryFileContent[0]
           print "Total_Scenarios: ${Total_Scenarios}"
           Total_Pass_Scenarios = summaryFileContent[1]
           print "Total_Pass_Scenarios: ${Total_Pass_Scenarios}"
           Total_Fail_Scenarios = summaryFileContent[2]
           print "Total_Fail_Scenarios= ${Total_Fail_Scenarios}"
          }
            cucumber '**/target/karate-reports/*.json'
            def externalMethod = load("groovyCodeForJenkins.groovy")
            externalMethod.notifyBuild(currentBuild.result)
          }
        }
       }

