pipeline{
  agent any

   triggers
  { 
     cron('H/20 * * * *')
   }

  // def jdk
  stages{
          
          
   stage('Git Checkout') 
     {     // for display purposes
          // Get some code from a GitHub repository
       steps{
          git 'https://github.com/shubhamselenium/POM'
       }
         // Get the Maven tool.
         // ** NOTE: This 'M3' Maven tool must be configured
         // **       in the global configuration.  
        
            
            //jdk = tool 'jdk'
                
      }
    stage('Code Analysis')
            {
              steps{
        
                 echo "Analyzing the code"
              }
              
            }
   
    stage('Unit Testing')
          {
            steps{
             echo 'Performing Unit Testing'
            }
    
          }
    
    
    stage('Integrationn Testing')
         {
           steps {
           echo 'Performing Integrationn Testing'
           }
         }
    
   stage('System Testing')
         {
           steps {
       echo'Performing System Testing'
           }
          }
   
    stage('System Release') 
         {
           def mvnHome = tool 'Maven_3.6.2'
           steps{
      
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
            }}
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
   
 
   stage('Result : Report')
   {
     steps{
            publishHTML(target:[allowMissing: false, 
                       alwaysLinkToLastBuild: false, 
                       keepAll: true, 
                       reportDir: 'test-output', 
                       reportFiles: 'ExtentReposhot.html', 
                       reportName: 'Piplined HTML Report', 
                       reportTitles: 'Pipeline Job'])
     }
    }   

   
   

   stage ('Email : Alert Notification')
   {
     def mailRecipients = "javaselenium@gmail.com"
          def jobName = currentBuild.fullDisplayName

     steps{
      
      mail bcc: '''${SCRIPT, template="groovy-html.template"}''', 
           body: "${env.BUILD_URL} has result ${currentBuild.result}", 
           cc: '', 
           from: '', 
           replyTo: "${mailRecipients}", 
           subject: "[Jenkins] ${jobName}", 
           to: "${mailRecipients}"
     }    
      
   }
   
   stage('Email : Report Notification')
        {
           def mailRecipients = "javaselenium@gmail.com"
          def jobName = currentBuild.fullDisplayName
          steps{
         
         
          emailext body: '''${SCRIPT, template="groovy-html.template"}''',
                 attachmentsPattern: '**/*.html',
                 subject: "[Jenkins] ${jobName}",
                 to: "${mailRecipients}",
                 replyTo: "${mailRecipients}",
                 attachLog: true,  
                 compressLog: true
          }
       }
  }

  
  }
     

