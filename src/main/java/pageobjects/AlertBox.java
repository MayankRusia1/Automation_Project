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

public class AlertBox 
{
	public WebDriver driver;
	
	public AlertBox(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//button[normalize-space()='Alert']")
	private WebElement alertButton;
	
	@FindBy(xpath = "//button[normalize-space()='Prompt']")
	private WebElement promptButton;
	
	@FindBy(xpath = "//button[normalize-space()='Confirm Box']")
	private WebElement confirmButton;
	
	@FindBy(xpath = "//p[@id='demo']")
	private WebElement textlocation;
	

	//implementation methods
	public boolean alertButtondisplayed()
	{
		return	alertButton.isDisplayed();
	}

	public boolean alertButtonEnabled()
	{
		return	alertButton.isEnabled();		
	}


	public boolean confirmButtondisplayed()
	{
		return	confirmButton.isDisplayed();
	}

	public boolean confirmButtonEnabled()
	{
		return	confirmButton.isEnabled();
	}

	public boolean promptDisplayed()
	{
		return	promptButton.isDisplayed();
	}

	public boolean promptEnabled()
	{
		return	promptButton.isEnabled();
	}

	public boolean alertButton_OK_option() throws InterruptedException
	{
		alertButton.click();					Thread.sleep(2000);
		String exptext = "I am an alert box!";
		String acttext = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(exptext.equals(acttext))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}


	public boolean confirmButton_OKOption() throws InterruptedException
	{
		confirmButton.click();
		Thread.sleep(1500);
		String actdefaulttext = driver.switchTo().alert().getText();
		String expdefaulttext = "Press a button!";
		driver.switchTo().alert().accept();
		String exptext = "You pressed OK!";
		String acttext = textlocation.getText();
		if(actdefaulttext.equals(expdefaulttext) && acttext.equals(exptext))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	public boolean confirmButton_CANCELOption() throws InterruptedException
	{
		confirmButton.click();
		Thread.sleep(1500);
		String actdefaulttext = driver.switchTo().alert().getText();
		String expdefaulttext = "Press a button!";
		driver.switchTo().alert().dismiss();
		String exptext = "You pressed Cancel!";
		String acttext = textlocation.getText();
		if(actdefaulttext.equals(expdefaulttext) && acttext.equals(exptext))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	public boolean promptButton_withoutPrompt_OKButton() throws InterruptedException
	{
		promptButton.click();  						Thread.sleep(1500);
		driver.switchTo().alert().accept();
		String exptext = "Hello Harry Potter! How are you today?";
		String acttext = textlocation.getText();
		if(exptext.equals(acttext))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	
	public boolean promptButton_withoutPrompt_Cancelbutton() throws InterruptedException
	{
		promptButton.click();  								Thread.sleep(1500);
		driver.switchTo().alert().dismiss();
		String exptext = "User cancelled the prompt.";
		String acttext = textlocation.getText();
		if(exptext.equals(acttext))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	
	public int dataDrivenTesting_promptButton(String data) throws InterruptedException
	{
		promptButton.click();  												Thread.sleep(1500);
		driver.switchTo().alert().sendKeys(data);							Thread.sleep(1500);
		driver.switchTo().alert().accept();

		String exptext1 = "Hello aa     hh! How are you today?";
		String exptext2 = "Hello Hello! How are you today?";
		String exptext3 = "Hello 8473968586! How are you today?";
		String exptext4 = "Hello jjffj  ##@@ (&&)! How are you today?";
		String exptext5 = "Hello jjjaiiiia! How are you today?";
		String exptext6 = "Hello 9888 22 556 6 ^ %! How are you today?";

		String acttext = textlocation.getText();

		
		
		if(data.equals("Hello"))
		{
			if(exptext2.equals(acttext))
			{
				return 1;
			}
			else 
			{
				return 0;
			}
		}
		

		else if(data.equals("8473968586"))
		{
			if(exptext3.equals(acttext))
			{
				return 1;
			}
			else 
			{
				return 0;
			}
		}

		
		else if(data.equals("Hello jjffj  ##@@ (&&)"))
		{
			if(exptext4.equals(acttext))
			{
				return 1;
			}
			else 
			{
				return 0;
			}
		}

		else if(data.equals("jjjaiiiia"))
		{
			if(exptext5.equals(acttext))
			{
				return 1;
			}
			else 
			{
				return 0;
			}
		}

		else if(data.equals("9888 22 556 6 ^ %"))
		{
			if(exptext6.equals(acttext))
			{
				return 1;
			}
			else 
			{
				return 0;
			}
		}
		else if(data.equals("aa     hh"))
		{
			if(exptext1.equals(acttext))
			{
				return 1;
			}
			else 
			{
				return 0;
			}
		}
		else
		{
			return -1;
		}
	
	}
	
	
	
	public boolean promptbutton_givinginput_presscancel(String prompt) throws InterruptedException
	{
		promptButton.click();  								Thread.sleep(1500);
		driver.switchTo().alert().sendKeys(prompt);
		driver.switchTo().alert().dismiss();
		String exptext = "User cancelled the prompt.";
		String acttext = textlocation.getText();
		if(exptext.equals(acttext))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean promptbehaviour_whitespaces() throws InterruptedException
	{
		promptButton.click();  					Thread.sleep(1500);
		driver.switchTo().alert().sendKeys("     ");
		driver.switchTo().alert().accept();
		String exptext = "Hello      ! How are you today?";
		String acttext = textlocation.getText();
		if(exptext.equals(acttext))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String captureScreenshot()
	{
		String image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return image;
	}


	public void scroll()
	{
		WebElement scrollingElement = driver.findElement(By.xpath("//body/div[@class='content']/div[@class='content-outer']/div[@class='fauxborder-left content-fauxborder-left']/div[@class='content-inner']/div[@class='main-outer']/div[@class='fauxborder-left main-fauxborder-left']/div[@class='region-inner main-inner']/div[@class='columns fauxcolumns']/div[@class='columns-inner']/div[@class='column-right-outer']/div[@class='column-right-inner']/aside/div[@class='sidebar section']/div[3]"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", scrollingElement);
	}

	public void scrolling()
	{
		WebElement scrollingElement = driver.findElement(By.xpath("//h2[normalize-space()='JS Alerts']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", scrollingElement);
	}	
}
