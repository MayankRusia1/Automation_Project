package TS_016_Frames;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.Frames_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Frames;
import utitilites.ExtentReporter;



public class TC_FF extends Frames_Base
{
	public 	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	boolean result;

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

	
	@Test(description = "Validate whether user is able to click \"Report abuse\" hyperlink, present inside iframe.") 
	public void FF_001()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Frames functionality").assignAuthor("Mayank Rusia");
		Frames	baseClass = new Frames(driver);
		baseClass.scroll();
		baseClass.reportAbuseFunctionality(test);
	}

	

	@Test(description = "Validate whether user is able to click \"Powered by  formsite\" hyperlink, present inside iframe.") 
	public void FF_002()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Frames functionality").assignAuthor("Mayank Rusia");
		Frames	baseClass = new Frames(driver);
		baseClass.scroll();
		baseClass.poweredByFunctionality(test);
	}


	@Test(description = "Validate whether user is able to fill form, present inside iframe.") 
	public void FF_003()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Frames functionality").assignAuthor("Mayank Rusia");
		Frames	baseClass = new Frames(driver);
		baseClass.scroll();
		baseClass.formFilling(test);
	}


	@Test(description = "Validate fields inside iframes, having proper placeholders.") 
	public void FF_004()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Frames functionality").assignAuthor("Mayank Rusia");
		Frames	baseClass = new Frames(driver);
		baseClass.scroll();
		baseClass.Placeholders(test);
	}


	
	@Test(description = "Validate presence of iframes") 
	public void FF_005()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Frames functionality").assignAuthor("Mayank Rusia");
		Frames	baseClass = new Frames(driver);
		baseClass.scroll();
		baseClass.presenceOfIframes(test);
		
	}

	
	@Test(description = "Validate Iframe Attributes") 
	public void FF_007()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Frames functionality").assignAuthor("Mayank Rusia");
		Frames	baseClass = new Frames(driver);
		baseClass.scroll();
		baseClass.iframeAttributes(test);
	}

	

	@Test(description = "Validate Iframe Navigation") 
	public void FF_008()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Frames functionality").assignAuthor("Mayank Rusia");
		Frames	baseClass = new Frames(driver);	
		baseClass.scroll();
		baseClass.iframeNavigation(test);
		
	}


	@Test(description = "Validate Iframe Refresh") 
	public void FF_009()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Frames functionality").assignAuthor("Mayank Rusia");
		Frames	baseClass = new Frames(driver);
		baseClass.scroll();
		baseClass.iframeRefresh(test);
	}
	
}