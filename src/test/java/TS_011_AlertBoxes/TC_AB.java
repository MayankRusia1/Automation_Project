package TS_011_AlertBoxes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import base.AlertBox_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.AlertBox;
import utitilites.ExtentReporter;


public class TC_AB extends AlertBox_Base
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



	@Test(description = "Validate the functionality of simple 'Alert' button with  'OK' button functionality.")
	public void AB_002() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Simple alert box with OK button").assignAuthor("Mayank Rusia");
		AlertBox	baseClass = new AlertBox(driver);
		baseClass.scrolling();
		test.info("Alert button is clicked");
		test.info("OK button is clicked");
		result = baseClass.alertButton_OK_option();
		if(result)
		{
			test.pass("'I am an alert box!' text is displayed in alert window.");
		}
		else 
		{
			test.fail("Text inside alert box is NOT correctly displayed").addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Alert window");
		}
	}

	
	

	@Test(description = "Validate the functionality of 'Confirm box' alert button with  'OK'  button functionality.")
	public void AB_003() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Confirm box with OK option").assignAuthor("Mayank Rusia");
		AlertBox	baseClass = new AlertBox(driver);
		baseClass.scrolling();
		test.info("Confirm button is clicked");
		test.info("OK button is clicked");
		result = baseClass.confirmButton_OKOption();
		if(result)
		{
			test.pass("Text inside confirm box is correctly displayed and Correct message is displayed on webpage");
		}
		else 
		{
			test.fail("Text inside confirm box is NOT correctly displayed and Wrong message is displayed on webpage");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Confirm button");
		}
	}


	@Test(description = "Validate the functionality of 'Confirm box' alert button with  'Cancel'  button functionality.")
	public void AB_004() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Confirm box with CANCEL option").assignAuthor("Mayank Rusia");
		AlertBox	baseClass = new AlertBox(driver);
		baseClass.scrolling();
		test.info("Confirm button is clicked");
		test.info("CANCEL button is clicked");
		result = baseClass.confirmButton_CANCELOption();
		if(result)
		{
			test.pass("Text inside confirm box is correctly displayed.. Correct message is displayed on webpage");
		}
		else 
		{
			test.fail("Text inside confirm box is NOT correctly displayed and Wrong message is displayed on webpage");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Confirm button");
		}

	}



	@Test(description = "Validate the functionality of \"Prompt\" alert button, directly clicking on 'OK' button without giving any prompt in textbox.")
	public void AB_005() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Prompt alert button, without passing any text").assignAuthor("Mayank Rusia");
		AlertBox	baseClass = new AlertBox(driver);

		baseClass.scrolling();
		test.info("Prompt button is clicked");
		test.info("OK button is clicked");
		result = baseClass.promptButton_withoutPrompt_OKButton();
		if(result)
		{
			test.pass("Correct message is displayed");
		}
		else 
		{
			test.fail("Wrong message is displayed");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Prompt Button");
		}
	}

	
	@Test(description = "Validate the functionality of 'Prompt' alert button, directly clicking on 'Cancel' button without giving any prompt in textbox.")
	public void AB_006() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Prompt alert button,without passing any text").assignAuthor("Mayank Rusia");
		AlertBox	baseClass = new AlertBox(driver);

		baseClass.scrolling();
		result = baseClass.promptButton_withoutPrompt_Cancelbutton();
		if(result)
		{
			test.pass("Correct message is displayed");
		}
		else 
		{
			test.fail("Wrong message is displayed");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Prompt Button");
		}
	}


	@Test(dataProvider = ("ab_007"), dataProviderClass = utilities.DataProvider_alertBoxes.class, description = "Validate the functionality of \"Prompt\" alert button, giving a prompt in textbox, & clicking \"OK\" button.")
	public void AB_007(String data) throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Prompt alert button,passing prompt & click OK button").assignAuthor("Mayank Rusia");
		AlertBox	baseClass = new AlertBox(driver);

		baseClass.scrolling();
		test.info("Prompt button is clicked");

		int result = baseClass.dataDrivenTesting_promptButton(data);
		if(result == 1)
		{
			test.pass("Correct message is displayed");
		}
		else if(result == 0)
		{
			test.fail("Wrong message is displayed");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Prompt button");
		}
	}

	@Test(description = "Validate the functionality of 'Prompt' alert button, giving a prompt in textbox, & clicking 'Cancel' button.")
	public void AB_008() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Prompt alert button,passing prompt & click Cancel button").assignAuthor("Mayank Rusia");
		AlertBox	baseClass = new AlertBox(driver);
		baseClass.scrolling();
		test.info("Prompt button is clicked");
		result = baseClass.promptbutton_givinginput_presscancel("Hello");
		if(result)
		{
			test.pass("Correct message is displayed");
		}
		else 
		{
			test.fail("Wrong message is displayed");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Prompt button");
		}
	}


	@Test(description = "Validate Prompt functionality behaviour with whitespaces.")
	public void AB_009() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Prompt alert button").assignAuthor("Mayank Rusia");
		AlertBox	baseClass = new AlertBox(driver);

		baseClass.scrolling();
		
		test.info("Prompt button is clicked");

		result = baseClass.promptbehaviour_whitespaces();
		if(result)
		{
			test.pass("Correct message is displayed");
		}
		else 
		{
			test.fail("Wrong message is displayed");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Prompt button");
		}
	}

}