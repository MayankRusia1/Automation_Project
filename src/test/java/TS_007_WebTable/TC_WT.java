package TS_007_WebTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import base.WebTable_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.WebTable;
import utitilites.ExtentReporter;



public class TC_WT extends WebTable_Base
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

	@Test(description = "Validate whether table data is properly arranged in any order (ascending / descending).")
	public void WT_002()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Webtable data checking").assignAuthor("Mayank Rusia");
		WebTable	BaseClass = new WebTable(driver);
		BaseClass.scroll();
		BaseClass.sortedData(test);
	}




	@Test(description = "Validate whether Heading of webtable are properly labeled.")
	public void WT_003()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Webtable heading checking").assignAuthor("Mayank Rusia");
		WebTable	BaseClass = new WebTable(driver);
		BaseClass.scroll();
		BaseClass.headers(test);
	}



}
