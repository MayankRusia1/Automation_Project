package TS_013_drag_drop;

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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Drag_drop;

public class TC_DragDrop_001
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

	
	@Test(description = "Cross browser testing")
	public void Drag_drop_001()
	{
		Drag_drop	baseClass = new Drag_drop(driver);
		baseClass.scroll();
		result = baseClass.crossBrowserTesting();
		if(result)
		{
			System.out.println("Drag & drop element is loaded & displayed on page");			
		}
		else
		{
			System.out.println("Drag & drop element is NOT loaded & displayed on page");
		}
	}

	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.quit();
	}

}
