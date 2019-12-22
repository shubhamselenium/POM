node 
{
  
   def mvnHome
  // def jdk
   stage('Git Checkout') 
     {     // for display purposes
          // Get some code from a GitHub repository
        
          git 'https://github.com/shubhamselenium/POM'
        
         // Get the Maven tool.
         // ** NOTE: This 'M3' Maven tool must be configured
         // **       in the global configuration.  
        
            mvnHome = tool 'Maven_3.6.2'
            //jdk = tool 'jdk'
                
      }
    stage('Code Analysis')
            {
               
        
                 echo "Analyzing the code"
              
            }
   
    stage('Unit Testing')
          {
        
             echo 'Performing Unit Testing'
    
          }
    
    
    stage('Integrationn Testing')
         {
        
           echo 'Performing Integrationn Testing'
    
         }
    
   stage('System Testing')
         {
        
       echo'Performing System Testing'
       
          }
   
    stage('System Release') 
         {
           // Run the maven build
            withEnv(["MVN_HOME=$mvnHome"]) 
            {
               if (isUnix()) 
                  {
                     sh '"$MVN_HOME/bin/mvn"  package'
                  } 
               else 
                  {
                     bat(/"%MVN_HOME%\bin\mvn" package/)
                  }
             }
             /*withEnv(["JAVA_HOME=$jdk"])
            {
               if (isUnix()) 
                  {  
                     
                     sh '"$JAVA_HOME/bin/java" -version'

                  } 
               else 
                  {
                     bat(/"%JAVA_HOME%\bin\java" -version/)
                  }
             }*/
    
          }
   
 
   stage('Result Report')
   {
 
            publishHTML(target:[allowMissing: false, 
                       alwaysLinkToLastBuild: false, 
                       keepAll: true, 
                       reportDir: 'test-output', 
                       reportFiles: 'ExtentReposhot.html', 
                       reportName: 'Piplined HTML Report', 
                       reportTitles: 'Pipeline Job'])
        
    }   

   
   

   stage ('Email Alert Notification')
   {
      always  
      {
      mail bcc: '', 
           body: "${env.BUILD_URL} has result ${currentBuild.result}", 
           cc: '', 
           from: '', 
           replyTo: 'javaselenium681@gmail.com', 
           subject: "Status of pipeline: ${currentBuild.fullDisplayName}", 
           to: 'javaselenium681@gmail.com'
      }
      
   }
   
   stage('Report Notification')
        {
       
          emailext attachLog: true, 
              attachmentsPattern: '**/test-output/*.html', 
              body: """<p>EXECUTED: Job <b>\'${env.JOB_NAME}:${env.BUILD_NUMBER})\'
                       </b></p><p>View console output at "<a href="${env.BUILD_URL}"> 
                       ${env.JOB_NAME}:${env.BUILD_NUMBER}</a>"</p> 
                       <p><i>(Build log is attached.)</i></p>""", 
              compressLog: true, 
              replyTo: 'javaselenium681@gmail.com', 
              subject: "Status: ${currentBuild.result?:\'SUCCESS\'} - 
                        Job \'${env.JOB_NAME}:${env.BUILD_NUMBER})\'", 
              to: 'javaselenium681@gmail.com'
   
       }
   
     
  
  }
     

