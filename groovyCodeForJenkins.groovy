def notifyBuild(String buildStatus = 'STARTED') {
    // build status of null means successful
    buildStatus = buildStatus ?: 'SUCCESS'
    // Default values
    def colorName = 'RED'
    def colorCode = '#FF0000'
    def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    def summary = "${subject} (${env.BUILD_URL})"
    def report = "${env.BUILD_URL}" + "cucumber-html-reports/overview-features.html"
    def details =
            """
           <p>
           <b>Build_Nmae</b>:${env.JOB_NAME}
           <br>
           <b>BUILD_URL</b>:<a href='${env.BUILD_URL}'>${env.JOB_NAME}[${env.BUILD_NUMBER}]</a>
           <br>
           <b>Report_URL</b>:${report}
           <br>
           <b>Build_Status</b>:${buildStatus}
           </p>
           """

    def SummaryTable =
            """
           <!DOCTYPE html>
           <html>
           <head>
           <style>
           table, th, td {
             border: 1px solid black;
             text-align: center;
           }
            th {
                        color:green;
               }
           </style>
           </head>
           <body>
           $details
           <br>
           <b>Automation Summary Report:</b>
           <table>
             <tr>
               <th>Total_Scenarios</th>
               <th>Total_Pass_Scenarios</th>
               <th>Total_Fail_Scenarios</th>
             </tr>
             <tr>
               <td><font color="black">${Total_Scenarios}</td>
               <td><font color="green">${Total_Pass_Scenarios}</td>
               <td><font color="red">${Total_Fail_Scenarios}</td>
             </tr>
           </table>
           </body>
           </html>
           """
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
    emailext (
            subject: subject,
            body: SummaryTable,
            to: 'testqamatters@gmail.com',
            mimeType: 'text/html'
    )
}

return [notifyBuild:this.&notifyBuild]
