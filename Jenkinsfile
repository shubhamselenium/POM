 def mvnHome 
 def mailRecipients = "javaselenium@gmail.com" 
 def jobName = currentBuild.fullDisplayName

node{
 
  
   stage('Git Checkout') 
     {    
          // Get some code from a GitHub repository.
      
             git 'https://github.com/shubhamselenium/POM'
    
          // Get the Maven tool.
      
             mvnHome = tool 'Maven_3.6.2'
                
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
          }
   
 
   stage('Result : Report')
   {
    
            publishHTML(target:[allowMissing: false, 
                       alwaysLinkToLastBuild: false, 
                       keepAll: true, 
                       reportDir: 'test-output', 
                       reportFiles: 'ExtentReposhot.html', 
                       reportName: 'Piplined HTML Report', 
                       reportTitles: 'Pipeline Job'])

    }   

   
   

   stage ('Email : Alert Notification')
   {

      mail bcc: '''${SCRIPT, template="groovy-html.template"}''', 
           body: "${env.BUILD_URL} has result ${currentBuild.result}", 
           cc: '', 
           from: '', 
           replyTo: "${mailRecipients}", 
           subject: "[Jenkins] ${jobName}", 
           to: "${mailRecipients}"
 
   }
   
   stage('Email : Report Notification')
        {
          
          emailext body: '''${SCRIPT, template="groovy-html.template"}''',
                 attachmentsPattern: '**/*.html',
                 subject: "[Jenkins] ${jobName}",
                 to: "${mailRecipients}",
                 replyTo: "${mailRecipients}",
                 attachLog: true,  
                 compressLog: true
          }
 
      stage('Trigger Schedul : Job ')
           {
            
                 cron('H */4 * * 1-5')
            
           }

  
  }
     

