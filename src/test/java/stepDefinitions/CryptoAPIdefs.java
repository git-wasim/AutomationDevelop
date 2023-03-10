package stepDefinitions;

import builderAPI.CryptoAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.BaseClass;

public class CryptoAPIdefs extends BaseClass{
	
	@Given("Convert Price From GTQ to GBP {string}")
	public void convert_price_from_gtq_to_gbp(String price) {
	    objApi = new CryptoAPI();
	    objApi.priceGTQtoGBP(prop.getProperty("apikey"), prop.getProperty("apivalue"), price);
	}

	@Then("Convert Price From GBP to DOGGE")
	public void convert_price_from_gbp_to_dogge() {
	    objApi.priceGBPtoDOGGE(prop.getProperty("apikey"), prop.getProperty("apivalue"));
	}

}
