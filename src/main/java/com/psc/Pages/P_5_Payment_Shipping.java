package com.psc.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.psc.Base.TestBase;

//public class OrdersPage extends TestBase 

public class P_5_Payment_Shipping extends TestBase
{
	
	
	//Page Factory - OR:
	 
			@FindBy(xpath="//*[@id=\"maintab-AdminParentModules\"]/a/span")
			WebElement Service;
			
			@FindBy(id="maintab-AdminParentShipping")
			WebElement Shipping;
			
			
			//Initializing the Page Objects:
			public P_5_Payment_Shipping()
			{
				PageFactory.initElements(driver, this);
			}

			//Actions
			public void VerifyModulesServices() 
			{
				Actions mov = new Actions(driver);	
			      mov.moveToElement(Service).build().perform();
			      driver.findElement(By.id("subtab-AdminModules")).click();
			      
			}
			
			public void VerifyModules_ThemesCatalog() 
			{
				Actions mov = new Actions(driver);	
			      mov.moveToElement(Service).build().perform();
			      driver.findElement(By.id("subtab-AdminAddonsCatalog")).click();
			      
			}
			public void VerifyPositions() 
			{
				Actions mov = new Actions(driver);	
			      mov.moveToElement(Service).build().perform();
			      driver.findElement(By.xpath("//*[@id=\"subtab-AdminModulesPositions\"]/a")).click();
			      
			}
			
			public void VerifyPayment() 
			{
				Actions mov = new Actions(driver);	
			      mov.moveToElement(Service).build().perform();
			      driver.findElement(By.xpath("//*[@id=\"subtab-AdminPayment\"]/a")).click();
			      
			}
			
			public void VerifyAdminCarriers() 
			{
				Actions mov = new Actions(driver);	
			      mov.moveToElement(Shipping).build().perform();
			      driver.findElement(By.id("subtab-AdminCarriers")).click();
			      
			}
			
			public void VerifyPreferences() 
			{
				Actions mov = new Actions(driver);	
			      mov.moveToElement(Shipping).build().perform();
			      driver.findElement(By.id("subtab-AdminShipping")).click();
			      
			}
			
			public void VerifyMyshop() 
			{
				driver.findElement(By.xpath("//span[contains(text(),'Connect to PrestaShop Marketplace account')]")).click();//Click on Connect to PrestaShop Marketplace account
				
				By css = By.cssSelector("#header_foaccess");
				WebElement element = driver.findElement(css);
				((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element);//Click On the My_Shop
				
				
			}
			

			public P_6_Calender ClickOnCalender() 
			{

				return  new P_6_Calender();
			
			}
			

}
