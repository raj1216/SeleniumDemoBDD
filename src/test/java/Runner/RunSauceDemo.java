package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="src/test/resources/FeatureFiles/LoginSauceDemo.feature",
		glue={"StepDefinition","Hooks"},
		monochrome=true,
		tags="@sanity",
		plugin= {"pretty", "html:target/cucumber_reports.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class RunSauceDemo
{

}
