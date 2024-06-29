package TS_006_Hyperlinks;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.Hyperlinks_base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Hyperlinks;
import utitilites.ExtentReporter;



public class TC_HL extends Hyperlinks_base
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


	@Test(description = "Validate whether after clicking on \"Orange HRM\" Hyperlinks provided, we are navigating to \"Orange HRM\" login webpage.")
	public void HL_002()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Orange HRM link").assignAuthor("Mayank Rusia");
		Hyperlinks	baseClass = new Hyperlinks(driver);
		baseClass.scroll();
		baseClass.orangeHRMTesting(test);
	}


	@Test(description = "Validate whether after clicking on \"Open cart\" Hyperlinks provided, we are navigating to \"Open cart\" home webpage.")
	public void HL_003()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Opencart link").assignAuthor("Mayank Rusia");
		Hyperlinks	baseClass = new Hyperlinks(driver);
		baseClass.scroll();
		baseClass.opencartTesting(test);
	}

	@Test(description = "Validate whether after clicking on \"Home\" Hyperlinks provided, we are navigating to \"Automation testing practice\" home webpage.")
	public void HL_004()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Home hyperlink").assignAuthor("Mayank Rusia");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Hyperlinks	baseClass = new Hyperlinks(driver);
		baseClass.scroll();
		baseClass.Hometesting(test);
	}

	@Test(description = "Validate whether after clicking on hyperlink, we are directed to webpage in new browsing tab.")
	public void HL_005()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("opening a new browsing window").assignAuthor("Mayank Rusia");
		Hyperlinks	baseClass = new Hyperlinks(driver);
		baseClass.scroll();
		baseClass.newBrowserWindowtesting(test);
	}


	@Test(description = "Validate the working, after clicking on \"Posts (Atom)\" hyperlink, a text file is downloaded in system.")
	public void HL_006()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Downloading a file").assignAuthor("Mayank Rusia");
		Hyperlinks	baseClass = new Hyperlinks(driver);
		baseClass.scroll();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		baseClass.downloadItem().click();
		test.pass("Text file is downlaoded");
	}
}