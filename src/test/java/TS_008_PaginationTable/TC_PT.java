package TS_008_PaginationTable;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.PaginationTable_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.PaginationTable;
import utitilites.ExtentReporter;



public class TC_PT extends PaginationTable_Base
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


	@Test(description = "Validate whether by clicking on checkboxes, user is able to select whole row.")
	public void PT_002()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Pagination webtable").assignAuthor("Mayank Rusia");
		PaginationTable	baseClass = new PaginationTable(driver);
		baseClass.scroll();
		baseClass.rowSelection(test);
	}



	@Test(description = "Validate table data is arranged in ascending order with ID.")
	public void PT_003() throws InterruptedException
	{	
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Pagination webtable content arrangement").assignAuthor("Mayank Rusia");
		PaginationTable	baseClass = new PaginationTable(driver);
		baseClass.scroll();
		baseClass.sortedData(test);
	}


	@Test(description = "Validate user is directly able to navigate to any page of table, by clicking on Page No.")
	public void PT_004() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Pagination webtable feature").assignAuthor("Mayank Rusia");
		PaginationTable	baseClass = new PaginationTable(driver);
		baseClass.scroll();
		baseClass.navigateAnyPageUsingNumbers(test);

	}



	@Test(description = "Validate whether Heading of table is properly loaded & displayed as the top row of table & should not get affected, as we navigate to any page of table.")
	public void PT_005()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Pagination webtable heading").assignAuthor("Mayank Rusia");
		PaginationTable	baseClass = new PaginationTable(driver);
		baseClass.scroll();
		baseClass.headingDisplay(test);
	}



	@Test(description = "Validate selecting multiple checkboxes on different page of table.")
	public void PT_006() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Pagination webtable").assignAuthor("Mayank Rusia");
		PaginationTable	baseClass = new PaginationTable(driver);
		baseClass.scroll();
		baseClass.selectMultipleOptions(test);
	}


	@Test(description = "Validate status of selected checkbox after navigating to next page after selecting checkbox on previous page.")
	public void PT_007()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Pagination webtable options features").assignAuthor("Mayank Rusia");
		PaginationTable	baseClass = new PaginationTable(driver);
		baseClass.scroll();
		baseClass.validateStatus(test);
	}


}