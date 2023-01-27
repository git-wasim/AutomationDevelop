package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import builderAPI.CryptoAPI;
import pageObjects.HomePage;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public HomePage objHp;
	public CryptoAPI objApi;
	
	public BaseClass()
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test"
					+ "/resources/Properties/config.properties");
			prop.load(fis);
		} catch(IOException e){
			e.getMessage();	
		}
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers/chromedriver.exe");
			    driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers/geckodriver.exe");
			    driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
	}

}
