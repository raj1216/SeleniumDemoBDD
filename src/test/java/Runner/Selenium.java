package Runner;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium {

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		
		//WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//launch url
		driver.get("https://www.letskodeit.com/practice");
		
		//click radio btn
		driver.findElement(By.id("bmwradio")).click();
		
		//click checkbox
		driver.findElement(By.id("benzcheck")).click();
		
		//open new window
		driver.findElement(By.id("openwindow")).click();
		
		//switch to new window
		Set<String> w=driver.getWindowHandles();
		Iterator<String> w1=w.iterator();
		String pw=w1.next();
		String cw=w1.next();
		
		Thread.sleep(5000);
		driver.switchTo().window(cw);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Sign In']")).click();
	    //driver.close();
		Thread.sleep(5000);
	    driver.switchTo().window(pw);
	    Thread.sleep(5000);
		//switch new tab
	    Set<String> t=driver.getWindowHandles();
	    Iterator<String> t1=t.iterator();
	    String pt=t1.next();
	    String ct=t1.next();
       driver.findElement(By.xpath("//a[text()='Open Tab']")).click();
       Thread.sleep(5000);
       driver.switchTo().window(ct);
       driver.findElement(By.xpath("//a[text()='Sign In']")).click();
       driver.switchTo().window(pt);
       
       
	
	   //SELECT DROPDOWN	
       Select dd=new Select(driver.findElement(By.id("carselect")));
       dd.selectByIndex(1);
      System.out.println(dd.getFirstSelectedOption().getText());
      // dd.selectByValue("honda");
      // dd.selectByVisibleText("Honda");
      
      //MULTI SELECT
      Select mdd=new Select(driver.findElement(By.id("multiple-select-example")));
      mdd.selectByIndex(0);
      mdd.selectByIndex(1);
      mdd.selectByIndex(2);
      
      //IS ENABLED
      System.out.println("IS ENABLED "+driver.findElement(By.id("enabled-example-input")).isEnabled());
      driver.findElement(By.id("disabled-button")).click();
      System.out.println("IS ENABLED "+driver.findElement(By.id("enabled-example-input")).isEnabled());
      
      //IS DISPLAYED
      driver.findElement(By.id("hide-textbox")).click();
      System.out.println("IS DISPLAYED "+driver.findElement(By.id("displayed-text")).isDisplayed());
      driver.findElement(By.id("show-textbox")).click();
      System.out.println("IS DISPLAYED "+driver.findElement(By.id("displayed-text")).isDisplayed());
      
      //ALERT
      driver.findElement(By.id("name")).sendKeys("abc");
      driver.findElement(By.id("confirmbtn")).click();
      driver.switchTo().alert().accept();
      
      //ACTION CLASS
      WebElement btn=driver.findElement(By.id("mousehover"));
      driver.executeScript("arguments[0].scrollIntoView(true);", btn);
      Actions a=new Actions(driver);
      a.click(btn);
      
      
      
      
       
       
	}

}
