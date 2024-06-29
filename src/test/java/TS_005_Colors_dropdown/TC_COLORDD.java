package TS_005_Colors_dropdown;

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
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.Color_dropdown_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.Color_dropdown;
import utitilites.ExtentReporter;

public class TC_COLORDD extends Color_dropdown_Base
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


	
	@Test(description = "Validate whether drop-down option is displayed.")
	public void COLORDD_001()
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Color drop-down").assignAuthor("Mayank Rusia");
		Color_dropdown	baseClass = new Color_dropdown(driver);		
		baseClass.scroll();
		result = baseClass.dropdownElement().isDisplayed();
		if(result)
		{
			test.pass("Color drop-down is displayed on page");
		}
		else 
		{
			test.fail("Color drop-down is NOT displayed properly on page");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Color drop-down");
		}
	}


	@Test(description = "Validate an element can be selected from drop-down list ")
	public void COLORDD_002()
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Color drop-down, selecting element from it").assignAuthor("Mayank Rusia");
		Color_dropdown	baseClass = new Color_dropdown(driver);				baseClass.scroll();
		
		Select select = new Select(baseClass.dropdownElement());
		select.selectByVisibleText("Blue");

		WebElement selectedoption =	select.getFirstSelectedOption();
		String actselectedtext = selectedoption.getText();
		String expselectedtext = "Blue";

		if(actselectedtext.equals(expselectedtext))
		{
			test.pass("Blue option is selected");
		}
		else
		{
			test.fail("Blue is NOT selected");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Color drop-down");
		}
	}

	
	@Test(description = "Validate whether Drop-down elements are arranged in proper order.")
	public void COLORDD_003()
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Color drop-down element arrangement").assignAuthor("Mayank Rusia");
		Color_dropdown	baseClass = new Color_dropdown(driver);				baseClass.scroll();
	
		Select select = new Select(baseClass.dropdownElement());

		List orglist = new ArrayList();
		List<WebElement> options1 = select.getOptions();

		//printing drop-down options
		for(WebElement e : options1)
		{
			orglist.add(e.getText());
		}
//		System.out.println("Original list: "+orglist);

		List templist = new ArrayList();
		List<WebElement> options2 = select.getOptions();

		//printing drop-down options
		for(WebElement e1 : options2)
		{
			templist.add(e1.getText());
		}

		//sorting
		Collections.sort(templist);


//		System.out.println("Sorted list: "+templist);

		if(templist ==  orglist)
		{
			test.pass("Color drop-down elements are arranged in ascending order");
		}
		else 
		{
			test.fail("Color drop-down elements are NOT arranged in proper order");
			test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Color drop-down");
		}
	}
	

	@Test(description = "Validate different ways to select a option from drop-down list.")
	public void COLORDD_005() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Ways to select option from color drop-down").assignAuthor("Mayank Rusia");
		Color_dropdown	baseClass = new Color_dropdown(driver);				baseClass.scroll();
	
		Select select = new Select(baseClass.dropdownElement());
		select.selectByVisibleText("Red");
		test.log(Status.INFO, "Red is selected");
		test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Red option");
		Thread.sleep(1500);
		select.selectByIndex(2);
		test.log(Status.INFO, "Green is selected");
		test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Green option");	
		Thread.sleep(1500);
		select.selectByValue("blue");
		test.log(Status.INFO, "Blue is selected");
		test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Blue option");
	}

	
	@Test(description = "Validate jumping directly to the options from drop-down list by typing colors initials through keyboard.")
	public void COLORDD_006()
	{
		extent = ExtentReporter.getExtentReport();	

		test = extent.createTest("Direct selecting option").assignAuthor("Mayank Rusia");
		Color_dropdown	baseClass = new Color_dropdown(driver);				baseClass.scroll();
		baseClass.dropdownElement().click();
		test.info("Click on color drop-down");
		baseClass.dropdownElement().sendKeys("b");
		test.info("Type 'b' through keyboard");
		baseClass.dropdownElement().sendKeys(Keys.ENTER);
		test.info("Press ENTER key");
		test.addScreenCaptureFromBase64String(baseClass.captureScreenshot(),"Blue option");
	}

}