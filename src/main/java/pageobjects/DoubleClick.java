package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoubleClick 
{
	public WebDriver driver;
	
	public DoubleClick(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);		
	}
	
	@FindBy(xpath = "//button[normalize-space()='Copy Text']")
	public WebElement doubleClickElement;
	
	@FindBy(xpath = "//input[@value='Hello World!']")
	public WebElement field1;

	@FindBy(xpath = "//div[@class='column-right-outer']//input[2]")
	public WebElement field2;

	@FindBy(xpath = "//p[contains(text(),'Double click on button, the text from Field1 will ')]")
	public WebElement para;

	
	//implementation methods

	
	public WebElement doubleClickButton()
	{
		return doubleClickElement;
	}
	
	
	public boolean defaultValues()
	{
		String exptext1 = "Hello World!";
		String acttext1 = field1.getAttribute("value");

		String exptext2 = "";
		String acttext2 = field2.getText();

		if(exptext1.equals(acttext1) && exptext2.equals(acttext2))
		{	
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	
	
	public void dataCopy_doubleClick(String data)
	{
		field1.clear();
		field1.sendKeys(data);
		Actions actions = new Actions(driver);
		WebElement button = doubleClickElement;
		actions.doubleClick(button).build().perform();
	}
	
	
	public void dataCopy_singleClick(String data)
	{
		field1.clear();
		field1.sendKeys(data);
		WebElement button = doubleClickElement;
		button.click();
	}
	
	public boolean placeholder()
	{
		field1.clear();
		String exptext = "Enter text here";
		String acttext = field1.getAttribute("value");
		if(exptext.equals(acttext))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	
	public boolean featuresValidations()
	{
		String expf1 = "text";
		String actf1 = field1.getAttribute("type");

		String expf2 = "text";
		String actf2 = field2.getAttribute("type");

		String exptext1 = "Copy Text";
		String acttext1 = doubleClickElement.getText();

		String exptext2 = "Double click on button, the text from Field1 will be copied into Field2.";
		String acttext2 = para.getText();

		if(actf1.equals(expf1) && actf2.equals(expf2) && acttext1.equals(exptext1) && acttext2.equals(exptext2))
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
	
	public void scroll()
	{
		WebElement scrollingElement = driver.findElement(By.xpath("//h2[normalize-space()='Double Click']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", scrollingElement);
	}
}
