package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalPage 
{
WebDriver driver;
	
	//CONSTRUCTOR
	public FinalPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=" //h2[text()='Thank you for your order!']") public WebElement successfullMsg;
    @FindBy(xpath="//button[text()='Open Menu']") public WebElement menu;
    @FindBy(xpath="//a[text()='Logout']") public WebElement logout;
	
	public void verifyOrderMsg(String expected)
	{
		String actualMsg=successfullMsg.getText();
		
		if(expected.equals(actualMsg))
		{
			System.out.println("ORDER SUCCESSFULL");
		}
	}
	
	public void clickMenu()
	{
		menu.click();
	}
	
	public void clickLogout()
	{
		logout.click();	
	}

}
