package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSauceDemo
{
	WebDriver driver;
	
	//CONSTRUCTOR
	public LoginSauceDemo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//LOCATORS
	@FindBy(xpath="//input[@type='text']") public WebElement Email;
	private By username = By.xpath("//input[@id='user-name']");
	@FindBy(xpath="//input[@type='password']") public WebElement Password;
	@FindBy(name="login-button") public WebElement LoginBtn;
	//@FindBy(xpath="//a[text()='Logout']") public WebElement LogOut;
	
	
	//METHODS
	
	public void  enterUsername(String user_name)
	{

        driver.findElement(username).sendKeys(user_name);
    }
	public void enterEmail(String email) throws Exception 
	{
		Thread.sleep(5000);
		//Email.clear();
		Email.sendKeys(email);
	}
	
	public void enterPassword(String pwd) 
	{
		
		//Password.clear();
		Password.sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		LoginBtn.click();
	}
	

	public void clickLogOut()
	{
		//LogOut.click();
	}
}
