package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitHelper;

public class HomePage{
	
	public WebDriver driver;
	public WaitHelper waitHelp;
	
	String intercepted = "intercepted";
	String visibility = "visibility";
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelp = new WaitHelper(driver);
	}
	
//	@FindBy(xpath="(//*[local-name()='svg' and @class='sc-aef7b723-0 dgXMPo']"
//			+ "/*[local-name()='path'])[1]")
	
	@FindBy(xpath="//*[@id='__next']/div[1]/div[1]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div")
	WebElement showRowsDrpDwn;

	@FindBy(xpath="//*[@id=\"tippy-1\"]/div/div[1]/div/div/button[3]")
	WebElement selectRowCount;
	
	@FindBy(xpath="//div/button[contains(text(),'Filters')]")
	WebElement primaryFilter;
	
	@FindBy(xpath="//ul/li[2]/div/span/button/span")
	WebElement filterAlgorithm;
	
	@FindBy(xpath="//div[@class='tippy-content']/div/div/div[1]/ul/li[5]")
	WebElement algoPoW;
	
	@FindBy(xpath="//button[contains(text(),'+')]")
	WebElement addFilter;
	
	@FindBy(xpath="//label[@id='mineable']")
	WebElement toggleMineable;
	
	@FindBy(xpath="//button[contains(text(),'All Cryptocurrencies')]")
	WebElement selectAllCryptoCurr;
	
	@FindBy(xpath="//button[contains(text(),'Coins')]")
	WebElement selectCoins;
	
	@FindBy(xpath="//button[contains(text(),'Price')]")
	WebElement selectPrice;
	
	@FindBy(xpath="//div[@class='cmc-input-row']/input[1]")
	WebElement minValue;
	
	@FindBy(xpath="//div[@class='cmc-input-row']/input[2]")
	WebElement maxValue;
	
	@FindBy(xpath="//button[contains(text(),'Show results')]")
	WebElement btnResult;
	
	@FindBy(xpath="//button[contains(text(),'Apply Filter')]")
	WebElement btnApplyFilter;
	
	public void showRows() 
	{
		waitHelp.WaitForElement(showRowsDrpDwn, intercepted, Duration.ofSeconds(20));
		waitHelp.clickByJs(showRowsDrpDwn);
		waitHelp.WaitForElement(selectRowCount, intercepted,Duration.ofSeconds(20));
		waitHelp.clickByJs(selectRowCount);	
	}
	
	public void filterAlgoWithPoW() throws InterruptedException
	{
		waitHelp.WaitForElement(primaryFilter, intercepted, Duration.ofSeconds(20));
		waitHelp.scrollByJs();
		waitHelp.clickByJs(primaryFilter);
		waitHelp.WaitForElement(filterAlgorithm, intercepted, Duration.ofSeconds(30));
		filterAlgorithm.click();
		waitHelp.WaitForElement(algoPoW, intercepted, Duration.ofSeconds(30));
		waitHelp.clickByJs(algoPoW);
	}
	
	public void addFilter()
	{
		waitHelp.WaitForElement(addFilter, intercepted, Duration.ofSeconds(20));
		addFilter.click();
	}
	
	public void toggleMineable()
	{
		waitHelp.WaitForElement(toggleMineable, intercepted, Duration.ofSeconds(20));
		toggleMineable.click();
		waitHelp.WaitForElement(btnResult, intercepted, Duration.ofSeconds(10));
	}
	
	public void allCryptoCurr()
	{
		waitHelp.WaitForElement(selectAllCryptoCurr, intercepted, Duration.ofSeconds(20));
//		selectAllCryptoCurr.click();
		waitHelp.clickByJs(selectAllCryptoCurr);
	}
	
	public void selectCoins()
	{
		waitHelp.WaitForElement(selectCoins, intercepted, Duration.ofSeconds(20));
		selectCoins.click();
	}
	
	public void selectPrice()
	{
		waitHelp.WaitForElement(selectPrice, intercepted, Duration.ofSeconds(20));
		selectPrice.click();
	}
	
	public void enterValues(String min, String max)
	{
		waitHelp.WaitForElement(minValue, intercepted, Duration.ofSeconds(20));
		minValue.sendKeys(min);
		waitHelp.WaitForElement(maxValue, intercepted, Duration.ofSeconds(20));
		maxValue.sendKeys(max);
		waitHelp.WaitForElement(btnApplyFilter, intercepted, Duration.ofSeconds(20));
		waitHelp.clickByJs(btnApplyFilter);
		waitHelp.WaitForElement(btnResult, intercepted, Duration.ofSeconds(10));
		waitHelp.clickByJs(btnResult);
	}
	
	
}