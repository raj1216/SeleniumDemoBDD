package PageObject;

import driverFactory.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;

public class PimPage extends BaseSteps{

   public WebDriver driver;
    public PimPage(WebDriver driver)
    {

        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//a[@href='/web/index.php/pim/viewPimModule']") private WebElement link_PIM;
    @FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/h6") private WebElement pageTitle;
    @FindBy(xpath="//a[text()='Add Employee']") private WebElement btn_add_employee;
    @FindBy(xpath="//input[@name='firstName']") private WebElement txt_Firstname;
    @FindBy(xpath="//input[@name='lastName']") private WebElement txt_Lastname;
    @FindBy(xpath="//label[text()='Employee Full Name']") private WebElement empName;
    @FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-form-hint']//following-sibling::button") private WebElement btn_save_personaldeatils;
    @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']") private WebElement btn_save;

    public void clickOnPimlink() throws InterruptedException {
        highlightElement(link_PIM);
        Thread.sleep(2000);
        link_PIM.click();
    }
    public void enterDataInTextbox(String value,String lableName)  {


    By textbox= By.xpath("//label[text()='"+lableName+"']//parent::div//following-sibling::div/input");
    WebElement text = driver.findElement(textbox);
enterValueInTextBox(value,text);
    }
    public void validatePageTitle(String expectedTitle) throws InterruptedException {
        validateTitle(pageTitle,expectedTitle);

    }
    public void clickOnAddEmpButton(){
        highlightElement(btn_add_employee);
        btn_add_employee.click();
    }
    public void enterFisrtName(String firstname){
        highlightElement(txt_Firstname);
        txt_Firstname.sendKeys(firstname);

    }
    public void enterLastName(String lastname)  {
        highlightElement(txt_Lastname);
        txt_Lastname.sendKeys(lastname);
    }
    public void clickSaveButton(){
        highlightElement(btn_save);
        btn_save.click();
    }
    public void clickSaveButtonOnPersonalDetails() throws InterruptedException {
        scrollUptoElement(btn_save_personaldeatils);
//Thread.sleep(10000);
System.out.println(btn_save_personaldeatils.isEnabled());
waitUntilClickable(btn_save_personaldeatils);
        clickWithJS(btn_save_personaldeatils);


      //  btn_save_personaldeatils.click();
    }
}
