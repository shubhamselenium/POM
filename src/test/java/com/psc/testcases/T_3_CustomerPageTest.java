package com.psc.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.psc.Base.TestBase;
import com.psc.Pages.P_1_LoginPage;
import com.psc.Pages.P_3_CustomerPage;
import com.psc.Pages.P_4_OrdersPage;
import com.psc.Utility.TestUtil;

	public class T_3_CustomerPageTest extends TestBase {
		
                String sheetName = "CSP";

		P_1_LoginPage loginPage;
		P_3_CustomerPage CustomerPage;
		P_4_OrdersPage OrdersPage;
		
		
		public T_3_CustomerPageTest()
		{
			super();

	        }
		
		
		@BeforeMethod
		public void setUp()
		{
			//log.info("************** Starting "+"CustomerPageTest"+" cases execution **************");

			initialization();
			loginPage = new P_1_LoginPage();
		    CustomerPage = new P_3_CustomerPage();
		    OrdersPage = new P_4_OrdersPage() ;
		    loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
		
		@Test(priority=1)
		public void VerifyHomePageCustomer()
		{
		    String CustomerPageTitle  = CustomerPage.VerifyHomePageTitle();
	        Assert.assertEquals(CustomerPageTitle,"SHOPCART > Administration panel (PrestaShop™)");
	        
	        
		}


		@DataProvider(name="getPSCTestData")
		public Object[][] getPSCTestData() 
	        {
		  Object data[][] =TestUtil.getTestData(sheetName);
		  return data;
	        }
		@Test(priority=2,dataProvider="getPSCTestData")
		public void ValidatCustomerTest(String Firstnam0,String Lastnam1,String Title2)
		{
			CustomerPage.VerifyCustomer(Firstnam0,Lastnam1,Title2);
		}


		@Test(priority=3)
		public void ValidatAddressesTest()
		{
			CustomerPage.VerifyAdrresses();
		}
		
		@Test(priority=4)
		public void ValidatGroupsTest()
		{
			CustomerPage.VerifyGroups();
		}
		
		@Test(priority=5)
		public void ValidatShippingCartsTest()
		{
			CustomerPage.VerifyShippingCarts();
		}
		
		@Test(priority=6)
		public void ValidatCustomerServicesTest()
		{
			CustomerPage.VerifyCustomerServices();
		}
		
		@Test(priority=7)
		public void ValidatContactsTest()
		{
			CustomerPage.VerifyContacts();
		}
		
		@Test(priority=8)
		public void validatTittlesTest()
		{
			CustomerPage.VerifyTittles();
		}
		
		
		@Test(priority=9)
	        public void OrdersPage () 
		{
			
			OrdersPage=CustomerPage.ClickOnOrdersPage();

		} 

		@AfterMethod
		public void ExitPath ()
		{
			driver.quit();
		}
		
		
		
			
	}


