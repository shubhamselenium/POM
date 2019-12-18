package com.psc.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.psc.Base.TestBase;
import com.psc.Pages.P_1_LoginPage;
import com.psc.Pages.P_2_HomePage;
import com.psc.Pages.P_6_Calender;

public class T_6_CalenderTest extends TestBase
{
	
	   P_1_LoginPage loginPage;
	   P_2_HomePage homePage;
	   P_6_Calender Calendr;
	   
	   public T_6_CalenderTest()
		{
			super();

	    }
		
		
		@BeforeMethod
		public void setUp()
		{
			
			initialization();
			loginPage = new P_1_LoginPage();
			Calendr = new P_6_Calender();
		    loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			
		}
		
	


		@Test(priority=0)
		public void ValidatCalenderTest() throws InterruptedException
		{
			Calendr.VerifyCalender();
			
		}
		

		@AfterMethod
		public void ExitPath ()
		{
			driver.quit();
		}
		
		
		
				

}



