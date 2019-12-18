/*package com.psc.ExtentReportt;

import java.io.File;
import java.io.IOException;

import org.testng.IReporter;
import org.testng.ITestResult;

import com.psc.Base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport extends TestBase implements IReporter {
	
	
   public static ExtentReports extent;
   public static ExtentTest logger;
	
	
	
	public void StartReport() 
	   {
		  extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/STMExtentReport.html",true);
         // extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentScreenshot.html", true);
	      extent.addSystemInfo("Host Name", "SELENIUM_with_JAVA")
		        .addSystemInfo("Environment", "Automation Testing")
		        .addSystemInfo("User Name", "SELENIUM@Java");
		  extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		  
		
	   }

		
	   public void getResult(ITestResult result) throws IOException 
	             {
		            if (result.getStatus() == ITestResult.FAILURE) 
		               {
                         logger.log(LogStatus.FAIL, result.getName());
                        //logger.log(LogStatus.FAIL,result.getThrowable());
                       //logger.log(LogStatus.FAIL, "Screen Shot : " + logger.addScreenCaptureFromPath(screenShot));
                       } 
		           
		           else if (result.getStatus() == ITestResult.SUCCESS)
                       {
                      logger.log(LogStatus.PASS, result.getName());
                     //test.pass("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
                       } 
                   else if (result.getStatus() == ITestResult.SKIP) 
                       {
                      logger.log(LogStatus.SKIP,"Test Case : " + result.getName() + " has been skipped");
               }
		        
		       
		            extent.flush();
		            extent.close();
		        
	}

}
*/