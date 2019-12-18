node 
{
   def mvnHome
   def jdk
   stage('Git Checkout') 
     {     // for display purposes
          // Get some code from a GitHub repository
        
          git 'https://github.com/shubhamselenium/POM'
        
         // Get the Maven tool.
         // ** NOTE: This 'M3' Maven tool must be configured
         // **       in the global configuration.  
        
            mvnHome = tool 'Maven_3.6.2'
        
                
      }
   
    stage('Maven Build') 
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
   
     stage('Code Analysis')
            {
              steps
              {
                 input('Do You Want to Proceed?')
        
                 echo "Analyzing the code"
              }
            }
   
}
