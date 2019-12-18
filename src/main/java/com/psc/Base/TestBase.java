package com.psc.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;

@Listeners(com.psc.Utility.TestNGListeners.class)

public class TestBase {
	

		public static WebDriver driver;
		public static Properties prop;
		//public static EventFiringWebDriver e_driver;
		//public static WebEventListener eventListener;
		//public static TestNGListeners TSTL;
		public static Logger log = Logger.getLogger(TestBase.class);
    
		
		
		public TestBase(){
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream("D:\\Presta_shop\\Presta_Shop_Cart\\src\\main\\resources\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}catch (NullPointerException e) {
				e.printStackTrace();
	
			}
		}


		public static void initialization()
		{
			String browserName = prop.getProperty("browser");


			if(browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "D:\\Presta_shop\\Presta_Shop_Cart\\chromedriver.exe");	
				driver = new ChromeDriver(); 
				
			}
			else if(browserName.equals("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "D:\\Presta_shop\\Presta_Shop_Cart\\geckodriver32bit.exe");	
				driver = new FirefoxDriver(); 
				
			}
			
			 /*e_driver = new EventFiringWebDriver(driver);
			  eventListener = new WebEventListener();
			 e_driver.register(eventListener);
			 driver = e_driver; */
			
			 driver.get(prop.getProperty("url"));
			
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			 driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		 
	}
	
	
	
	
	
	
	
	
	
	


