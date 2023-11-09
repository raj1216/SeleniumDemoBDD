package StepDefinition;

import java.io.IOException;

import Hooks.Hooks;
import PageObject.LoginSauceDemo;
import PageObject.OrangeHRM_LoginPage;
import Utilities.Utilities;
import driverFactory.DriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Login_StepDef extends DriverFactory
{
	//LoginSauceDemo loginPage = new LoginSauceDemo(DriverFactory.getDriver());
	OrangeHRM_LoginPage orangeloginPage = new OrangeHRM_LoginPage(DriverFactory.getDriver());
	
	Hooks hooks=new Hooks();
	


	
	@When("enter username and password")
	public void enter_username_and_password() throws Exception
	{
		
		
		orangeloginPage.enterUsername(hooks.getUsername());
		orangeloginPage.enterPassword(hooks.getPassword());
		
	}
	@When("click login")
	public void click_login()
	{
		orangeloginPage.clickLoginButton();
	}


	@When("user clicks on Logout link")
	public void user_clicks_on_logout_link()
	{
		orangeloginPage.clickLogOut();
	}

	

	@Then("close browser")
	public void close_browser() 
	{
	    getDriver().close();
	}

}
