package TS_003_CheckBoxes;

import java.io.IOException;

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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.Checkbox_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.CheckBox;
import utitilites.ExtentReporter;

public class TB_CB extends Checkbox_Base
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
	public void tearDown() 
	{
		extent.flush();
		driver.quit();
	}
	
	

	
	
	@Test(description = "Validate whether \"Days\" category Check Boxes are Displayed & Enabled.")
	public void CB_002()
	{
		extent = ExtentReporter.getExtentReport();	
		test = extent.createTest("UI of checkboxes").assignAuthor("Mayank Rusia");
		CheckBox	baseClass  = new CheckBox(driver);
		baseClass.scroll();		
		
		if(baseClass.sundayIsDisplayed() && baseClass.sundayIsEnabled())
		{
			test.pass("Sunday checkbox is displayed & enabled");
		}
		else 
		{
			test.fail("Sunday checkbox is NOT displayed & enabled");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Sunday checkbox");
		}
		
		if(baseClass.mondayIsDisplayed() && baseClass.mondayisEnabled())
		{
			test.pass("Monday checkbox is displayed & enabled");			
		}
		else 
		{
			test.fail("Monday checkbox is NOT displayed & enabled");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Monday checkbox");			
		}
		if(baseClass.tuesdayIsDisplayed() && baseClass.tuesdayisEnabled())
		{
			test.pass("Tuesday checkbox is displayed & enabled");
		}
		else 
		{
			test.fail("Tuesday checkbox is NOT displayed & enabled");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Tuesday checkbox");
		}
		if(baseClass.wednesdayIsDisplayed() && baseClass.wednesdayisEnabled())
		{
			test.pass("Wednesday checkbox is displayed & enabled");			
		}
		else 
		{
			test.fail("Wednesday checkbox is NOT displayed & enabled");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Wednesday checkbox");			
		}
		if(baseClass.thursdayIsDisplayed() && baseClass.thursdayisEnabled())
		{
			test.pass("Thursday checkbox is displayed & enabled");
		}
		else 
		{
			test.fail("Thursday checkbox is NOT displayed & enabled");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Thursday checkbox");
		}
		if(baseClass.fridayIsDisplayed() && baseClass.fridayisEnabled())
		{
			test.pass("Friday checkbox is displayed & enabled");
		}
		else 
		{
			test.fail("Friday checkbox is NOT displayed & enabled");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Friday checkbox");
		}
		if(baseClass.saturdayIsDisplayed() && baseClass.saturdayisEnabled())
		{
			test.pass("Saturday checkbox is displayed & enabled");
		}
		else 
		{
			test.fail("Saturday checkbox is NOT displayed & enabled");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Saturday checkbox");
		}
	}
	
	
	
	@Test(description = "Validate whether \"Days\" category Check Boxes, allows to select multiple checkboxes.")
	public void CB_003() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Selecting multiple checkboxes").assignAuthor("Mayank Rusia");
		CheckBox baseClass  = new CheckBox(driver);		baseClass.scroll();		
		
		baseClass.mondayClick();  				Thread.sleep(1500);
		baseClass.wednesdayClick();  			Thread.sleep(1500);
		baseClass.saturdayClick();  			Thread.sleep(1500);
		baseClass.sundayClick();  				Thread.sleep(1500);
				
		boolean monday = baseClass.monday.isSelected();
		if(monday)
		{
			test.pass("Monday checkbox is selected");
		}
		else 
		{
			test.fail("Monday checkbox is NOT selected");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Monday checkbox");
		}
		
		boolean wednesday = baseClass.wednesday.isSelected();
		if(wednesday)
		{
			test.pass("Wednesday checkbox is selected");
		}
		else 
		{
			test.fail("Wednesday checkbox is NOT selected");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Wednesday checkbox");
		}

		boolean saturday = baseClass.saturday.isSelected();
		if(saturday)
		{
			test.pass("Saturday checkbox is selected");
		}
		else 
		{
			test.fail("Saturday checkbox is NOT selected");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Saturday checkbox");
		}
		
		boolean sunday = baseClass.sunday.isSelected();
		if(sunday)
		{
			test.pass("Sunday checkbox is selected");
		}
		else 
		{
			test.fail("Sunday checkbox is NOT selected");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Sunday checkbox");
		}
	}
	
	
	
	
	@Test(description = "Validate the working of Check boxes of (selecting & unselecting) by click action.")
	public void CB_004() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Select-unselect functionality").assignAuthor("Mayank Rusia");
		CheckBox	baseClass  = new CheckBox(driver);		
		baseClass.scroll();		
		
		baseClass.tuesdayClick();
		result = baseClass.tuesday.isSelected();
		if(result)
		{
			test.pass("Tuesday checkbox is selected");
		}
		else 
		{
			test.fail("Tuesday checkbox is NOT selected");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Tuesday checkbox");
		}
		
		Thread.sleep(2000);
		
		baseClass.tuesdayClick();
		result = baseClass.tuesday.isSelected();		
		if(result == false)
		{
			test.pass("Tuesday checkbox is unselected");
		}
		else 
		{
			test.fail("Tuesday checkbox is still selected");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Tuesday checkbox");
		}
	}

	
	
	@Test(description = "Validate the working of checkboxes, by clicking on their \"Text\", Checkbox gets selected.")
	public void CB_005()
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Checkbox functionality").assignAuthor("Mayank Rusia");
		CheckBox	baseClass  = new CheckBox(driver);		baseClass.scroll();		

		baseClass.thursdayTextClick();
		result = baseClass.thursday.isSelected();
		if(result)
		{
			test.pass("Thursday checkbox is selected, by clicking on Thursday text");
		}
		else 
		{
			test.fail("Thursday checkbox is NOT selected, by clicking Thursday text");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Thursday checkbox");
		}
	}

	
	
	@Test(description = "Validate the working of checkboxes, by clicking on their \"Button\", Checkbox gets selected.")
	public void CB_006()
	{	
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Checkboxes functionality").assignAuthor("Mayank Rusia");
		CheckBox	baseClass  = new CheckBox(driver);		baseClass.scroll();		

		baseClass.thursdayClick();
		result = baseClass.thursday.isSelected();
		if(result)
		{
			test.pass("Thursday checkbox is selected, by clicking on Thursday text");
		}
		else 
		{
			test.fail("Thursday checkbox is NOT selected, by clicking Thursday text");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Thursday checkbox");
		}
	
	}

	
}