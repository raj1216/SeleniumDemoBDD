package StepDefinition;


import PageObject.PimPage;
import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;


public class PimStepDef {
    static Logger logger = Logger.getLogger(PimStepDef.class);
    PimPage pimPage=new PimPage(DriverFactory.getDriver());
    @Given("Click on PIM link on left navigation pane")

    public void click_on_pim_link_on_left_navigation_pane() throws InterruptedException {
        pimPage.clickOnPimlink();
    }
    @When("click on Add Employee button")
    public void click_on_add_employee_button() {
pimPage.clickOnAddEmpButton();
    }
    @When("enter {string} in FirstName")
    public void enter_valid_data_in_first_name(String firstname) {
pimPage.enterFisrtName(firstname);
    }
    @When("enter {string} in LastName")
    public void enter_valid_data_in_last_name(String lastName) throws InterruptedException {
        pimPage.enterLastName(lastName);
    }
    @When("Enter {string} in {string} textbox")
    public void enter_in_employee_id_textbox(String value,String Label) {
try{

    pimPage.enterDataInTextbox(value,Label);}
catch (Exception e){
    logger.error("not able to locate element");
    Assert.fail("not able to locate textbox");
}



    }
    @When("click on save button")
    public void click_on_save_button() {
pimPage.clickSaveButton();
    }
    @Then("validate page title is {string}")
    public void validate_page_title_is(String string) throws InterruptedException {
pimPage.validatePageTitle(string);
    }
    @When("click on save button on personal details page")
    public void click_on_save_button_on_personal_details_page() throws InterruptedException {
        pimPage.clickSaveButtonOnPersonalDetails();
    }

}
