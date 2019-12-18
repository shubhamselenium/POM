package com.psc.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.psc.Base.TestBase;
import com.psc.Pages.P_1_LoginPage;
import com.psc.Pages.P_2_HomePage;


public class T_1_LoginPageTest extends TestBase {
	
		P_1_LoginPage loginPage;
		P_2_HomePage homePage;
		
		//String SheetName="Data.xls";
		
		public T_1_LoginPageTest()
		{
			super();
		}

		
		@BeforeMethod
		public void setUp()
        {
			

			initialization();
			loginPage = new P_1_LoginPage();
			
		}

		@Test(priority=1)
		public void LoginPage_Tittle()
		{
			
			String title = loginPage.validateLoginPageTitle();
			System.out.println(title);
			String Expec ="SHOPCART > Administration panel (PrestaShop™)";
			Assert.assertEquals(title,Expec);
			
		}

		@Test(priority=2) 
		public void PSC_LogoImageTest()
		{

			boolean flag = loginPage.validatepscImage();
			Assert.assertTrue(flag);
			System.out.println(flag);
		
			
		}
			
		
		@Test(priority=3,dataProvider="login_Data")
		public void LoginTest(String un,String pass)
		{
			
			loginPage.login(un, pass);
			
			System.out.println("[....You Logged In Successfully....]");	
		}

        @DataProvider(name="login_Data")
		public Object[][] loginData()
               {
			 Object[][] data= new Object[1][2];
			 
			 data[0][0]="admin@javaclassesinpune.com";
			 data[0][1]="password";

			return data;
			
		}
		
		/*@Test(priority=3, dataProvider="getPSCTestData")
		public void loginTest(String un, String pwd)
                {
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			//homePage=loginPage.login(un, pwd);
		}*/
        
        @Test(priority=4)
		public void HomePage()
		{
			
		 loginPage.ClickOnHomePage();
			
		}

		@AfterMethod
		public void ExitPath ()
		{
			
			driver.quit();
			
		}

}
	
	
	
	


