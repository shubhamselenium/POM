package com.psc.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.psc.Base.TestBase;

public class P_3_CustomerPage extends TestBase
{
	
        //Page Factory - OR:
		 
				@FindBy(xpath="//*[@id=\"maintab-AdminParentCustomer\"]/a/span")
				WebElement customer;


				//Initializing the Page Objects:
				public P_3_CustomerPage(){
					PageFactory.initElements(driver, this);
				}

				//Actions:
				public String VerifyHomePageTitle()
				{
					return driver.getTitle();
				}
				
				public void VerifyCustomer(String firstname,String lastname,String title) 
				{

					Actions mov = new Actions(driver);	
				      mov.moveToElement(customer).build().perform();
				     // driver.findElement(By.xpath("//*[@id=\"subtab-AdminCustomers\"]/a")).click();//then move to Sub_customer & click on sub_customer
				  
			            driver.findElement(By.id("subtab-AdminCustomers")).click();//then move to Sub_customer & click on sub_customer
			
			            driver.findElement(By.cssSelector("#page-header-desc-customer-new_customer > i")).click();//Click On Add customer
			
			            driver.findElement(By.id("gender_1")).click();//Check Radio Box as Mr.
			
			            driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstname);//Enter FirstName
			            driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastname);//Enter LastName
			            
			            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@javaclassesinpune.com");//Enter Username
			            driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("password");//Enter LastName//Enter Password
			
			            driver.findElement(By.cssSelector("#fieldset_0 > div.form-wrapper > div:nth-child(7) > div > span > label:nth-child(4)")).click();//Click On Slide button [No]
			            driver.findElement(By.cssSelector("#fieldset_0 > div.form-wrapper > div:nth-child(7) > div > span > label:nth-child(2)")).click();//Click On Slide button [Yes]
			
			            Select select = new Select(driver.findElement(By.name("id_default_group")));
			            select.selectByVisibleText(title);//selecting the options...Visitor
			
			            driver.findElement(By.xpath("//input[@id='groupBox_1']")).click();//checkBox..Check...Visitor
			            driver.findElement(By.xpath("//button[@type='submit']")).click();//Click On save button
				      

				}

				public void VerifyAdrresses() 
				{
					Actions mov = new Actions(driver);	
				      mov.moveToElement(customer).build().perform();
				      driver.findElement(By.xpath("//*[@id=\"subtab-AdminAddresses\"]/a")).click();
				      
				}

				public void VerifyGroups() 
				{
					Actions mov = new Actions(driver);	
				      mov.moveToElement(customer).build().perform();
				      driver.findElement(By.xpath("//*[@id=\"subtab-AdminGroups\"]/a")).click();
				      
				}
				
				public void VerifyShippingCarts() 
				{
					Actions mov = new Actions(driver);	
				      mov.moveToElement(customer).build().perform();
				      driver.findElement(By.id("subtab-AdminCarts")).click();
				      
				}

				public void VerifyCustomerServices() 
				{
					Actions mov = new Actions(driver);	
				      mov.moveToElement(customer).build().perform();
				      driver.findElement(By.id("subtab-AdminCustomerThreads")).click();
				      
				}

				public void VerifyContacts() 
				{
					Actions mov = new Actions(driver);	
				      mov.moveToElement(customer).build().perform();
				      driver.findElement(By.id("subtab-AdminContacts")).click();
				      
				}

				public void VerifyTittles() 
				{
					Actions mov = new Actions(driver);	
				      mov.moveToElement(customer).build().perform();
				      driver.findElement(By.id("subtab-AdminGenders")).click();
				      
				}
				
				
				public P_4_OrdersPage ClickOnOrdersPage() 
				{
					return new P_4_OrdersPage();
					
					
				}
				
				
				
		}



	
	


