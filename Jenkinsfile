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
        
                jdk = tool name: 'jdk'
                     env.JAVA_HOME = "${jdk}"

                     echo "jdk installation path is: ${jdk}"

                // next 2 are equivalents
               sh "${jdk}/bin/java -version"

             // note that simple quote strings are not evaluated by Groovy
            // substitution is done by shell script using environment
          sh '$JAVA_HOME/bin/java -version'
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
