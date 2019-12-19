package com.psc.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.psc.Base.TestBase;
import com.psc.Pages.P_1_LoginPage;
import com.psc.Pages.P_5_Payment_Shipping;
import com.psc.Pages.P_6_Calender;

public class T_5_PaymentShippingTest extends TestBase
{

	
			
		   P_1_LoginPage loginPage;
		   P_5_Payment_Shipping PS;
		   P_6_Calender calender;
			public T_5_PaymentShippingTest()
			{
				super();

		        }
			
			
			@BeforeMethod
			public void setUp()
			{
				
			      initialization();
			      loginPage = new P_1_LoginPage();
			      PS = new P_5_Payment_Shipping();
			      calender = new P_6_Calender();
			      loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			}
			
			
			@Test(priority=1)
			public void ValidatModulesServicesTest()
			{
			   PS.VerifyModulesServices();
			}

			@Test(priority=2)
			public void ValidatModules_ThemesCatalogTest()
			{
				PS.VerifyModules_ThemesCatalog();
			}

			@Test(priority=3)
			public void ValidatPositionsTest()
			{
				PS.VerifyPositions();
			}
			
			@Test(priority=4)
			public void ValidatPaymentTest()
			{
				PS.VerifyPayment();
			}
			
			@Test(priority=5)
			public void ValidatAdminCarriersTest()
			{
				PS.VerifyAdminCarriers();
			}
			
			@Test(priority=6)
			public void ValidatPreferences()
			{
				PS.VerifyPreferences();
			}
			
			/*@Test(priority=7)
			public void ValidatMyshop()
			{
				PS.VerifyMyshop();
			}*/
			
			
			@Test(priority=8)
			public void CalenderPage()
			{
				PS.ClickOnCalender();
			}
			

			@AfterMethod
			public void ExitPath ()
			{
				driver.quit();
			}
		
	}

