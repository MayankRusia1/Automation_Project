package pageobjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

public class Hyperlinks 
{
	public WebDriver driver;
	
	public Hyperlinks(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//a[normalize-space()='orange HRM']")
	private WebElement orangeHRM;
	
	@FindBy(xpath = "//a[normalize-space()='open cart']")
	private WebElement opencart;
	
	@FindBy(xpath = "//a[normalize-space()='Home']")
	private WebElement home;
	
	@FindBy(xpath = "//a[normalize-space()='Posts (Atom)']")
	private WebElement downloadElement;
	
	

	//implementation methods
	public WebElement downloadItem()
	{
		return downloadElement;
	}

	public WebElement opencartlink()
	{
		return opencart;
	}


	public WebElement orangeHRMlink()
	{
		return orangeHRM;
	}

	public WebElement homelink()
	{
		return home;
	}


	public void hyperlinks()
	{
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(orangeHRMlink().isDisplayed(), "Orange hrm link is loaded & diplayed successfully on page");
		softAssert.assertTrue(orangeHRMlink().isEnabled(), "Orange hrm link is Enabled");
		softAssert.assertTrue(opencartlink().isDisplayed(), "Open cart link is loaded & diplayed successfully on page");
		softAssert.assertTrue(opencartlink().isEnabled(), "Open cart link is Enabled");
		softAssert.assertTrue(homelink().isDisplayed(), "Home link is loaded & diplayed successfully on page");
		softAssert.assertTrue(homelink().isEnabled(), "Home link is Enabled");
		softAssert.assertAll();
	}


	public void orangeHRMTesting(ExtentTest test)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		orangeHRMlink().click();

		String exptitle = "OrangeHRM";
		String acttitle = driver.getTitle();
		String expheading = "Login";
		String actheading = driver.findElement(By.xpath("//h5[normalize-space()='Login']")).getText();
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));

		if(exptitle.equals(acttitle) && expheading.equals(actheading) && username.isDisplayed() && password.isDisplayed())
		{
			test.pass("User landed on OrangeHRM login page");
		}
		else 
		{
			test.fail("User is NOT landed on OrangeHRM login page");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Orange HRM hyperlink");	
		}
	}

	
	public void opencartTesting(ExtentTest test)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		opencartlink().click();
		String exptitle = "Your Store";
		String acttitle = driver.getTitle();
		WebElement logo = driver.findElement(By.xpath("//img[@title='Your Store']"));	

	if(exptitle.equals(acttitle) && logo.isDisplayed())
	{
		test.pass("User landed on Open cart Home page");
	}
	else 
	{
		test.fail("User is NOT landed on Open cart Home page");
	test.addScreenCaptureFromBase64String(capturescreenshot(),"Open cart hyperlink");	
	}
	}
	
	public void Hometesting(ExtentTest test)
	{
		homelink().click();
		String exptitle = "Automation Testing Practice";
		String acttitle = driver.getTitle();
		WebElement heading = driver.findElement(By.xpath("//h1[normalize-space()='Automation Testing Practice']"));	

	if(exptitle.equals(acttitle) && heading.isDisplayed())
	{
		test.pass("User landed on Automation Testing Practice Home page");
	}
	else 
	{
		test.fail("User is NOT landed on Automation Testing Practice Home page");
	test.addScreenCaptureFromBase64String(capturescreenshot(),"Open cart hyperlink");	
	}
	}

	
	public void newBrowserWindowtesting(ExtentTest test)
	{
		orangeHRMlink().click();
		Set<String> op = driver.getWindowHandles();
		int count = 0;
		for(String string : op)
		{
			count ++;
			test.info("Browser ID: ").info(string);
			String titleString = driver.switchTo().window(string).getTitle();
			test.info("Title of page: ").info(titleString);
		}		
		if(count == 1)
		{
			test.fail("User is navigated to orange HRM login page, in the same browser tab");
		}
		else 
		{
			test.pass("User is navigated to orange HRM login page, on a new browser tab");
		}
	}



	public void scroll()
	{
		WebElement scrollingElement = driver.findElement(By.xpath("//p[normalize-space()='Date:']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", scrollingElement);
	}

	public String capturescreenshot()
	{
		String image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return image;
	}
}
