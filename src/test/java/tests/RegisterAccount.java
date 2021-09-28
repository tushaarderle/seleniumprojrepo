package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LandingPageCreateAccount;
import pageobjects.LoginPage;
import resources.Base;

public class RegisterAccount extends Base 

{
   WebDriver driver;
   
   @Test(dataProvider="getcreateAccountData")
   
   public void createaccount(String fname,String lname,String email,String telehone,String pass,String confirmpass) throws InterruptedException
   {
	   
	      LandingPageCreateAccount landingpagecreateaccount=new LandingPageCreateAccount(driver);
	      landingpagecreateaccount.myAccountDropdown().click();
	      landingpagecreateaccount.createAccount().click();
	      Thread.sleep(3000);

	      LoginPage loginpage=new LoginPage(driver);
	      loginpage.firstName().sendKeys(fname);
	      loginpage.lastName().sendKeys(lname);
	      loginpage.eMail().sendKeys(email);
	      loginpage.Telephone().sendKeys(telehone);
	      loginpage.Password().sendKeys(pass);
	      loginpage.confirmPassword().sendKeys(confirmpass);
	      loginpage.agreetncCheckbox().click();
	      loginpage.continueButton().click();
	      
	      
	      
   }
   @BeforeMethod
	public void openApplication() throws IOException
	{
		driver = initializeDriver();
	     driver.get(prop.getProperty("url"));
	
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
    
	@DataProvider
	public Object[][] getcreateAccountData()
	{
	
		
		Object[][] data = {{"firstNameTest","LastNameTest","emailtest@email.com","7797777777","pass@123","pass@123"},{"firstNameTest1","LastNameTest1","emailtest1@email.com","7797777777","pass@123","pass@123"}};
	    return data;
	    
	}
	



}
