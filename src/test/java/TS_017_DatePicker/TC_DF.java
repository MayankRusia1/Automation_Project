package TS_017_DatePicker;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.base.CaseFormat;
import base.DatePicker_Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.DatePicker;
import utitilites.ExtentReporter;


public class TC_DF extends DatePicker_Base
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
	
	
	@Test(description = "Validate whether Date picker is opening a date menu after clicking on Date picker functionality.")
	public void DF_002()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Date picker functionality").assignAuthor("Mayank Rusia");
		DatePicker	baseClass = new DatePicker(driver);
		baseClass.scroll();
		baseClass.crossbrowser(test);
	}

	@Test(dataProvider = ("date_Combinations"), dataProviderClass = utilities.DataProvider_datepicker.class,description = "Validate different formats of dates allowed / not allowed as entered by user directly.")
	public void DF_003(String data) throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Date picker functionality").assignAuthor("Mayank Rusia");
		DatePicker	baseClass = new DatePicker(driver);
		baseClass.scroll();		
		
		int result = baseClass.dateCombinations(data);
		baseClass.datepickerElement().clear();
		switch (result)
		{
		case 1:	if(result == 1)
		{
			test.pass("Correct date is picked for: "+data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),"1st test data");
		}
		break;
		

		
		case 2:	if(result == 2)
		{
			test.pass("Correct date is picked for: "+data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),"2nd test data");
		}
		break;
		
		case 3:	if(result == 3)
		{
			test.pass("Correct date is picked for: "+data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),"3rd test data");
		}
		break;
		

		
		case 4:	if(result == 4)
		{
			test.pass("Correct date is picked for: "+data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),"4th test data");
		}
		break;
		

		case 5:	if(result == 5)
		{
			test.pass("Correct date is picked for: "+data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),"5th test data");
		}
		break;
		

		case 6:	if(result == 6)
		{
			test.pass("Correct date is picked for: "+data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),"6th test data");
		}
		break;
		
		case 7:	if(result == 7)
		{
			test.pass("Correct date is picked for: "+data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),"7th test data");
		}
			break;
		
		case 8:	if(result == 8)
		{
			test.pass("Correct date is picked for: "+data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),"8th test data");
		}
		break;

		
		default:	
			break;
		}
	}


	@Test(description = "Validate whether user is able to select (current month, year) date from calendar.")	
	public void DF_004() throws Exception
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Date picker functionality").assignAuthor("Mayank Rusia");
		DatePicker	baseClass = new DatePicker(driver);
		baseClass.scroll();
		String date = "03/20/2024";	

		baseClass.selectingCurrentMonthYearUsingArrows(date,test);
	}


	
	@Test(description = "Validate whether user is able to select past month, year date from calendar.")
	public void DF_005() throws Exception
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Date picker functionality").assignAuthor("Mayank Rusia");
		DatePicker	baseClass = new DatePicker(driver);
		baseClass.scroll();
		String orgdate = "3/15/2020";	
		baseClass.selectingPastDate(orgdate, test);
	}


	@Test(description = "Validate whether user is able to select future month, year date from calendar.")
	public void DF_006() throws Exception
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Date picker functionality").assignAuthor("Mayank Rusia");
		DatePicker	baseClass = new DatePicker(driver);
		baseClass.scroll();
		String orgdate = "8/25/2028";	
		baseClass.futureDate(orgdate, test);
	}


	@Test(description = "Validate whether all dates in month are arranged in ascending order.")
	public void DF_007()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Date picker functionality").assignAuthor("Mayank Rusia");
		DatePicker	baseClass = new DatePicker(driver);
		baseClass.scroll();
		baseClass.monthSorted(test);
	}



	@Test(description = "Validate whether by default, datepicker will blink current day & show month,year")
	public void DF_008()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Date picker functionality").assignAuthor("Mayank Rusia");
		DatePicker	baseClass = new DatePicker(driver);
		baseClass.scroll();
		baseClass.defaultCurrentDateShowing(test);
	}



	@Test(dataProvider = "date_accepting_different_data",dataProviderClass =utilities.DataProvider_datepicker.class ,description = "Validate that only Numbers & special character (/) is allowed for entering date in date textbox.")
	public void DF_009(String data) throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Date picker functionality").assignAuthor("Mayank Rusia");
		DatePicker	baseClass = new DatePicker(driver);
		baseClass.scroll();
		
		int result = baseClass.validFormatOfData(data);
		baseClass.datepickerElement().clear();
		switch (result)
		{
		case 1:	if(result == 1)
		{
			test.pass("Current date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		break;
		

		
		case 2:	if(result == 2)
		{
			test.pass("Current date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		break;
		

		
		
		case 3:	if(result == 3)
		{
			test.pass("Current date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		break;
		

		
		case 4:	if(result == 4)
		{
			test.pass("Current date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		break;
		

		case 5:	if(result == 5)
		{
			test.pass("Current date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		break;
		

		case 6:	if(result == 6)
		{
			test.pass("Current date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		break;
		
		case 7:	if(result == 7)
		{
			test.pass("Current date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
			break;
		
		case 8:	if(result == 8)
		{
			test.pass("Current date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		break;

		case 9:	if(result == 9)
		{
			test.pass("Current date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		else 
		{
			test.fail("Wrong date is picked for: "+data);
			test.addScreenCaptureFromBase64String(baseClass.screenshots(),data);
		}
		break;
		
		
		default:	
			break;
		}
	}




	@Test(description = "Validate proper placeholder is displayed inside date picker textbox.")
	public void DF_010() throws IOException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Date picker functionality").assignAuthor("Mayank Rusia");
		DatePicker	baseClass = new DatePicker(driver);
		baseClass.scroll();
		baseClass.placeHolders(test);
	}

}