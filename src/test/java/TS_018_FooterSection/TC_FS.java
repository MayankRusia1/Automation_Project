package TS_018_FooterSection;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import base.FooterSection_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Footer;
import utitilites.ExtentReporter;


public class TC_FS extends FooterSection_Base
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
	
	@Test(description = "Validate whether \" merrymoonmary\" is hyperlink & when clicked ,navigating to \"istock\" photo home page in a new browser window")
	public void FS_002()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Footer section").assignAuthor("Mayank Rusia");
		Footer baseClass= new Footer(driver);
		baseClass.scroll();
		baseClass.merrymoonmaryHyperlink(test);
	}
	
	

	@Test(description = "Validate whether \" Bloggger\" is hyperlink & when clicked ,navigating to \"Blogger\" home page in a new browser window")
	public void FS_003()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Footer section").assignAuthor("Mayank Rusia");
		Footer baseClass= new Footer(driver);
		baseClass.scroll();
		baseClass.bloggerHyperlink(test);
	}
	
	

	@Test(description = "Validate the behaviour of hyperlinks, when user hover on it.")
	public void FS_004()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Footer section").assignAuthor("Mayank Rusia");
		Footer baseClass= new Footer(driver);
		baseClass.scroll();
		baseClass.behaviourOfHyperlinks(test);
	}


	@Test(description = "Validate footer section content display")
	public void FS_005()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Footer section").assignAuthor("Mayank Rusia");
		Footer baseClass= new Footer(driver);
		baseClass.scroll();
		baseClass.footerContent(test);
	}

}