package TS_001_TextBoxes;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import base.TextBox_Base;
import pageobjects.TextBox;
import utitilites.ExtentReporter;



public class TC_TB extends TextBox_Base
{
	public WebDriver driver;
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
		
	
	@Test(description = "Testing whether fields accepting whitespaces & showing warning messages for Email, Phone textboxes")
	public void TB_002() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		
		test = extent.createTest("TextBox functionality").assignAuthor("Mayank Rusia");
		TextBox baseClass = new TextBox(driver);
		baseClass.enterName("     jay     ");											
		baseClass.enterEmailAddress("mohit   875@ yahoo.com");						
		baseClass.enterPhoneNumber("6523   985");							
		baseClass.enterAddress("453/s      sagar,         M.P"); 			

		boolean result = baseClass.checkingName();
		if(result) 
		{
			test.log(Status.PASS,"Name entered correctly");
		}
		else 
		{
			test.log(Status.FAIL, "Name is NOT correctly entered in textbox").addScreenCaptureFromBase64String(captureScreenshot(driver),"Name Textbox");		
		}

		boolean result1 = baseClass.checkingEmail();
		if(result1) 
		{
			test.log(Status.PASS, "Proper warning message is displayed for Email textbox");
		}
		else 
		{
			test.log(Status.FAIL, "No warning message is displayed for Email textbox").addScreenCaptureFromBase64String(captureScreenshot(driver),"Email Textbox");					
		}

		boolean result2 = baseClass.checkingPhone();
		if(result2) 
		{
			test.log(Status.PASS, "Proper warning message is displayed for Phone textbox");
		}
		else 
		{
			test.log(Status.FAIL, "No warning message is displayed for Phone textbox").addScreenCaptureFromBase64String(captureScreenshot(driver),"Phone Textbox");					
		}

		boolean result3 = baseClass.checkingAddress();
		if(result3) 
		{
			test.log(Status.PASS, "Address textbox is accepting whitespaces");
		}
		else 
		{
			test.log(Status.FAIL, "Address textbox is NOT accepting whitespaces").addScreenCaptureFromBase64String(captureScreenshot(driver),"Address Textbox");					
		}
	}
	
	
	
	@Test(dataProvider = "textbox_dataprovider",dataProviderClass = utilities.DataProvider_textboxes.class, description = "Validate whether (Phone) textbox have Data Validations.")
	public void TB_003(String data)
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Data validation on PhoneNo. text field").assignAuthor("Mayank Rusia");
		TextBox baseClass = new TextBox(driver);

		int results = baseClass.phoneNumber_Validation(data);
		if(results == 1)
		{
			test.pass("Phone Number textbox have data validation feature & is properly showing warning messages for invalid input data");
		}
		if(results == -1) 
		{
			test.fail("Phone Number textbox Doesnot have proper data validations & not showing any warning messages for invalid input data").addScreenCaptureFromBase64String(captureScreenshot(driver),"Phone validation");
		}
	}


	@Test(description = "Validate whether all textboxes have proper Placeholders")
	public void TB_004()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Placeholder checking").assignAuthor("Mayank Rusia");

		TextBox baseClass = new TextBox(driver);
		boolean nameResult = baseClass.placeholderName();
		boolean emailResult = baseClass.placeholderEmail();
		boolean phoneResult = baseClass.placeholderPhone();
		boolean addressResult = baseClass.placeholderAddress();


		if(nameResult)
		{
			test.pass("Correct placeholder is present inside Name textbox");
		}
		else 
		{
			test.fail("Wrong/no placeholder is present inside Name textbox").addScreenCaptureFromBase64String(captureElementScreenshot_name(),"Name Textbox");					
		}

		if(addressResult)
		{
			test.pass("Correct placeholder is present inside Address textbox");
		}
		else 
		{
			test.fail("Wrong/no placeholder is present inside address textbox").addScreenCaptureFromBase64String(captureElementScreenshot_address(),"Address textbox");
		}

		if(phoneResult)
		{
			test.pass("Correct placeholder is present inside Phone textbox");
		}
		else 
		{
			test.fail("Wrong/no placeholder is present inside Phone textbox").addScreenCaptureFromBase64String(captureElementScreenshot_phone(),"Phone Textbox");					
		}

		if(emailResult)
		{
			test.pass("Correct placeholder is present inside Email textbox");
		}
		else 
		{
			test.fail("Wrong/no placeholder is present inside Email textbox").addScreenCaptureFromBase64String(captureElementScreenshot_email(),"Email Textbox");					
		}

	}



	@Test(description = "Validate working of textboxes, by entering all textboxes fields with keyboard key actions.")
	public void TB_005() throws InterruptedException
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("Keyboard action").assignAuthor("Mayank Rusia");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		TextBox baseClass = new TextBox(driver);
		baseClass.enterName("Rohit yadav");
		baseClass.nameAction();
		baseClass.enterEmailAddress("rohit766@gmail.com");
		baseClass.emailAction();
		baseClass.enterPhoneNumber("7845962136");							
		baseClass.phoneAction();
		baseClass.enterAddress("545/2, subhas nagar, Nagda"); 			
		
		test.addScreenCaptureFromBase64String(captureScreenshot(driver),"Full operation");
	}



	@Test(description = "Validate UI of Textboxes functionality.")
	public void TB_006()
	{
		extent = ExtentReporter.getExtentReport();
		test = extent.createTest("UI of Textbox").assignAuthor("Mayank Rusia");
		TextBox baseClass = new TextBox(driver);

		result = baseClass.nameOptions();
		if(result)
		{
			test.pass("Correct properties of Name option");
		}
		else 
		{
			test.fail("Wrong properties of Name option").addScreenCaptureFromBase64String(captureScreenshot(driver),"Name Textbox");					
		}

		if(baseClass.emailOptions())
		{
			test.pass("Correct properties of Email option");
		}
		else 
		{
			test.fail("Wrong properties of Email option").addScreenCaptureFromBase64String(captureScreenshot(driver),"Email Textbox");					
		}

		if(baseClass.phoneOptions())
		{
			test.pass("Correct properties of Phone option");
		}
		else 
		{
			test.fail("Wrong properties of Phone option").addScreenCaptureFromBase64String(captureScreenshot(driver),"Phone Textbox");					
		}

		if(baseClass.addressOptions())
		{
			test.pass("Correct properties of Address option");
		}
		else 
		{
			test.fail("Wrong properties of Address option").addScreenCaptureFromBase64String(captureScreenshot(driver),"Address Textbox");					
		}

	}
	
}
