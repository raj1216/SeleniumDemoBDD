package BaseClass;

import org.apache.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Hooks.Hooks;
import PageObject.LoginPage;
import PageObject.LoginSauceDemo;
import Utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	
	public WebDriver driver;
	public static Logger log;
	
	
	public void initiate()
	{
		log=Logger.getLogger("BDDTestSteps");
		PropertyConfigurator.configure("log4j.properties");
		
		
		
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    log.info("Setup executed");
	    
	   
	}
	
	
	
}
