package TS_004_Country_dropdown;

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

import base.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Country_dropdown;

public class TC_CDD_004 
{
	public 	WebDriver driver; 
	
	
	@Parameters("browser")
	@BeforeTest
	public void initialize(String browser)
	{
	if(browser.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		System.out.println("Firefox browser is launched");
	}
	if(browser.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Chrome browser is launched");
	}
	if(browser.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		System.out.println("Edge browser is launched");
	}
	driver.manage().window().maximize();
	driver.get("https://testautomationpractice.blogspot.com/");	
	}
	
	@Test
	public void CDD_004()
	{
		Country_dropdown	baseClass = new Country_dropdown(driver);
		baseClass.scroll();
		if((baseClass.countryDropDown).isDisplayed())
		{
			System.out.println("Country drop-down is displayed on webpage");			
		}
		else
		{
			System.out.println("Country drop-down is NOT displayed on webpage");
		}
	}
	
	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
}