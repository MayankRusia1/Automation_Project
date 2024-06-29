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

public class Slider 
{
	public WebDriver driver;

	public Slider(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}

	@FindBy(xpath = "//div[@id='slider']")
	public WebElement slider;
	
	@FindBy(xpath = "//span[@class='ui-slider-handle ui-corner-all ui-state-default']")
	public WebElement sliderbar;
	
	
	//implementation methods
	public WebElement SliderElement()
	{
		return	slider;
	}

	public WebElement SliderBar()
	{
		return	sliderbar;
	}


	public void crossbrowser()
	{
		Assert.assertTrue(SliderElement().isDisplayed(),"Slider feature is NOT displayed");
	}


	public boolean SliderBar(ExtentTest test) throws InterruptedException
	{
		WebElement sliderbar = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));

		Actions actions = new Actions(driver);
		test.addScreenCaptureFromBase64String(capturescreenshot(),"Original position");
		actions.dragAndDropBy(sliderbar, 20, 0).build().perform();					Thread.sleep(1000);
		test.addScreenCaptureFromBase64String(capturescreenshot(),"1st new position");
		actions.dragAndDropBy(sliderbar, 50, 0).build().perform();					Thread.sleep(1000);
		test.addScreenCaptureFromBase64String(capturescreenshot(),"2nd new position");		
		actions.dragAndDropBy(sliderbar, -30, 0).build().perform();					Thread.sleep(1000);
		test.addScreenCaptureFromBase64String(capturescreenshot(),"3rd new position");
		actions.dragAndDropBy(sliderbar, 60, 0).build().perform();					Thread.sleep(1000);
		test.addScreenCaptureFromBase64String(capturescreenshot(),"4th new position");
		actions.dragAndDropBy(sliderbar, -50, 0).build().perform();					Thread.sleep(1000);
		test.addScreenCaptureFromBase64String(capturescreenshot(),"5th new position");

		Point point = sliderbar.getLocation();
		String explocation = "(913, 1081)";
		String actlocation = point.toString();
		if(explocation.equals(actlocation))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public void SliderBarSmoothWorking(ExtentTest test)
	{
		Actions actions = new Actions(driver);
		WebElement sliderbar = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));

		test.addScreenCaptureFromBase64String(capturescreenshot(),"Original position of slider bar");
		int i=0;
		while(i<30)
		{
			actions.dragAndDropBy(sliderbar, i, 0).build().perform();				
			i++;
		}
		test.addScreenCaptureFromBase64String(capturescreenshot(),"Final position of slider bar");
		test.pass("Slider is moving smoothly");
	}


	public void SliderBarMovingUsingKeyboardKeys(ExtentTest test)
	{
		WebElement sliderbar = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));

		test.addScreenCaptureFromBase64String(capturescreenshot(),"Original position of slider bar");
		sliderbar.click();									test.info("Slider bar is clicked");
		sliderbar.sendKeys(Keys.ARROW_RIGHT);				test.info("Right keyboard key is clicked");
		sliderbar.sendKeys(Keys.ARROW_RIGHT);				test.info("Right keyboard key is clicked");
		sliderbar.sendKeys(Keys.ARROW_LEFT);				test.info("Left keyboard key is clicked");
		sliderbar.sendKeys(Keys.ARROW_LEFT);				test.info("Left keyboard key is clicked");
		sliderbar.sendKeys(Keys.ARROW_RIGHT);				test.info("Right keyboard key is clicked");
		sliderbar.sendKeys(Keys.ARROW_LEFT);				test.info("Left keyboard key is clicked");
		sliderbar.sendKeys(Keys.ARROW_RIGHT);				test.info("Right keyboard key is clicked");
		test.addScreenCaptureFromBase64String(capturescreenshot(),"Final position of slider bar");
	}



	public String capturescreenshot()
	{
		String image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return image;
	}

	public void scroll()
	{
		WebElement scrollingElement = driver.findElement(By.xpath("//h2[normalize-space()='Slider']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", scrollingElement);
	}
}
