package com.psc.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.psc.Base.TestBase;

public class P_1_LoginPage extends TestBase {
	
	//Page Factory - OR:
		@FindBy(id="email")
		WebElement username;
 
		@FindBy(name="passwd")
		WebElement password;

		@FindBy(xpath="//*[@id=\"login_form\"]/div[3]/button/span")
		WebElement loginBtn;

		
		
		//@FindBy(xpath="//button[contains(text(),'Sign Up')]")
		//WebElement signUpBtn;

		@FindBy(id="shop-img")
		WebElement crmLogo;

		//Initializing the Page Objects:
		public P_1_LoginPage()
                {
			PageFactory.initElements(driver, this);
		}

		//Actions:
		public String validateLoginPageTitle()
                {
			return driver.getTitle();
		}

		public boolean validatepscImage()
		{
			return crmLogo.isDisplayed();
			
		} 
		
		public void  login(String un, String pwd)
        {
            	username.sendKeys(un);
	            password.sendKeys(pwd);
	            loginBtn.click();
	
         }


		public P_2_HomePage ClickOnHomePage()
         {
			return new P_2_HomePage();
		 }

}
