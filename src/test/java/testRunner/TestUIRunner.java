package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Automation\\AutomationDevelop\\src\\test\\resources\\Features\\homepage.feature",
		glue = "stepDefinitions",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","json:target/cucumber.json","html:target/cucumber-html-report",
				"junit:target/cucumber.xml"}
		)

public class TestUIRunner {

}
