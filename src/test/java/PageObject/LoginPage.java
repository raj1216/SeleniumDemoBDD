package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	
	//CONSTRUCTOR
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//LOCATORS
	@FindBy(xpath="//input[@id='user-name']") public WebElement Email;
	@FindBy(xpath="//input[@id='password']") public WebElement Password;
	@FindBy(xpath="//input[@id='login-button']") public WebElement LoginBtn;
	@FindBy(xpath="//a[text()='Logout']") public WebElement LogOut;
	
	
	//METHODS
	public void enterEmail(String email) 
	{
		
		Email.clear();
		Email.sendKeys(email);
	}
	
	public void enterPassword(String pwd) 
	{
		
		Password.clear();
		Password.sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		LoginBtn.click();
	}
	

	public void clickLogOut()
	{
		LogOut.click();
	}
}
