package TS_014_slider;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
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

import base.Slider_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Slider;
import utitilites.ExtentReporter;

public class TC_Slider extends Slider_Base
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


	@Test(description = "Validate whether Slider is able to scroll at discrete points by clicking through mouse on slider bar.")
	public void Slider_002() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Slider functionality").assignAuthor("Mayank Rusia");
		Slider	baseClass = new Slider(driver);
		baseClass.scroll();
		result = baseClass.SliderBar(test);
		if(result == true)
		{
			test.pass("Slider bar is working properly");
		}
		else
		{
			test.fail("Slider bar is NOT working properly");
			test.addScreenCaptureFromBase64String(baseClass.capturescreenshot(),"Slider bar");
		}
	}

	

	@Test(description = "Validate whether Slider is smoothly scrolling  from minimium to maximum value.")
	public void Slider_003() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Slider functionality").assignAuthor("Mayank Rusia");
		Slider	baseClass = new Slider(driver);
		baseClass.scroll();
		baseClass.SliderBarSmoothWorking(test);
	}

	
	@Test(description = "Validate whether Slider is smoothly scrolling using keyboard keys (Up, Down Left , Right) from minimium to maximum value.")
	public void Slider_004()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Slider functionality").assignAuthor("Mayank Rusia");
		Slider	baseClass = new Slider(driver);
		baseClass.scroll();
		baseClass.SliderBarMovingUsingKeyboardKeys(test);
	}

}