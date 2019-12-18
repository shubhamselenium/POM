package com.psc.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.psc.Base.TestBase;

//public class OrdersPage extends TestBase 

public class P_4_OrdersPage extends TestBase 
{
	
	

	//Page Factory - OR:
 
		@FindBy(xpath="//*[@id=\"maintab-AdminParentOrders\"]/a/span")
		WebElement Orders;


		//Initializing the Page Objects:
		public P_4_OrdersPage()
                {
			PageFactory.initElements(driver, this);
		}

		//Actions
		
		public void VerifyOrders() 
		{
			Actions mov = new Actions(driver);	
		      mov.moveToElement(Orders).build().perform();
		      driver.findElement(By.xpath("//*[@id=\"subtab-AdminOrders\"]/a")).click();
		      
		}
		
		public void VerifyInvoices() 
		{
			Actions mov = new Actions(driver);	
		      mov.moveToElement(Orders).build().perform();
		      driver.findElement(By.xpath("//*[@id=\"subtab-AdminInvoices\"]/a")).click();
		      
		}

		public void VerifyMerchandiseReturns() 
		{
			Actions mov = new Actions(driver);	
		      mov.moveToElement(Orders).build().perform();
		      driver.findElement(By.xpath("//*[@id=\"subtab-AdminReturn\"]/a")).click();
		      
		}
		
		public void VerifyDeliverySlips() 
		{
			Actions mov = new Actions(driver);	
		      mov.moveToElement(Orders).build().perform();
		      driver.findElement(By.id("subtab-AdminDeliverySlip")).click();
		      
		}
		
		public void VerifyCreditSlips() 
		{
			Actions mov = new Actions(driver);	
		      mov.moveToElement(Orders).build().perform();
		      driver.findElement(By.id("subtab-AdminSlip")).click();
		      
		}
		
		public void VerifyStatuses() 
		{
			Actions mov = new Actions(driver);	
		      mov.moveToElement(Orders).build().perform();
		      driver.findElement(By.id("subtab-AdminStatuses")).click();
		      
		}
		
		public void VerifyOrderMessages() 
		{
			Actions mov = new Actions(driver);	
		      mov.moveToElement(Orders).build().perform();
		      driver.findElement(By.id("subtab-AdminOrderMessage")).click();
		      
		}
		
		public P_5_Payment_Shipping ClickOnPayment_Shipping() 
		{
			return new P_5_Payment_Shipping();
			
			
		}
		
}





