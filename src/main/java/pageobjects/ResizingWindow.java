package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class ResizingWindow 
{
	public WebDriver driver;
	
	public ResizingWindow(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//div[@id='resizable']")
	private WebElement reziable;
	
	@FindBy(xpath = "//h3[normalize-space()='Resizable']")
	private WebElement resizingText;
	
	@FindBy(xpath = "//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")
	private WebElement resizingIconElement;
	

	//implementation methods
	public WebElement resizableElement()
	{
		return reziable;
	}

	public WebElement resizableText()
	{
		return resizingText;
	}

	public WebElement resizingIcon()
	{
		return resizingIconElement;
	}

	
	public void crossBrowser()
	{
		Assert.assertTrue(resizableElement().isDisplayed(),"Resizable window is NOT loaded on page");
	}


	public void resizingTextFeature(ExtentTest test)
	{
		String exptext = "Resizable";
		String acttext = resizableText().getText();
		if(exptext.equals(acttext))
		{
			test.pass("Resizable text is present & correctly spelled");
		}
		else 
		{
		test.fail("Resizable text is NOT present / not correctly spelled");
		test.addScreenCaptureFromBase64String(capturescreenshot(),"Resizing window");
		}
	}


	public void resizingIconMethod(ExtentTest test)
	{
		if(resizingIcon().isDisplayed())
		{
			test.pass("Resizing icon is present");
		}
		else 
		{
		test.fail("Resizing icon is NOT present");
		test.addScreenCaptureFromBase64String(capturescreenshot());
		}
	}
	
	
	public void resizingWindowActivity(ExtentTest test) throws InterruptedException
	{
		Actions actions = new Actions(driver);

		System.out.println("Moving in x axis (left - right)");
		actions.dragAndDropBy(resizingIcon(), 80, 0).build().perform();					Thread.sleep(1000);
		actions.dragAndDropBy(resizingIcon(), -30, 0).build().perform();				Thread.sleep(1000);

		System.out.println("Moving in y axis (up - down)");
		actions.dragAndDropBy(resizingIcon(), 0, 90).build().perform();					Thread.sleep(1000);
		actions.dragAndDropBy(resizingIcon(), 0, -30).build().perform();				Thread.sleep(1000);
		
		System.out.println("Moving in both direction simultaneously");
		actions.dragAndDropBy(resizingIcon(), 150, 80).build().perform();				Thread.sleep(1000);
		actions.dragAndDropBy(resizingIcon(), -50, -10).build().perform();				Thread.sleep(1000);
		actions.dragAndDropBy(resizingIcon(), 150, -80).build().perform();				Thread.sleep(1000);
		actions.dragAndDropBy(resizingIcon(), -20, 100).build().perform();				Thread.sleep(1000);	
		
		Point point = resizingIcon().getLocation();
		String explocation = "(1249, 1986)";
		String actlocation = point.toString();
		if(explocation.equals(actlocation))
		{
			test.pass("Resizing window icon working properly");
		}
		else
		{
			test.fail("Resizing icon is NOT working properly");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Resizing window");
		}
	}
	

	public String capturescreenshot()
	{
		String image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return image;
	}



	public void scroll()
	{
		WebElement scrollingElement = driver.findElement(By.xpath("//h2[normalize-space()='Resizable']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", scrollingElement);
	}
}
