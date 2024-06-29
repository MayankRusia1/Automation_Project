package TS_014_slider;

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
import pageobjects.Slider;

public class TC_Slider_001 
{
	WebDriver driver;


	@Parameters("browser")
	@BeforeTest
	public void setup(@Optional("edge") String browsername)
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome browser");
		}
		if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox browser");
		}
		if(browsername.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge browser");
		}
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}


	@Test(description = "Cross browser testing")
	public void Slider_001()
	{
		Slider	baseClass = new Slider(driver);
		baseClass.scroll();
		baseClass.crossbrowser();
	}

	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}
