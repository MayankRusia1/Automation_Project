package TS_011_AlertBoxes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.AlertBox;

public class TC_AB_001 
{
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox browser is launched");
		}

		if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge browser is launched");
		}

		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome browser is launched");
		}

		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}


	@Test(description = "Cross browser testing")
	public void PT_001()
	{
		AlertBox baseClass = new AlertBox(driver);
		baseClass.scroll();
		
		if(baseClass.alertButtondisplayed())
		{
			System.out.println("Alert button is displayed on webpage");
		}
		else 
		{
			System.out.println("Alert button is NOT displayed");
		}
		if(baseClass.alertButtonEnabled())
		{
			System.out.println("Alert button is enabled ");
		}
		else 
		{
			System.out.println("Alert button is Disabled");
		}
		if(baseClass.confirmButtondisplayed())
		{
			System.out.println("Confirm button is displayed on webpage");
		}
		else 
		{
			System.out.println("Confirm button is NOT displayed");
		}
		if(baseClass.confirmButtonEnabled())
		{
			System.out.println("Confirm button is enabled");
		}
		else 
		{
			System.out.println("Confirm button is Disabled");
		}
		if(baseClass.promptDisplayed())
		{
			System.out.println("Prompt button is displayed on webpage");
		}
		else 
		{
			System.out.println("Prompt button is NOT displayed");
		}
		if(baseClass.promptEnabled())
		{
			System.out.println("Prompt button is enabled");
		}
		else 
		{
			System.out.println("Prompt button is Disabled");
		}

	}


	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}