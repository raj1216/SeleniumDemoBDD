package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.bouncycastle.asn1.cms.Time;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Hooks.Hooks;
import PageObject.LoginPage;
import PageObject.LoginSauceDemo;
import Utilities.Utilities;

import java.time.Duration;

public class DriverFactory {

    public WebDriver driver;
	public Utilities utilities;
	
	public static Logger log;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    
    public static WebDriver getDriver()
    {
       return tlDriver.get();
    }
    
    public  WebDriver init_driver(String browser)
    {
       log=Logger.getLogger("BDDTestSteps");
	   PropertyConfigurator.configure("log4j.properties");	
    	
    System.out.println("browser name is : "+browser);
    
    if(browser.equals("chrome"))
    {
        WebDriverManager.chromedriver().setup();
        tlDriver.set(new ChromeDriver());
    }
    
    else if (browser.equals("firefox"))
    {
        WebDriverManager.firefoxdriver().setup();
        tlDriver.set(new FirefoxDriver());
    }
    
    else 
    {

        System.out.println("please pass the correct value of browser :"+browser);
    }
  
    getDriver().manage().deleteAllCookies();
    getDriver().manage().window().maximize();
    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    return getDriver();
}
    
   
}
