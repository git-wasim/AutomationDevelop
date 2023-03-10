package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
	public WebDriver driver;
	
	public Helper(WebDriver driver)
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
	
	public void scrollByJs(int width, int height)
	{
		((JavascriptExecutor)driver).executeScript("window.scrollBy("+width+","+height+")", "");
	}

	public void scrollIntoView(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
