package StepDefinition;

import java.io.IOException;

import Hooks.Hooks;
import PageObject.LoginSauceDemo;
import Utilities.Utilities;
import driverFactory.DriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDef extends DriverFactory
{
	LoginSauceDemo loginPage = new LoginSauceDemo(DriverFactory.getDriver());
	Hooks hooks=new Hooks();
	


	@When("enter url {string}")
	public void enter_url(String url)
	{

		driver.get(url);
		System.out.print(driver.getTitle());
	    log.info("launched chrome");
	}

	@When("enter Email {string} and Password {string}")
	public void enter_email_and_password(String email, String pwd) throws Exception
	{
		System.out.print("asdf");
		
	    loginPage.enterEmail(hooks.getUsername());
	    loginPage.enterPassword(hooks.getPassword());
		
	}

	@When("click login")
	public void click_login() 
	{
	    loginPage.clickLoginButton();
	}

	@Then("page tile should be {string}")
	public void page_tile_should_be(String expectedTitle) 
	{
		
	    String actualTitle=getDriver().getTitle();
	    
	    if(actualTitle.equals(expectedTitle))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}

	@When("user clicks on Logout link")
	public void user_clicks_on_logout_link()
	{
	    loginPage.clickLogOut();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) 
	{
         String actualTitle=driver.getTitle();
	    
	    if(actualTitle.equals(expectedTitle))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}

	@Then("close browser")
	public void close_browser() 
	{
	    getDriver().close();
	}
	
	
	public void close(Scenario sc) throws IOException
	{
		utilities=new Utilities();

		if(sc.isFailed()==true)
		{
			utilities.takeScreenshot(sc.getName(),driver);
		}
		
		driver.quit();
	}


}
