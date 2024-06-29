package TS_018_FooterSection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Footer;


public class TC_FS_001 
{
	WebDriver driver;

	boolean result;

	@Parameters("browser")	
	@BeforeTest
	public void setup(String browsername)
	{
		if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			System.out.println("Firefox browser");
		}

		if(browsername.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			System.out.println("Edge browser");
		}

		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Chrome browser");
		}
		driver.get("https://testautomationpractice.blogspot.com/");
	}


	@Test(description = "Cross browser testing")
	public void FS_001()
	{
	Footer	baseClass = new Footer(driver);
		baseClass.scroll();
		result = baseClass.footerSectionDisplayed();
		if(result)
		{
			System.out.println("Footer section elements are displayed properly");
		}
		else
		{
			System.out.println("Footer section elements are NOT displayed properly");
		}
	}

	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}
