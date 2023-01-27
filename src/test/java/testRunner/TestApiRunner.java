package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "../AutomationDevelop/src/test/resources/Features/api.feature",
		glue = "stepDefinitions",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","json:target/cucumber-api.json","html:target/cucumber-html-report/api.html",
				"junit:target/cucumber-api.xml"}
		)

public class TestApiRunner {
	

}
