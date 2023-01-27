package builderAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CryptoAPI {

	public static String GBP;
	public static String DOGGE;

	public String apiDomain = "https://pro-api.coinmarketcap.com";
	public String apiEndpoint = "/v2/tools/price-conversion";

	public RequestSpecification apiAuth(String apiKey, String apiValue) {
		RestAssured.baseURI = apiDomain;
		RequestSpecification reqspec = RestAssured.given().header(apiKey, apiValue);
		return reqspec;
	}

	public void priceGTQtoGBP(String apiKey, String apiValue) {
		Response res = apiAuth(apiKey, apiValue)
				.queryParam("amount", "10000000")
				.queryParam("convert", "GBP")
				.queryParam("symbol", "GTQ")
				.when().get(apiEndpoint);

		GBP = res.then().extract().path("data[0].quote.GBP.price").toString();

		System.out.println(GBP);

	}

	public void priceGBPtoDOGGE(String apiKey, String apiValue) {
		Response res = apiAuth(apiKey, apiValue)
				.queryParam("amount", GBP)
				.queryParam("convert", "DOGE")
				.queryParam("symbol", "GBP")
				.when().get(apiEndpoint);

		DOGGE = res.then().extract().path("data[0].quote.DOGE.price").toString();

		System.out.println(DOGGE);

	}

}
