package TS_004_Country_dropdown;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import base.Country_dropdown_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Country_dropdown;
import utitilites.ExtentReporter;




public class TC_CDD extends Country_dropdown_Base
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


	@Test(description = "Validate whether drop-down elements are displayed after clicking on the drop-down list.")
	public void TC_CDD_001() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Country drop-down").assignAuthor("Mayank Rusia");	
		Country_dropdown baseClass = new Country_dropdown(driver);
		baseClass.scroll();

		baseClass.countryDropDown.click();
		test.info("Country drop-down is clicked");
		Thread.sleep(1500);
		test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Country drop-down");
		test.pass("Country drop-down is working fine & get opened when clicked on it");
	}


	@Test(description = "Validate whether elements is able to select from drop-down")
	public void TC_CDD_002() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Country drop-down").assignAuthor("Mayank Rusia");
		Country_dropdown baseClass = new Country_dropdown(driver);
		baseClass.scroll();

		result = baseClass.optionSelection();
		if(result)
		{
			test.pass("India is selected from country drop-down & it is highlighted in drop-down bar");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Country drop-down");
		}
		else
		{
			test.pass("India is NOT selected from country drop-down & it is NOT highlighted in drop-down bar");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Country drop-down");			
		}
	}



	@Test(description = "Validate whether Drop-down elements are arranged in proper order.")
	public void TC_CDD_003() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Country drop-down").assignAuthor("Mayank Rusia");
		Country_dropdown baseClass = new Country_dropdown(driver);
		baseClass.scroll();

		result = baseClass.sortedDropdownElement(test);
		//assertions
		if(result)
		{
			test.pass("Country drop down elements are arranged in ascending order");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Country drop-down");
		}
		else 
		{
			test.fail("Country drop down elements are NOT arranged in ascending order");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Country drop-down");
		}

	}


	@Test(description = "Validate different ways to select a option from drop-down list.")
	public void TC_CDD_005() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Country drop-down").assignAuthor("Mayank Rusia");
		Country_dropdown baseClass = new Country_dropdown(driver);
		baseClass.scroll();

		result = baseClass.waysOfSelectingElement("visible text");
		//1st way: using 'visible text'
		if(result)
		{
			test.pass("India option is selected from drop-down, using Visible text");
		}
		else
		{
			test.fail("India option is NOT selected from drop-down");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Country drop-down");
		}

		result = baseClass.waysOfSelectingElement("index");
		//2nd way: using 'index'
		if(result)
		{
			test.pass("United Kingdom option is selected from drop-down,using index");
		}
		else
		{
			test.fail("United Kingdom option is NOT selected from drop-down");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Country drop-down");
		}

		result = baseClass.waysOfSelectingElement("value");
		//3rd way: using 'value'
		if(result)
		{
			test.pass("France option is selected from drop-down, using value");
		}
		else
		{
			test.fail("France option is NOT selected from drop-down");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Country drop-down");
		}
	}



	@Test(description = "Validate jumping directly to the options from drop-down list by typing country initials through keyboard.")
	public void TC_CDD_006() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Country drop-down").assignAuthor("Mayank Rusia");
		Country_dropdown baseClass = new Country_dropdown(driver);
		baseClass.scroll();

		result = baseClass.directJumpingOnOptions(test);
		if(result)
		{
			test.pass("Australia is selected");
		}
		else 
		{
			test.fail("Australia is NOt selected");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Country drop-dwon");
		}
	}

}