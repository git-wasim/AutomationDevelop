package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
	
	List<String> value1;
	List<String> value2;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelp = new WaitHelper(driver);
		value1 = new ArrayList<String>();
		value2 = new ArrayList<String>();
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
	
	@FindBy(xpath="//div[@id='__next']//tbody/tr")
	List<WebElement> firstTableRows;
	
	@FindBy(xpath="//div[@id='__next']//tbody/tr/td[3]//a/div/div/p")
	List<WebElement> firstTableCols;
	
//	@FindBy(xpath="")
//	List<WebElement> secondTableRows;
//	
//	@FindBy(xpath="")
//	List<WebElement> secondTableCols;
//	
	@FindBy(xpath="//div[@id='__next']//table")
	WebElement table;
	
	public void showRows() 
	{
		waitHelp.WaitForElement(showRowsDrpDwn, intercepted, Duration.ofSeconds(20));
		waitHelp.clickByJs(showRowsDrpDwn);
		waitHelp.WaitForElement(selectRowCount, intercepted,Duration.ofSeconds(20));
		waitHelp.clickByJs(selectRowCount);	
	}
	
	public void filterAlgoWithPoW() throws InterruptedException
	{
		waitHelp.scrollIntoView(primaryFilter);
		waitHelp.WaitForElement(primaryFilter, intercepted, Duration.ofSeconds(20));
		waitHelp.scrollByJs(0,450);
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
	
	public int getRowCount()
	{
		return(firstTableRows.size());
	}
	
	public int getColCount()
	{
		return(firstTableCols.size());
	}
	
	public List<String> extractName()
	{
		for(int i=1;i<=getRowCount();i++)
		{
			
			WebElement element = table.findElement(By.xpath("//div[@id='__next']//table/tbody/tr["+i+"]/td[3]//a/div/div/p"));
			waitHelp.scrollIntoView(element);
			waitHelp.WaitForElement(element, intercepted, Duration.ofSeconds(20));
//			waitHelp.scrollByJs(0,70);
			String name = element.getText();
			value1.add(name);
			System.out.println(value1);
		}
		return value1;
	}
	
	public List<String> extractFilteredName()
	{
		waitHelp.scrollIntoView(addFilter);
		for(int i=1;i<=getRowCount();i++)
		{
			WebElement element = table.findElement(By.xpath("//div[@id='__next']//table/tbody/tr["+i+"]/td[3]//a/div/div/p"));
			waitHelp.scrollIntoView(element);
			waitHelp.WaitForElement(element, intercepted, Duration.ofSeconds(20));
//			waitHelp.scrollByJs(0,70);
			String name = element.getText();
			value2.add(name);
			System.out.println(value2);
		}
		return value2;
	}
	
	public void matchData()
	{
		for(int i=0;i<=value2.size();i++)
		{
			if(extractFilteredName().contains(extractName().get(i)))
			{
				System.out.println(extractFilteredName().get(i)+" "+"is present in main content");
			}
			else
			{
				System.out.println(extractFilteredName().get(i)+" "+"is not present in main content");
			}
		}
	}
	
}