package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class HomepageDefinitions extends BaseClass {
	
@Given("User Launch Chrome Browser")
public void user_launch_chrome_browser() {
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers/chromedriver.exe");
    driver = new ChromeDriver();
    objHp = new HomePage(driver);
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
    
}

@When("User Opens The URL {string}")
public void user_opens_the_url(String url) {
    driver.get(url);
}

@And("Select Show Rows By Twenty")
public void select_show_rows_by_twenty() throws InterruptedException {
    objHp.showRows();
    Thread.sleep(2000);
}

@Then("Capture All Page Contents")
public void capture_all_page_contents() {
	objHp.extractName();
}

@When("Filter Data By Algorith-Pow")
public void filter_data_by_algorith_pow() throws InterruptedException {
   objHp.filterAlgoWithPoW();
}

@And("Click To Add filter")
public void click_to_add_filter() {
	objHp.addFilter();
  
}

@And("Toggle Mineable")
public void toggle_mineable() {
    objHp.toggleMineable();
}

@And("Select All Crytocurrencies")
public void select_all_crytocurrencies() {
   objHp.allCryptoCurr();
}

@And("Select Coins")
public void select_coins() {
    objHp.selectCoins();
}

@And("Select Price")
public void select_price() {
    objHp.selectPrice();
}

@And("Set Minimum Value {string} & Maximum Value {string}")
public void set_minimum_value_maximum_value(String minValue, String maxValue) {
    objHp.enterValues(minValue, maxValue);
}

@Then("Compare Page Content With Main Content")
public void compare_page_content_with_main_content() {
    objHp.extractFilteredName();
    objHp.matchData();
}

@And("Close Bowser")
public void close_bowser() {
    driver.quit();
}

}
