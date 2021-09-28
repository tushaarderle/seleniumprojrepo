package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class Ninja extends Base 
{

	WebDriver driver;
	Logger log;
	@Test(dataProvider="getloginData")
	public  void login(String email,String password,String expectedResult) throws IOException, InterruptedException 
	{

      log = LogManager.getLogger(Ninja.class.getName());
      
      LandingPage landingpage=new LandingPage(driver);
      landingpage.myAccountDropdown().click();
      log.debug("clicked on MyAccountDropdown");
      landingpage.loginOption().click();
      log.debug("clicked on loginoption");
      Thread.sleep(3000);
      
      LoginPage loginpage=new LoginPage(driver);
      loginpage.emailAddressField().sendKeys(email);
      log.debug("email address got entered");
      loginpage.passwordField().sendKeys(password);
      log.debug("password address got entered");
      loginpage.loginButton().click();
      log.debug("clicked on login button");
      
      
      AccountPage accountpage=new AccountPage(driver); 
      
      String actualResult = null;
      
      try
      
      {
    
    	  if( accountpage.editAccountInformationOption().isDisplayed())
    	  {
    		  actualResult="Successful";
    	  }
         
      }catch(Exception e)
      {
    	  actualResult="Failure"; 
      }
      Assert.assertEquals(actualResult,expectedResult);
      log.debug("login test got passed ");
      
	}
	
	
	@BeforeMethod
	public void openApplication() throws IOException
	{
		driver = initializeDriver();
		log.debug("Browser got launched");
	      driver.get(prop.getProperty("url"));
	      log.debug("navigated to URL ");

		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
		log.debug("browser got closed");
	}
	
	@DataProvider
	public Object[][] getloginData()
	{
	
		
		Object[][] data = {{"ninja@yopmail.com","Test@123","Successful"},{"dummytest@gmail.com","Test@123","Failure"}};
	    return data;
	    
	}
	
	

}
