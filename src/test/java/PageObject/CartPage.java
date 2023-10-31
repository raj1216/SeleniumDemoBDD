package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage
{

	
WebDriver driver;
	
	//CONSTRUCTOR
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//LOCATORS
	@FindBy(id="checkout") public WebElement checkout;
	
	
	public void clickChechkout()
	{
		checkout.click();
		
	}
	
}
