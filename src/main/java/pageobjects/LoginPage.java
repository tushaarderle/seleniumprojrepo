package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
		
	}
	@FindBy(id="input-email")
	WebElement emailAddressField;
	
	@FindBy(id="input-password")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement eMail;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement Telephone;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@name='confirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agreetncCheckbox;
	

	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;
	
	public WebElement emailAddressField()
	
	{
		return emailAddressField;
	}
	
    public WebElement passwordField()
	
	{
		return passwordField;
	}
    
    public WebElement loginButton()
	
   	{
   		return loginButton;
   	}
    
    public WebElement firstName()
	
   	{
   		return firstName;
   	}
    public WebElement lastName()
	
   	{
   		return lastName;
   	}
    
	public WebElement eMail()
	{
		return eMail;
	}
	public WebElement Telephone()
	{
		return Telephone;
	}
	public WebElement Password()
	{
		return Password;
	}
	public WebElement confirmPassword()
	{
		return confirmPassword;
	}
	public WebElement agreetncCheckbox()
	{
		return agreetncCheckbox;
	}
	public WebElement continueButton()
	{
		return continueButton;
	}
	

}
