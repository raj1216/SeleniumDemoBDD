package PageObject;

import driverFactory.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseSteps {
    public WebDriver driver= DriverFactory.getDriver();


    public BaseSteps() {
    }

    public void waitUntilClickable(WebElement webElement){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public void clickWithJS(WebElement webElement){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", webElement);
    }
    public void scrollUptoElement(WebElement webElement){
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        executor.executeScript("arguments[0].scrollIntoView();", webElement);
    }
    public  void highlightElement(WebElement webElement){
        JavascriptExecutor  js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid green'", webElement);
    }
    public void enterValueInTextBox(String value,WebElement webElement){
        scrollUptoElement(webElement);
        highlightElement(webElement);
        webElement.sendKeys(value);

    }

    public void validateTitle(WebElement webElement,String expectedTitle){
        String actualTitle=webElement.getText();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
