package TS_002_RadioButtons;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

import base.RadioButtons_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.RadioButtons;
import pageobjects.TextBox;
import utitilites.ExtentReporter;

public class TC_RB extends RadioButtons_Base
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
	public void tearDown() 
	{
		extent.flush();
		driver.quit();
	}
	
	


	@Test(description = "Validate the working of Radio Button, whether they are Displayed, Enabled.")
	public void RB_001()
	{
		extent = ExtentReporter.getExtentReport();	
		test = extent.createTest("Radio button display, enable").assignAuthor("Mayank Rusia");
		RadioButtons baseClass = new RadioButtons(driver);
		baseClass.scroll();
		baseClass.Validations(test);
	}


	@Test(description = "Validate whether only one radio button is Selected at a time & other remain unselected.")
	public void RB_002()
	{
		extent = ExtentReporter.getExtentReport();	
		
		test = extent.createTest("Radio button function").assignAuthor("Mayank Rusia");
		RadioButtons baseClass = new RadioButtons(driver);
		baseClass.scroll();
		baseClass.RadioButtonFunctionality(test);
	}


	@Test(description = "Validate whether 'Male' radio button is selected by clicking on 'Male' Text.")
	public void RB_003()
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Male radio button, by clicking text").assignAuthor("Mayank Rusia");
		RadioButtons baseClass = new RadioButtons(driver);
		baseClass.scroll();
		baseClass.maleTextClick(test);
	}


	@Test(description = "Validate whether 'Male' radio button is selected by clicking on 'Male' radio button.")
	public void RB_004()
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Male radio button, by clicking button").assignAuthor("Mayank Rusia");
		RadioButtons baseClass = new RadioButtons(driver);
		baseClass.scroll();
		baseClass.maleButtonClick(test);
	}

	
	@Test(description = "Validate  whether 'Female' radio button is selected by clicking on 'Female' Text.")
	public void RB_005()
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Female radio button, by clicking text").assignAuthor("Mayank Rusia");
		RadioButtons baseClass = new RadioButtons(driver);
		baseClass.scroll();
		baseClass.femaleTextClick(test);
	}


	@Test(description = "Validate whether 'Female' radio button is selected by clicking on 'Female' radio button.")
	public void RB_006()
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Female radio button, by clicking button").assignAuthor("Mayank Rusia");
		RadioButtons baseClass = new RadioButtons(driver);
		baseClass.scroll();
		baseClass.femaleButtonClick(test);
	}


	@Test(description = "Validate UI of radio button functionality.")
	public void RB_008()
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("UI of Radio buttons").assignAuthor("Mayank Rusia");
		RadioButtons baseClass = new RadioButtons(driver);
		baseClass.scroll();
		baseClass.UIOfRadioButtons(test);
	}

}