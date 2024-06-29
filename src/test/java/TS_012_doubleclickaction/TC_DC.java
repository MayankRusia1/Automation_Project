package TS_012_doubleclickaction;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import base.DoubleClick_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.DoubleClick;
import utitilites.ExtentReporter;

public class TC_DC extends DoubleClick_Base
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



	@Test(description = "Validate whether any bydefault text inside Field1 & Field2 textboxes.")
	public void DC_002()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Double click option").assignAuthor("Mayank Rusia");
		DoubleClick	baseClass = new DoubleClick(driver);
		baseClass.scroll();
		result = baseClass.defaultValues();
		if(result)
		{
			test.pass("Field1 have a text bydefault in it & Field2 is empty");
		}
		else
		{
			test.fail("Field1 & Field2 are not behaving as per requirement");
			test.addScreenCaptureFromBase64String(baseClass.capturescreenshot(),"Double Click button");
		}
	}
	
	

	@Test(description = "Validate whether after clicking on 'Copy Text' button, Content in (Field1 & Field2) textboxes are copied & same.")
	public void DC_003() throws IOException
	{
		extent = ExtentReporter.getExtentReport();

		test = extent.createTest("Double click option").assignAuthor("Mayank Rusia");
		DoubleClick	baseClass = new DoubleClick(driver);
		baseClass.scroll();

		baseClass.dataCopy_doubleClick("fdjdsnk     5845");
		
		String actfield1 = baseClass.field1.getAttribute("value");
		String actfield2 = baseClass.field2.getAttribute("value");

		System.out.println(actfield1);
		System.out.println(actfield2);
		
		if(actfield1.equals(actfield2))
		{
			test.pass("Both textboxes having same text");
			test.addScreenCaptureFromBase64String(baseClass.capturescreenshot(),"Double Click button");
		}
		else 
		{
		test.fail("Both textboxes having different text");
		test.addScreenCaptureFromBase64String(baseClass.capturescreenshot(),"Double Click button");
		}
	}

	
	
	@Test(description = "Validate whether Field1 textbox content will copy in Field2 textbox only after \"Double click\" action.")
	public void DC_004() throws IOException
	{
		extent = ExtentReporter.getExtentReport();

		test = extent.createTest("Double click option").assignAuthor("Mayank Rusia");
		DoubleClick	baseClass = new DoubleClick(driver);
		baseClass.scroll();

		baseClass.dataCopy_singleClick("9851388797");
		test.info("data is entered in Field 1");
		test.info("Single click done");
		
		String expsingle = "";
		String singlefield2 = baseClass.field2.getAttribute("value");
		
		
		//double click action
		
		baseClass.dataCopy_doubleClick("9851388797");
		test.info("data is entered in Field 1");
		test.info("Double click done");
		
		String singlefield3 = baseClass.field1.getAttribute("value");
		String singlefield4 = baseClass.field2.getAttribute("value");
		
		if(expsingle.equals(singlefield2) && singlefield3.equals(singlefield4))
		{
			test.pass("Content from Field1 getting copied in Field2 after only Double click action");
		}
		else 
		{
		test.fail("Text getting copied in Field2 from Fiel1 by single click action");
		test.addScreenCaptureFromBase64String(baseClass.capturescreenshot(),"Double Click button");
		}
	}

	
	
	
	@Test(description = "Validate the working for Field1 textbox have proper placeholder.")
	public void DC_005()
	{
		extent = ExtentReporter.getExtentReport();

		test = extent.createTest("Double click option").assignAuthor("Mayank Rusia");
		DoubleClick	baseClass = new DoubleClick(driver);
		baseClass.scroll();
		result = baseClass.placeholder();
		if(result)
		{
			test.pass("Proper placeholder is displayed in Field 1");
		}
		else 
		{
		test.fail("Wrong / no placeholder is present in Field 1");
		test.addScreenCaptureFromBase64String(baseClass.capturescreenshot(),"Double Click button");
		}

	}

	@Test(description = "Validate features of Double click functionality")
	public void DC_006()
	{
		extent = ExtentReporter.getExtentReport();

		test = extent.createTest("Double click option").assignAuthor("Mayank Rusia");
		DoubleClick	baseClass = new DoubleClick(driver);
		baseClass.scroll();
		result = baseClass.featuresValidations();
		if(result)
		{
			test.pass("Field 1 is a textbox");
			test.pass("Field 2 is a textbox");
			test.pass("Double click button have correct text inside it");
			test.pass("Correct instruction is displayed");
		}
		else 
		{
		test.fail("Field 1 is NOT a textbox");
		test.fail("Field 2 is NOT a textbox");
		test.fail("Double click button have wrong text inside it");
		test.fail("Wrong instruction is displayed");
		test.addScreenCaptureFromBase64String(baseClass.capturescreenshot(),"Double Click button");
		}
	}

	
}