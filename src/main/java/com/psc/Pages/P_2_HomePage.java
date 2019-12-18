package com.psc.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.psc.Base.TestBase;

public class P_2_HomePage extends TestBase {

	
	
		
		//Page Factory - OR:
	 
			@FindBy(xpath="//*[@id=\"maintab-AdminDashboard\"]/a/span")
			WebElement DshBrd;
			
			@FindBy(xpath="//*[@id=\"maintab-AdminCatalog\"]/a")
			WebElement Prdct_Catlog;
			
			@FindBy(xpath="//input[@id='virtual_product']")
			WebElement check_virtual_product;
			
			@FindBy(xpath="//input[@id='name_1']")
			WebElement Name;
			
			@FindBy(xpath="//*[@id=\"reference\"]")
			WebElement referencecode;
			
			@FindBy(xpath="//*[@id=\"ean13\"]")
			WebElement barcode;
			
			@FindBy(xpath="//*[@id=\"upc\"]")
			WebElement barcode1;
			
			@FindBy(css="#product-informations > div:nth-child(12) > div.col-lg-9 > span > label:nth-child(4)")
			WebElement Nobtn;
			
			@FindBy(css="#product-informations > div:nth-child(12) > div.col-lg-9 > span > label:nth-child(2)")
			WebElement Yesbtn;
			
			@FindBy(id="online_only")
			WebElement check;
			
			@FindBy(id="product-informations")
			WebElement savbtn;
	
			
			
			
			//Initializing the Page Objects:
			public P_2_HomePage()
			{
				PageFactory.initElements(driver, this);
			}

			//Actions:
			public String VerifyHomePageTitle()
			{
				return driver.getTitle();
			}
			
			public void VerifyDashBoard() 
			{
				Actions mov = new Actions(driver);	
			      mov.moveToElement(DshBrd).build().perform();
			 driver.findElement(By.xpath("//*[@id=\"maintab-AdminDashboard\"]/a/span")).click();
			
			}

			public void VerifyProducts(String title,String nam,String refer,String code, String code1) 
			{
				Actions mov = new Actions(driver);	
			    mov.moveToElement(Prdct_Catlog).build().perform();
			  
			    driver.findElement(By.id("subtab-AdminProducts")).click();

			    driver.findElement(By.cssSelector("#page-header-desc-product-new_product > i")).click();

			    check_virtual_product.click();
			    
				Name.sendKeys(nam);
				referencecode.sendKeys(refer);
				barcode.sendKeys(code);
				barcode1.sendKeys(code1);
				
				Nobtn.click();
				Yesbtn.click();
				
				Select select = new Select(driver.findElement(By.name("visibility")));
				select.selectByVisibleText(title);
				
				
				check.click();
				savbtn.click();
				
			}
			
			public void VerifyProductCategories() 
			{
				Actions mov = new Actions(driver);	
			      mov.moveToElement(Prdct_Catlog).build().perform();
			      driver.findElement(By.id("subtab-AdminCategories")).click();

			}
			
			public void VerifyMonitoring() 
			{
				Actions mov = new Actions(driver);	
			      mov.moveToElement(Prdct_Catlog).build().perform();
			      driver.findElement(By.id("subtab-AdminTracking")).click();
			      
			}

			public void VerifyProductAttributes() 
			{
				Actions mov = new Actions(driver);	
			      mov.moveToElement(Prdct_Catlog).build().perform();
			      driver.findElement(By.id("subtab-AdminAttributesGroups")).click();
			      
			}

			public void VerifyProductFeatures() 
			{ 
				Actions mov = new Actions(driver);	
			      mov.moveToElement(Prdct_Catlog).build().perform();
			      driver.findElement(By.id("subtab-AdminFeatures")).click();
			      
			}

			public void VerifyManufacturers() 
			{
				Actions mov = new Actions(driver);	
			      mov.moveToElement(Prdct_Catlog).build().perform();
			      driver.findElement(By.id("subtab-AdminManufacturers")).click();
			      
			} 

			public P_3_CustomerPage ClickOnCustomerPage() 
			{
				return new P_3_CustomerPage();
				
				
			}

			
	}


