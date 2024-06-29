package TS_001_TextBoxes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.TextBox;


public class TC_TB_001 
{
	public WebDriver driver;	
	int result;
	
	@Parameters({"browser"})
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
	public void TB_001()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//		baseClass = new TextBox_BaseClass(driver);
		TextBox baseClass = new TextBox(driver);
		baseClass.enterName("Aman Gupta");											
		baseClass.enterEmailAddress("amangupta667@yahoo.com");						
		baseClass.enterPhoneNumber("9826311979");							
		baseClass.enterAddress("543/4 Saharangpur road, Nagpur, Maharashtra"); 			

		if(baseClass.datachecking_name() == 1 && baseClass.datachecking_email() == 1 && baseClass.datachecking_phone() == 1 && baseClass.datachecking_address() ==1)
		{
			System.out.println("All the data (Name, Email, Phone Number, Email) is properly entered in Name textbox");
		}
		if(baseClass.datachecking_name() == 0) 
		{
			System.out.println("Name is NOT properly entered in Name textbox");
		}
		if(baseClass.datachecking_email() == 0) 
		{
			System.out.println("Email is NOT properly entered in Name textbox");
		}if(baseClass.datachecking_phone() == 0) 
		{
			System.out.println("Phone is NOT properly entered in Name textbox");
		}if(baseClass.datachecking_address() == 0) 
		{
			System.out.println("Address is NOT properly entered in Name textbox");
		}

	}

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}