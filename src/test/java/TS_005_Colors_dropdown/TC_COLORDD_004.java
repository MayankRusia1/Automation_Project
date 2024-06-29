package TS_005_Colors_dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Color_dropdown_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Color_dropdown;

public class TC_COLORDD_004 
{
	public 	WebDriver driver;
	
	boolean result;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser)
	{
		if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			System.out.println("Edge browser");
		}
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Chrome browser");
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			System.out.println("Firefox browser");
		}
		driver.get("https://testautomationpractice.blogspot.com/");
	}
	
	@Test(description = "Validate whether Drop-down list is loaded successfully.")
	public void COLORDD_004()
	{
		Color_dropdown	baseClass = new Color_dropdown(driver);
		baseClass.scroll();
		result = baseClass.dropDownDisplayed();
		if(result)
		{
			System.out.println("Colors drop-down is displayed");
		}
		else 
		{
			System.out.println("Color drop-down is NOT displayed");
		}
	}
	
	
	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(1500);
		driver.close();
	}
	
}
