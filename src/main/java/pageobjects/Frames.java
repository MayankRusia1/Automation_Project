package pageobjects;

import java.time.Duration;
import java.util.List;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

public class Frames 
{
	public WebDriver driver;
	
	public Frames(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//h2[normalize-space()='Frames']")
	WebElement frames;
	
	@FindBy(css = "input[class='text_field']")
	WebElement nameElement;

	@FindBy(css = ".drop_down")
	WebElement JobElement;

	@FindBy(css  = "input[placeholder='mm/dd/yyyy']")
	WebElement dateElement;

	@FindBy(css = "label[for='RESULT_RadioButton-1_0']")
	WebElement MaleGenderElement;

	@FindBy(css = "label[for='RESULT_RadioButton-1_1']")
	WebElement FemaleGenderElement;

	@FindBy(css = "a[tabindex='-1'][target='_blank']")
	WebElement Reportabuse;
	
	@FindBy(css = "a[target='_top']")
	WebElement PoweredbyFormsite;

	@FindBy(css = "input[value='Submit']")
	WebElement button;

	@FindBy(xpath  = "//div[@class='form_table']")
	WebElement result;

	@FindBy(tagName = "iframe")
	WebElement iframes;



	//implementation methods
	public WebElement name()
	{
		return  nameElement;		
	}

	public WebElement buttons()
	{
		return  button;		
	}
	
	public WebElement job()
	{
		return  JobElement;		
	}
	public WebElement date()
	{
		return  dateElement;		
	}
	public WebElement male()
	{
		return  MaleGenderElement;		
	}
	public WebElement female()
	{
		return  FemaleGenderElement;		
	}

	public WebElement Report()
	{
		return  Reportabuse;		
	}
	public WebElement Poweredby()
	{
		return  (PoweredbyFormsite);		
	}

	public WebElement resultElement()
	{
		return (result);
	}

	public WebElement iframeElement()
	{
		return (iframes);
	}



	public void frameItems()
	{
		WebElement frame = (frames);
		Assert.assertTrue(frame.isDisplayed(), "Iframes are NOT loaded successfully");

		driver.switchTo().frame(0);

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertTrue(name().isDisplayed(), "Name textbox is NOt loaded");
		softAssert.assertTrue(job().isDisplayed(), "Job drop-down is NOt loaded");
		softAssert.assertTrue(date().isDisplayed(), "Date picker is NOt loaded");
		softAssert.assertTrue(male().isDisplayed(), "Male Gender radio buttons is NOt loaded");
		softAssert.assertTrue(female().isDisplayed(), "Female Gender radio buttons is NOt loaded");		
		softAssert.assertTrue(Report().isDisplayed(), "Report abuse link is NOt loaded");
		softAssert.assertTrue(Poweredby().isDisplayed(), "Powered by formsite link is NOt loaded");
		softAssert.assertTrue(buttons().isDisplayed(), "Submit button is NOt loaded");
		softAssert.assertAll();
	}


	public void reportAbuseFunctionality(ExtentTest test)
	{
		driver.switchTo().frame(0);
		test.info("Switched inside frame");
		Report().click();

		Set<String> windowHandles = driver.getWindowHandles();

		// Iterate through each window handle
		for (String windowHandle : windowHandles)
		{
			test.info("ID of browser");
			test.info(windowHandle);
			driver.switchTo().window(windowHandle);
			test.info("Page name");
			String newPageTitle = driver.getTitle();
			test.info(newPageTitle);
		}

		int windowcount = windowHandles.size();

		if(windowcount == 2)
		{
			test.pass("Report abuse page is opened in a new browsing window");
		}
		else 
		{
			test.fail("Report abuse page is opened in same browsing window");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Iframes");
		}
	}

	

	public void poweredByFunctionality(ExtentTest test)
	{
		driver.switchTo().frame(0);
		test.info("Switched inside frame");
		Poweredby().click();

		Set<String> windowhandle = driver.getWindowHandles();

		for(String e : windowhandle)
		{
			test.info("ID of browser & name of page..");
			test.info(e);			
			driver.switchTo().window(e);
			String newPageTitle = driver.getTitle();
			test.info(newPageTitle);
		}

		int windowcount = windowhandle.size();
		if(windowcount == 2)
		{
			test.pass("Formsite page is opened in a new browsing window");
		}
		else 
		{
			test.fail("Formsite page is opened in same browsing window");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Iframes");
		}
	}


	public void formFilling(ExtentTest test)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.switchTo().frame(0);
		test.info("switched inside iframe");

		name().sendKeys("aman");

		date().click();
		date().sendKeys("5/12/1997");

		Select select = new Select(job());
		select.selectByVisibleText("Manager");

		male().click();

		buttons().click();

		String expresult = "Form is submitted successfully";
		String actresult = resultElement().getText();	

		if(actresult.equals(expresult))
		{
			test.pass("Form is submitted successfully");
		}
		else 
		{
			test.fail("Form is NOT submitted successfully");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Iframes");
		}
	}



	public void Placeholders(ExtentTest test)
	{
		driver.switchTo().frame(0);
		test.info("switched inside iframe");

		String expname = "Enter Name";
		String expdate = "mm/dd/yyyy";
		String actname = name().getAttribute("placeholder");
		String actdate = date().getAttribute("placeholder");

		if(actdate.equals(expdate))
		{
			test.pass("Correct placholder for Date");
		}
		else
		{
			test.fail("Incorrect placeholder for Date");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Iframes");
		}
		if(actname.equals(expname))
		{
			test.pass("Correct placholder for Name");
		}
		else
		{
			test.fail("Wrong placeholder for Name");		
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Iframes");
		}
	}



	public void presenceOfIframes(ExtentTest test)
	{
		List<WebElement> iframes =	driver.findElements(By.tagName("iframe"));

		Assert.assertTrue(iframeElement().isDisplayed(),"Iframe is NOT present on page");
		int sizeOfiframe =	iframes.size();

		if(sizeOfiframe == 1)
		{
			test.pass("1 iframes are present on page");
		}
		else 
		{
			test.fail("More or less than 1 iframes are present on page");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Iframes");
		}
	}


	public void iframeAttributes(ExtentTest test)
	{
		String actsrc = iframeElement().getAttribute("src");
		String actscrolling = iframeElement().getAttribute("scrolling");
		String actheight = iframeElement().getAttribute("height");
		String actstyle = iframeElement().getAttribute("style");

		String expsrc = "https://fs24.formsite.com/res/showFormEmbed?EParam=m_OmK8apOTDpwCqUlfXbL2rYe2Y6sJfY&796456169&EmbedId=796456169";
		String expscrolling = "no";
		String expStyling = "border: 0px; margin: 0px; padding: 0px; width: 100%;";
		String expheight = "545";

		if(actheight.equals(expheight) && actscrolling.equals(expscrolling) && actsrc.equals(expsrc) &&  actstyle.equals(expStyling))
		{
			test.pass("Correct height property");
			test.pass("Correct scrolling property");
			test.pass("Correct src property");
			test.pass("Correct styling property");
		}
		else 
		{
			test.fail("Wrong height property");
			test.fail("Wrong scrolling property");
			test.fail("Wrong src property");
			test.fail("Wrong styling property");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Iframes");
		}
	}

	public void iframeNavigation(ExtentTest test)
	{
		//after navigating to iframe
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.switchTo().frame(0);
		test.info("switched inside iframe");

		if(name().isDisplayed() && job().isDisplayed() && date().isDisplayed() && male().isDisplayed() && female().isDisplayed() && Report().isDisplayed() && Poweredby().isDisplayed() && buttons().isDisplayed())
		{
			test.pass("Name textbox is loaded");
			test.pass("Job drop-down is loaded");
			test.pass("Date picker is loaded");
			test.pass("Male Gender radio buttons is loaded");
			test.pass("Female Gender radio buttons is loaded");
			test.pass("Report abuse link is loaded");
			test.pass("Powered by formsite link is loaded");
			test.pass("Submit button is loaded");
		}
		else 
		{
			test.fail("Name textbox is NOt loaded");
			test.fail("Job drop-down is NOt loaded");
			test.fail("Date picker is NOt loaded");
			test.fail("Male Gender radio buttons is NOt loaded");
			test.fail("Female Gender radio buttons is NOt loaded");
			test.fail("Report abuse link is NOt loaded");
			test.fail("Powered by formsite link is NOt loaded");
			test.fail("Submit button is NOt loaded");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Iframes");
		}
	}




	public void iframeRefresh(ExtentTest test)
	{
		//before refreshing page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.switchTo().frame(0);
		test.info("switched inside iframe");	

		name().sendKeys("Aman");
		date().sendKeys("5/15/1999");

		String bactname1 = name().getAttribute("value");
		String bactdate1 = date().getAttribute("value");

		//after refreshing page

		driver.navigate().refresh();

		driver.switchTo().frame(0);
		test.info("Again going to iframe, after refreshing");

		String aactname = name().getAttribute("value");
		String aactdate = date().getAttribute("value");

		if(!aactdate.equals(bactdate1) && !aactname.equals(bactname1))
		{
			test.pass("Data is removed after refreshing page");
			test.pass("Name is removed after refreshing page");
		}
		else 
		{
			test.fail("Data is NOT removed after refreshing page");
			test.fail("Name is NOT removed after refreshing page");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Iframes");
		}

	}



	public String capturescreenshot()
	{
		String image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return image;
	}


	public void scroll()
	{
		WebElement scrolling = driver.findElement(By.xpath("//h2[normalize-space()='Frames']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", scrolling);
	}
}
