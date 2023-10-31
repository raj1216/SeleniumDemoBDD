package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsSauceDemo 
{

WebDriver driver;
	
	//CONSTRUCTOR
	public ProductsSauceDemo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//LOCATOR
	@FindBy(xpath="//div[@class='inventory_list']/div") public List<WebElement> products;
	@FindBy(xpath="//a[@class='shopping_cart_link']") public WebElement cart;
	
	//METHODS
	
	public void addProduct(String expected)
	{
		for(WebElement product:products)
		{
			String actualProduct=product.findElement(By.xpath("((child::div)[2]//div)[2]")).getText();
			
			if(actualProduct.equalsIgnoreCase(expected))
			{
				
				product.findElement(By.xpath("descendant::button[text()='Add to cart']")).click();
			}
		}
	}
	
	public void clickCartButton()
	{
		cart.click();
	}
}
