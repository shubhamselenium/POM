package com.psc.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.psc.Base.TestBase;
import com.psc.Pages.P_1_LoginPage;
import com.psc.Pages.P_4_OrdersPage;
import com.psc.Pages.P_5_Payment_Shipping;

public class T_4_OrdersPageTest extends TestBase {
		
		P_1_LoginPage loginPage;
		P_4_OrdersPage Orders;
		P_5_Payment_Shipping PS;
		
		public T_4_OrdersPageTest()
		{
			super();

	        }
		
		
		@BeforeMethod
		public void setUp()
		{
			
	        initialization();
	        loginPage = new P_1_LoginPage();
		    Orders = new P_4_OrdersPage();
		    PS = new P_5_Payment_Shipping();

		    loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		}
		
		
		@Test(priority=0)
		public void ValidatOrdersTest()
		{
			Orders.VerifyOrders();
		}

		@Test(priority=1)
		public void ValidatInvoicesTest()
		{
			Orders.VerifyInvoices();
		}

		@Test(priority=2)
		public void ValidatMerchandiseReturnsTest()
		{
			Orders.VerifyMerchandiseReturns();
		}
		
		@Test(priority=3)
		public void ValidatDeliverySlipsTest()
		{
			Orders.VerifyDeliverySlips();
		}
		
		@Test(priority=4)
		public void ValidatCreditSlipsTest()
		{
			Orders.VerifyCreditSlips();
		}
		
		@Test(priority=5)
		public void ValidatStatusesTest()
		{
			Orders.VerifyStatuses();
		}
		
		@Test(priority=6)
		public void ValidatOrderMessagesTest()
		{
			Orders.VerifyOrderMessages();
		}
		
		@Test(priority=7)
	        public void Payment_Shipping_Page () 
		{
			
			PS=Orders.ClickOnPayment_Shipping();

		} 

		@AfterMethod
		public void ExitPath ()
		{
			driver.quit();
		}
	
}