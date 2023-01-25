package pageObjects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CryptoAPI {
	
	public static String GBP;
	
	public void priceGTQtoGBP(String apiKey, String apiValue)
	{
		RestAssured.baseURI = "https://sandbox-api.coinmarketcap.com";
		
		Response res = RestAssured.given()
				.header(apiKey,apiValue)
				.queryParam("amount", "10000000")
				.queryParam("convert", "GBP")
				.queryParam("symbol", "GTQ")
				.when()
				.get("/v2/tools/price-conversion");
		
		GBP = res.then()
				 .extract()
				 .path("data.GTQ.quote.GBP.price")
				 .toString();
		
		System.out.println(GBP);
		
	}
	
	public void priceGBPtoDOGGE(String apiKey, String apiValue)
	{
		RestAssured.baseURI = "https://sandbox-api.coinmarketcap.com";
		
		Response res = RestAssured.given()
				.header(apiKey,apiValue)
				.queryParam("amount", GBP)
				.queryParam("convert", "DOGE")
				.queryParam("symbol", "GBP")
				.when()
				.get("/v2/tools/price-conversion");
		
		String DOGGE = res.then()
				.extract()
				.path("data.GBP.quote.DOGE.price")
				.toString();
		
		System.out.println(DOGGE);
		
	}
	

}
