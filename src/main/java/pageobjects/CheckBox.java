package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBox 
{
	public WebDriver driver;
	
	public CheckBox(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//input[@id='sunday']")
	public WebElement sunday;
	
	@FindBy(xpath = "//input[@id='monday']")
	public WebElement monday;
	
	@FindBy(xpath = "//input[@id='tuesday']")
	public WebElement tuesday;
	
	@FindBy(xpath = "//input[@id='wednesday']")
	public WebElement wednesday;
	
	@FindBy(xpath = "//input[@id='thursday']")
	public WebElement thursday;

	@FindBy(xpath = "//input[@id='friday']")
	public WebElement friday;

	@FindBy(xpath = "//input[@id='saturday']")
	public WebElement saturday;

	@FindBy(xpath = "//label[normalize-space()='Thursday']")
	public WebElement thursdaytext;
	


	//implementation methods
	public boolean sundayIsDisplayed()
	{
		return sunday.isDisplayed();
	}
	public boolean mondayIsDisplayed()
	{
		return monday.isDisplayed();
	}
	public boolean tuesdayIsDisplayed()
	{
		return tuesday.isDisplayed();
	}
	public boolean wednesdayIsDisplayed()
	{
		return wednesday.isDisplayed();
	}
	public boolean thursdayIsDisplayed()
	{
		return thursday.isDisplayed();
	}
	public boolean fridayIsDisplayed()
	{
		return friday.isDisplayed();
	}
	public boolean saturdayIsDisplayed()
	{
		return saturday.isDisplayed();
	}

	
	public boolean sundayIsEnabled()
	{
		return sunday.isEnabled();
	}
	public boolean mondayisEnabled()
	{
		return monday.isEnabled();
	}
	public boolean tuesdayisEnabled()
	{
		return tuesday.isEnabled();
	}
	public boolean wednesdayisEnabled()
	{
		return wednesday.isEnabled();
	}
	public boolean thursdayisEnabled()
	{
		return thursday.isEnabled();
	}
	public boolean fridayisEnabled()
	{
		return friday.isEnabled();
	}
	public boolean saturdayisEnabled()
	{
		return saturday.isEnabled();
	}


	public void mondayClick()
	{
		monday.click();
	}
	
	public void tuesdayClick()
	{
		tuesday.click();		
	}

	public void wednesdayClick()
	{
		wednesday.click();
	}

	public void thursdayClick()
	{
		thursday.click();
	}

	public void thursdayTextClick()
	{
		thursdaytext.click();
	}
	
	public void fridayClick()
	{
		friday.click();
	}

	public void saturdayClick()
	{
		saturday.click();
	}

	public void sundayClick()
	{
		sunday.click();
	}
	
	
	public String captureScreenshot()
	{
		String image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return image;
	}

	
	public void scroll()
	{
	WebElement scrolling = driver.findElement(By.xpath("//label[normalize-space()='Days:']"));
	JavascriptExecutor jExecutor = (JavascriptExecutor) driver;
	jExecutor.executeScript("arguments[0].scrollIntoView();",scrolling);
	}
	

}
