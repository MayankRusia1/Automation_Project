package TS_009_searchbox;

import java.io.IOException;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.SearchBox_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.SearchBox;
import utitilites.ExtentReporter;


public class TC_SB extends SearchBox_Base
{
	public 	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	
	@BeforeMethod
	public void setup() throws IOException 
	{
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void tearDown() throws InterruptedException 
	{
		Thread.sleep(2500);
		extent.flush();
		driver.quit();
	}

	
	@Test(description = "Validate by clicking on image provided just before search bar, user is directed to Wikipedia main page, in new window.")
	public void SB_002()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Search box functionality").assignAuthor("Mayank Rusia");
		SearchBox	baseClass = new SearchBox(driver);
		baseClass.imageFunctionality(test);
	}

	
	
	@Test(description = "Validate Search functionality, without entering any text, clicking Search icon.")
	public void SB_003()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Search box functionality").assignAuthor("Mayank Rusia");
		SearchBox	baseClass = new SearchBox(driver);
		baseClass.search_withoutData(test);
	}

	
	@Test(description = "Validate whether Search bar have appropriate placeholder.")
	public void SB_004()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Search box functionality").assignAuthor("Mayank Rusia");
		SearchBox	baseClass = new SearchBox(driver);
		baseClass.placeholders(test);
	}


	@Test(dataProvider = "sb_006", dataProviderClass = utilities.DataProvider_searchboxFunctionality.class ,description = "Validate searching for invalid / non-existing option.")
	public void SB_006(String data) throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Search box functionality").assignAuthor("Mayank Rusia");
		SearchBox	baseClass = new SearchBox(driver);
		boolean result = baseClass.searchInvalidData(data);
		if(result)
		{
			test.pass("Proper warning message is displayed");
		}
		else
		{
			test.fail("Wrong warning message is displayed");
			test.addScreenCaptureFromBase64String(baseClass.capturescreenshot(),"Invalid search");
		}
	}
}