package TS_010_Button_openNewBrowsingWindow;

import java.io.IOException;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import base.NewBrowserWindow_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.NewBrowserWindowButton;
import utitilites.ExtentReporter;

public class TC_NBW extends  NewBrowserWindow_Base
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



	@Test(description = "Validate whether  \"New Browser Window\" button is navigating to \"open cart\" home page.")
	public void NBW_002()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("New browser window button functionality").assignAuthor("Mayank Rusia");
		NewBrowserWindowButton	baseClass = new NewBrowserWindowButton(driver);
		baseClass.newButtonAction(test);
	}

	
	@Test(description = "Validate whether after clicking on \"New Browser window\" button, one new browsing window opens.")
	public void NBW_003()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("check multiple browser window opens").assignAuthor("Mayank Rusia");
		NewBrowserWindowButton	baseClass = new NewBrowserWindowButton(driver);
		baseClass.oneClickOneNewWindow(test);
	}



	@Test(description = "Validate features of New browser window button")
	public void NBW_004()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("New browser window button").assignAuthor("Mayank Rusia");
		NewBrowserWindowButton	baseClass = new NewBrowserWindowButton(driver);
		baseClass.newBrowserWindowFeatures(test);		
	}	
}
