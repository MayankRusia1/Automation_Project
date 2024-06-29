package TS_013_drag_drop;

import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.Drag_drop_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Drag_drop;
import utitilites.ExtentReporter;


public class TC_DragDrop extends Drag_drop_Base
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


	@Test(description = "Validate whether Drop window have text in it \"Drop here\".")
	public void DragDrop_002()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Drop window features").assignAuthor("Mayank Rusia");
		Drag_drop	baseClass = new Drag_drop(driver);
		baseClass.scroll();
		result  = baseClass.droppableElement("Drop here");
		if(result)
		{
			test.pass("Correct message is displayed in Droppable element");
		}
		else 
		{	
			test.fail("Wrong message is displayed in Droppable element");
			test.addScreenCaptureFromBase64String(baseClass.capturescreenshot(),"Droppable element");
		}
	}


	@Test(description = "Validate whether Drag element have text in it \"Drag me to my target\".")
	public void DragDrop_003()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Drag element feature").assignAuthor("Mayank Rusia");
		Drag_drop	baseClass = new Drag_drop(driver);
		baseClass.scroll();

		result  = baseClass.draggableElement("Drag me to my target");
		if(result)
		{
			test.pass("Correct message is displayed in Draggable element");
		}
		else 
		{	
			test.fail("Wrong message is displayed in Draggable element");
			test.addScreenCaptureFromBase64String(baseClass.capturescreenshot(),"Draggable element");
		}
	}



	@Test(description = "Validate features of Draggable element")
	public void DragDrop_004()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Draggable element features").assignAuthor("Mayank Rusia");
		Drag_drop	baseClass = new Drag_drop(driver);
		baseClass.scroll();

		result = baseClass.properties_draggableElement();
		if(result)
		{
			test.pass("Correct message is displayed");
		}
		else 
		{	
			test.fail("Wrong message is displayed");
			test.addScreenCaptureFromBase64String(baseClass.capturescreenshot(),"Draggable element");
		}	
	}

	@Test(description = "Validate features of Drop window")
	public void DragDrop_005()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Drop window functionality").assignAuthor("Mayank Rusia");
		Drag_drop	baseClass = new Drag_drop(driver);
		baseClass.scroll();

		result = baseClass.properties_droppableElement();
		if(result)
		{
			test.pass("Correct message is displayed");
		}
		else 
		{	
			test.fail("Wrong message is displayed");
			test.addScreenCaptureFromBase64String(baseClass.capturescreenshot(),"Droppable element");
		}	
	}



	@Test(description = "Validate Drag element is movable & Drop window is Immovable.")
	public void DragDrop_006()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Drag & drop functionality").assignAuthor("Mayank Rusia");
		Drag_drop	baseClass = new Drag_drop(driver);
		baseClass.scroll();
		result = baseClass.behaviourOfDrag_drop();
		if(result)
		{
			test.pass("Drag element is movable");
			test.pass("Drop window is immovable");
		}
		else
		{
			test.fail("Drag element is movable");
			test.fail("Drop window is movable");
			test.addScreenCaptureFromBase64String(baseClass.capturescreenshot());
		}
	}   



	@Test(description = "Validate indication applied on Drop window, as Drag element is dropped inside Drop window.")
	public void DragDrop_007()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Drag & drop functionality").assignAuthor("Mayank Rusia");
		Drag_drop	baseClass = new Drag_drop(driver);
		baseClass.scroll();

		result = baseClass.working_drag_drop();
		if(result)
		{
			test.pass("Correct message is displayed, before dropping!").info("Correct message displayed, after dropping!");
		}
		else 
		{
			test.fail("Wrong message is displayed, before dropping!").info("Wrong message displayed, after dropping!");
			test.addScreenCaptureFromBase64String(baseClass.capturescreenshot());
		}
	}
}