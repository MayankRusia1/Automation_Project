package TS_015_resizable_window;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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
import base.ResizingWindow_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.ResizingWindow;
import utitilites.ExtentReporter;

public class TC_RW extends ResizingWindow_Base
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

	
	@Test(description = "Validate whether Resizable window , having text \"Resizable\" inside it.")
	public void RW_002()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Resizable window functionality").assignAuthor("Mayank Rusia");
		ResizingWindow	baseClass = new ResizingWindow(driver);
		baseClass.scroll();
		baseClass.resizingTextFeature(test);
	}

	@Test(description = "Validate whether Resizable window have resizing icon at right-down corner.")
	public void RW_003()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Resizable window functionality").assignAuthor("Mayank Rusia");
		ResizingWindow	baseClass = new ResizingWindow(driver);
		baseClass.scroll();
		baseClass.resizingIconMethod(test);
	}

	
	@Test(description = "Validate whether resizable window is able to resize window in all 4 directions (left, right, up, down) using mouse.")
	public void RW_004() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Resizable window functionality").assignAuthor("Mayank Rusia");
		ResizingWindow	baseClass = new ResizingWindow(driver);
		baseClass.scroll();
		baseClass.resizingWindowActivity(test);
	}

}