package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageCreateAccount 
{
	
	WebDriver driver;
	public LandingPageCreateAccount(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAccountDropdown;
     
	@FindBy(linkText="Register")
	WebElement createAccount;
	
	public WebElement myAccountDropdown()
	{
		return myAccountDropdown;
	}
	
	public WebElement createAccount()
	{
		return createAccount;
		
	}
	

}
