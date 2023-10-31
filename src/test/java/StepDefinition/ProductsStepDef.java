package StepDefinition;

import Hooks.Hooks;
import PageObject.CartPage;
import PageObject.FinalPage;
import PageObject.InformationPage;
import PageObject.ProductsSauceDemo;
import driverFactory.DriverFactory;
import io.cucumber.java.en.*;
public class ProductsStepDef extends DriverFactory
{
	ProductsSauceDemo productsPage=new ProductsSauceDemo(DriverFactory.getDriver());
	CartPage cartPage=new CartPage(DriverFactory.getDriver());
	InformationPage infPage=new InformationPage(DriverFactory.getDriver());
	FinalPage finalPage=new FinalPage(DriverFactory.getDriver());
	Hooks hooks=new Hooks();
	
	@And("add {string} to cart")
	public void addProduct(String x)
	{
		productsPage.addProduct(x);
	}
	
	@And("click on cart button")
	public void clcikCartBtn()
	{
		productsPage.clickCartButton();
	}
	
	@And("click on checkout button")
	public void clickCheckout()
	{
		cartPage.clickChechkout();
	}
	
	@When("enter required information and click continue")
	public void enterInformation()
	{
		infPage.enterFirstName(hooks.getFirstName());
		infPage.enterLastName(hooks.getLastName());
		infPage.enterPostalCode(hooks.getPostalCode());
		
		infPage.clickContinue();
	}
	
	@And("click finish")
	public void clickFinish()
	{
		infPage.clickFinish();
	}
	
	@Then("verify order is successfull")
	public void validateMsg()
	{
		finalPage.verifyOrderMsg(hooks.getMessage());
	}
	
	@And("logout")
	public void logout()
	{
		finalPage.clickMenu();
		finalPage.clickLogout();
	}

}
