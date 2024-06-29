package pageobjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

public class NewBrowserWindowButton 
{
	public WebDriver driver;
	
	public NewBrowserWindowButton(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//button[normalize-space()='New Browser Window']")
	private WebElement nbw;
	
	
	//implementation methods
	public WebElement NewBrowserWindowButtons()
	{
		return nbw;
	}

	public void newButtonAction(ExtentTest test)
	{
		NewBrowserWindowButtons().click();

		Set<String> options = driver.getWindowHandles();
		String pagetitle1 = "Automation Testing Practice";
		String pagetitle2 = "Your Store";
		String pageurl1 = "https://testautomationpractice.blogspot.com/";
		String pageurl2 = "https://demo.opencart.com/";
		int count=0;

		for(String eString : options)
		{
			count++;
			driver.switchTo().window(eString);
			if(count == 1)
			{
				if(pagetitle1.equals(driver.getTitle()) && pageurl1.equals(driver.getCurrentUrl()))
				{
					test.pass("Automation Testing Practice is opened in 1 separate tab");
					test.addScreenCaptureFromBase64String(capturescreenshot(),"Automation testing practice");
				}
				else 
				{
					test.fail("Automation Testing Practice is NOT opened in 1 separate tab");	
					test.addScreenCaptureFromBase64String(capturescreenshot(),"Automation testing practice");
				}
			}
			if(count == 2)
			{
				if(pagetitle2.equals(driver.getTitle()) && pageurl2.equals(driver.getCurrentUrl()))
				{
					test.pass("Your Store is opened in 1 separate tab");
					test.addScreenCaptureFromBase64String(capturescreenshot(),"Your store");
				}
				else 
				{
					test.fail("Your Store is NOT opened in 1 separate tab");	
					test.addScreenCaptureFromBase64String(capturescreenshot(),"Your store");
				}
			}
		}
	}

	
	public void oneClickOneNewWindow(ExtentTest test)
	{
		NewBrowserWindowButtons().click();

		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);

		int count =0;
		for(String e : windowhandles)
		{
			count++;
			driver.switchTo().window(e);
		}

		if(count > 1)
		{
			test.pass("A new browser window opens");
		}
		else 
		{
			test.fail("No new browser window opens , after clicking on button");			
			test.addScreenCaptureFromBase64String(capturescreenshot());
		}
	}
	
	
	
	public void newBrowserWindowFeatures(ExtentTest test)
	{
		String exptext = "New Browser Window";
		String acttext = NewBrowserWindowButtons().getText();

		if(exptext.equals(acttext))
		{
			test.pass("Correct spelling of New browser window button");
		}
		else 
		{	
			test.fail("Wrong spelling is displayed on button");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"New Browser window Feature");
		}
	}
	
	
	

	public void crossBrowserTesting()
	{
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(NewBrowserWindowButtons().isDisplayed(), "New Browser window button is NOT displayed");
		softAssert.assertTrue(NewBrowserWindowButtons().isEnabled(), "New Browser window button is Disabled");	
		softAssert.assertAll();
		System.out.println("New Browser window button is loaded successfully on page");
	}

	public String capturescreenshot()
	{
		String image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return image;
	}
}
