package com.psc.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.psc.Base.TestBase;
import com.psc.Pages.P_1_LoginPage;
import com.psc.Pages.P_2_HomePage;
import com.psc.Pages.P_3_CustomerPage;
import com.psc.Utility.TestUtil;


public class T_2_HomePageTest extends TestBase {
	
	
	P_1_LoginPage loginPage;
	P_2_HomePage homePage;
	P_3_CustomerPage CustomerPage;
	
	String sheetName="PSC";
	
	public T_2_HomePageTest()
	{
		super();

        }
	
	
	@BeforeMethod
	public void setUp()
	{
		///log.info("************** Starting "+"Home_Page_Test"+" cases execution **************");

		initialization();
		loginPage = new P_1_LoginPage();
		homePage = new P_2_HomePage();
	    CustomerPage = new P_3_CustomerPage();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=0)
	public void validatDashBoardTest()
	{

	      homePage.VerifyDashBoard();
		
	}
	
	@Test(priority=1)
	public void ValidatHomePageTitleTest()
	{

	    String homePageTitle  = homePage.VerifyHomePageTitle();
            Assert.assertEquals(homePageTitle,"SHOPCART > Administration panel (PrestaShop™)");
        
        }

	
	
	
	@DataProvider(name="getPSCTestData")
		public Object[][] getPSCTestData() 
	{
		Object data[][] =TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getPSCTestData")
	public void ValidatProductsTest(String title0,String nam1,String refer2,String code3,String code14 )
	{
		
		homePage.VerifyProducts(title0,nam1,refer2,code3,code14);
		
		
	}

	
	
	@Test(priority=3)
	public void ValidatProductCategoriesTest()
	{
		homePage.VerifyProductCategories();
	}
	
	@Test(priority=4)
	public void ValidatMonitoringTest()
	{
		homePage.VerifyMonitoring();
	}
	
	@Test(priority=5)
	public void ValidatProductAttributesTest()
	{
		homePage.VerifyProductAttributes();
	}
	
	@Test(priority=6)
	public void ValidatProductFeaturesTest()
	{
		homePage.VerifyProductFeatures();
	}
	
	@Test(priority=7)
	public void ValidatManufacturersTest()
	{
		homePage.VerifyManufacturers();
	}
	
	@Test(priority=8)
        public void CustomerPage () 
	{
		
		CustomerPage=homePage.ClickOnCustomerPage();

	} 

	

	@AfterMethod
	public void ExitPath ()
	{
		driver.quit();
	}
	
	
	
	
}