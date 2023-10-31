package Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import Utilities.ReadConfig;

public class Hooks 
{
    private DriverFactory driverFactory;
    private WebDriver driver;
    Properties prop;

    private ReadConfig configReader;
    
    @Before(order =0)
    public void getProperty()
    {
        configReader = new ReadConfig();
        prop =configReader.init_prop();

    }
    
    @Before(order =1)
    public void luanchBrowser()
    {
      String browsername=  prop.getProperty("browser");
      driverFactory = new DriverFactory();
      driver=driverFactory.init_driver(browsername);
      driver.get(getAppUrl());
      
    }
    
    @After(order =0)
    public void quitBrowser()
    {
        driver.quit();
    }
    
    @After(order =1)
    public void tearDown(Scenario sc)
    {
        if(sc.isFailed())
        {
            String scenarioName=sc.getName().replaceAll(" ","_");
            byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            sc.attach(sourcepath,"image/png",scenarioName);
        }
    }
    
    
    public String getAppUrl()
    {
    	String Url=prop.getProperty("url");
    	return Url;
    }
    
    public String getUsername()
    {
    	configReader = new ReadConfig();
        prop =configReader.init_prop();
    	String un=prop.getProperty("username");
    	return un;
    }
    
    public String getPassword()
    {
    	String pwd=prop.getProperty("password");
    	return pwd;
    }
    
    public String getFirstName()
    {
    	configReader = new ReadConfig();
        prop =configReader.init_prop();
    	String fName=prop.getProperty("first_name");
    	return fName;
    }
    
    public String getLastName()
    {
    	String lName=prop.getProperty("last_name");
    	return lName;
    }
    
    public String getPostalCode()
    {
    	String pcode=prop.getProperty("postal_code");
    	return pcode;
    }
    
    public String getMessage()
    {
    	String msg=prop.getProperty("message");
    	return msg;
    }
    
    
    
    


}
