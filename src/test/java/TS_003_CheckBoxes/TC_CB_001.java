package TS_003_CheckBoxes;

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
import base.Checkbox_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.CheckBox;

public class TC_CB_001 
{
	WebDriver driver;

	
	@Parameters("browser")
	@BeforeTest
	public void initialize(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("Firefox browser launched");
		}

		if(browser.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Chrome browser launched");
		}

		if(browser.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		System.out.println("Edge browser launched");
		}	
		driver.get("https://testautomationpractice.blogspot.com/");		
	}
	
	
	@Test
	public void CB_001()
	{
		CheckBox baseClass = new CheckBox(driver);
		baseClass.scroll();
		
		if(baseClass.mondayIsDisplayed())
		{
			System.out.println("Monday checkbox is loaded successfully on webpage & displayed");
		}
		else
		{
			System.out.println("Monday checkbox is NOT loaded successfully on webpage");
		}
		
		if(baseClass.tuesdayIsDisplayed())
		{
			System.out.println("Tuesday checkbox is loaded successfully on webpage & displayed");
		}
		else
		{
			System.out.println("Tuesday checkbox is NOT loaded successfully on webpage");
		}
		if(baseClass.wednesdayIsDisplayed())
		{
			System.out.println("Wednesday checkbox is loaded successfully on webpage & displayed");
		}
		else
		{
			System.out.println("Wednesday checkbox is NOT loaded successfully on webpage");
		}
		if(baseClass.thursdayIsDisplayed())
		{
			System.out.println("Thursday checkbox is loaded successfully on webpage & displayed");
		}
		else
		{
			System.out.println("Thursday checkbox is NOT loaded successfully on webpage");
		}
		if(baseClass.fridayIsDisplayed())
		{
			System.out.println("Friday checkbox is loaded successfully on webpage & displayed");
		}
		else
		{
			System.out.println("Friday checkbox is NOT loaded successfully on webpage");
		}
		if(baseClass.saturdayIsDisplayed())
		{
			System.out.println("Saturday checkbox is loaded successfully on webpage & displayed");
		}
		else
		{
			System.out.println("Saturday checkbox is NOT loaded successfully on webpage");
		}
	}
	
	
	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
}
