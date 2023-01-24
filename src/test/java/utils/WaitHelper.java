package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	public WebDriver driver;
	
	public WaitHelper(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void WaitForElement(WebElement element,String conditions, Duration timeOutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		
		if(conditions.equalsIgnoreCase("visibility"))
		{
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		else if (conditions.equalsIgnoreCase("intercepted")) 
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		else
		{
			System.out.println("Web element not found");
		}
			
	}
	
	public void clickByJs(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}
	
	public void scrollByJs()
	{
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)", "");
	}

}
