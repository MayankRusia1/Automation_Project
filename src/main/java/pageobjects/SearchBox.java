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

import com.aventstack.extentreports.ExtentTest;

public class SearchBox 
{
	public WebDriver driver;
	
	public SearchBox(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//input[@class='wikipedia-search-input']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement searchicon;
	
	@FindBy(xpath = "//img[@class='wikipedia-icon']")
	private WebElement image;
	
	@FindBy(xpath = "//div[@class='wikipedia-search-results']")
	private WebElement warningMessage;
	
	
	//implementation methods
	public WebElement searchbox()
	{
		return searchBox;
	}

	public WebElement searchicon()
	{
		return	searchicon;
	}

	public WebElement image()
	{
		return	image;
	}

	public WebElement warning()
	{
		return	warningMessage;
	}

	public void searchBoxFeatures()
	{
		if(searchbox().isDisplayed() && searchbox().isEnabled())
		{
			System.out.println("Search box is displayed & enabled");
		}
		else
		{
			System.out.println("Search box is NOT displayed & it is disabled");			
		}
		if(searchicon().isDisplayed() && searchicon().isEnabled())
		{
			System.out.println("Search icon is displayed & enabled");
		}
		else
		{
			System.out.println("Search icon is NOT displayed & it is disabled");			
		}
	}
	
	
	public void imageFunctionality(ExtentTest test)
	{
		image().click();
		int count = 0;
		Set<String> options = driver.getWindowHandles();

		String pagetitle1 = "Automation Testing Practice";
		String pagetitle2 = "Wikipedia, the free encyclopedia";
		String pageurl1 = "https://testautomationpractice.blogspot.com/";
		String pageurl2 = "https://en.wikipedia.org/wiki/Main_Page";
		
		for(String eString : options)
		{
			count++;
			driver.switchTo().window(eString);
			if(count == 1)
			{
				if(pagetitle1.equals(driver.getTitle()) && pageurl1.equals(driver.getCurrentUrl()))
				{
					test.pass("Automation Testing Practice is opened in 1 separate tab");
					test.addScreenCaptureFromBase64String(capturescreenshot(),"Wikipedia icon");
				}
				else 
				{
				test.fail("Automation Testing Practice is NOT opened in 1 separate tab");	
				test.addScreenCaptureFromBase64String(capturescreenshot(),"Wikipedia icon");
				}
			}
			if(count == 2)
			{
				if(pagetitle2.equals(driver.getTitle()) && pageurl2.equals(driver.getCurrentUrl()))
				{
					test.pass("Wikipedia, the free encyclopedia is opened in 1 separate tab");
					test.addScreenCaptureFromBase64String(capturescreenshot(),"Wikipedia icon");
				}
				else 
				{
				test.fail("Wikipedia, the free encyclopedia is NOT opened in 1 separate tab");	
				test.addScreenCaptureFromBase64String(capturescreenshot(),"Wikipedia icon");
				}				
			}
		}
	}
	
	
	
	
	public void search_withoutData(ExtentTest test)
	{
		searchicon().click();
		String acttext = warning().getText();
		String exptext = "Please enter text to search.";

		if(acttext.equals(exptext))
		{
			test.pass("Warning message is displayed");
		}
		else 
		{
		test.fail("Warning message is NOT displayed");
		test.addScreenCaptureFromBase64String(capturescreenshot(),"Warning message");
		}
	}
	
	
	public void placeholders(ExtentTest test)
	{
		String exptext = "Enter Search text here";
		String acttext = searchbox().getAttribute("value");
		if(exptext.equals(acttext))
		{
			test.pass("Proper placeholder is displayed inside Search box");
		}
		else 
		{
		test.fail("Wrong / no placeholder is provided inside Search box");
		test.addScreenCaptureFromBase64String(capturescreenshot(),"Search box");
		}
	}
	
	
	public boolean searchInvalidData(String data) throws InterruptedException
	{
		searchbox().sendKeys(data);
		searchicon().click();
		Thread.sleep(1500);
		String expwarning = "No results found.";
		String actwarning = warning().getText();
		if(expwarning.equals(actwarning))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public String capturescreenshot()
	{
		String image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return image;
	}	
}
