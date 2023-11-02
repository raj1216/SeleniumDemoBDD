package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_LoginPage
{
	WebDriver driver;
	
	//CONSTRUCTOR
	public OrangeHRM_LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//LOCATORS
	@FindBy(name="username") public WebElement txt_username;
	@FindBy(name="password") public WebElement txt_password;
	@FindBy(xpath="//button[@type='submit']") public WebElement btn_login;
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']") public WebElement img_profile;
	@FindBy(xpath="//a[text()='Logout']") public WebElement btn_logut;
	
	//@FindBy(xpath="//a[text()='Logout']") public WebElement btn_logout;
	
	
	//METHODS
	public void enterUsername(String user_name) 
	{
		
		
		txt_username.sendKeys(user_name);
	}
	
	public void enterPassword(String pwd) 
	{
		
		
		txt_password.sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		btn_login.click();
	}
	

	public void clickLogOut()
	{
		img_profile.click();
		btn_logut.click();
	}
}
