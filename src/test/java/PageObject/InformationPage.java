package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage
{
WebDriver driver;
	
	//CONSTRUCTOR
	public InformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name") public WebElement firstName;
	@FindBy(id="last-name") public WebElement lastName;
	@FindBy(id="postal-code") public WebElement postalCode;
	@FindBy(id="continue") public WebElement cont;
	@FindBy(id="finish") public WebElement finish;
	
	
	
	public void enterFirstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	public void enterPostalCode(String postalcode)
	{
		postalCode.sendKeys(postalcode);
	}
	
	public void clickContinue()
	{
		cont.click();
	}
	
	public void clickFinish()
	{
		finish.click();
	}
	
	
	

}
