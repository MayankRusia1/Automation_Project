package TS_017_DatePicker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.DatePicker;

public class TC_DF_001 
{
	WebDriver driver;

	boolean result;

	
	@Parameters("browser")
	@BeforeTest
	public void setup(@Optional("chrome") String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome Browser");
		}
		if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox Browser");
		}
		if(browsername.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge Browser");
		}
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}

	@Test
	public void DF_001()
	{
		DatePicker	baseClass = new DatePicker(driver);
		baseClass.scroll();
		if(baseClass.datepickerElement().isDisplayed())
		{
			System.out.println("Date picker element is successfully loaded on page & displayed");
		}
		else
		{
			System.out.println("Date picker element is NOT loaded on page & NOT displayed");		
		}
	}

	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.quit();
	}
}