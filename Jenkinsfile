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
   stage('Report')
   {
   publishHTML(target:[allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'test-output', reportFiles: 'ExtentReposhot.html', reportName: 'Piplined HTML Report', reportTitles: ''])
   }
   
   stage('Email Notification')
   {
   
      mail bcc: '', body: '''This is Jenkins Job Notification !
      From : Jenkins
      To : Shubham

      Thanks...!''', cc: '', from: '', replyTo: '', subject: 'Jenkins DeclarativePipeline Job', to: 'javaselenium681@gmail.com'
   
   }
   
     
}
