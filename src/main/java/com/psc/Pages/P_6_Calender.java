package com.psc.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.psc.Base.TestBase;

public class P_6_Calender extends TestBase
{
	
	//Page Factory - OR:
	 
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	WebElement Calender;
	
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	WebElement Apply;
	
	@FindBy(xpath="//button[@id='datepickerExpand']//i[@class='icon-caret-down']")
	WebElement cal;
	
	@FindBy(xpath="//input[@id='date-start']")
	WebElement Strt_Clr_Click;
	
	@FindBy(xpath="//input[@id='date-end']")
	WebElement End_Clr_Click;
	
	//Initializing the Page Objects:
	
	public P_6_Calender()
	{
		PageFactory.initElements(driver, this);
	}

	//Actions
	public void VerifyCalender() 
	{
		  Actions mov = new Actions(driver);	
	      mov.moveToElement(Calender).build().perform();
	   
	      cal.click();
	      
	      String Startdate = "2019-01-01";
	      String Enddate = "03-12-2018";
	      
	     String StrtdatArr[]= Startdate.split("-");
	     String EnddatArr[]= Enddate.split("-");

	     String Strt_Y=StrtdatArr[0];
	     String Strt_M=StrtdatArr[1]; 
	     String Strt_D=StrtdatArr[2];
	     
	     String End_Y=StrtdatArr[0];
	     String End_M=StrtdatArr[1];
	     String End_D=StrtdatArr[2];
	    
	     Strt_Clr_Click.clear();
	     Strt_Clr_Click.sendKeys(Strt_Y,Strt_M,Strt_D);
	     //Strt_Clr_Click.click();
	    /* Select select_Year = new Select(driver.findElement(By.xpath("//input[@id='date-start']")));
	     select_Year.selectByVisibleText("Strt"); */
	     
	     End_Clr_Click.clear();
	     End_Clr_Click.sendKeys(End_Y,End_M,End_D);
	     //End_Clr_Click.click();
	   /*  Select select_Month = new Select(driver.findElement(By.xpath("//input[@id='date-end']")));
	     select_Month.selectByVisibleText("End"); */
	     
	    /* Select select_Day = new Select(driver.findElement(By.xpath("//div[@class='datepicker1']//tr[1]//td[2]")));
	     select_Day.selectByVisibleText("Day"); 
	*/
	     Apply.click();
	     
	     
	
	}
	

}
