package pageobjects;

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

import com.aventstack.extentreports.ExtentTest;

public class Footer 
{
	public WebDriver driver;
	
	public Footer(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//div[@class='widget Attribution']//div[@class='widget-content']")
	WebElement bottom;
	
	@FindBy(linkText  = "merrymoonmary")
	WebElement merryMoonLink;

	@FindBy(linkText  = "Blogger")
	WebElement blogger;

	@FindBy(xpath = "//div[contains(@class,'widget Attribution')]//div[contains(@class,'widget-content')]")
	WebElement textElement;

	@FindBy(xpath = "//div[@class='widget Attribution']//div[@class='widget-content']")
	WebElement content;
	

	
	//implementation methods
	public boolean footerSectionDisplayed()
	{
		return (bottom).isDisplayed();
	}


	public void merrymoonmaryHyperlink(ExtentTest test)
	{
		WebElement links = (merryMoonLink);
		int count = 0;

		if (links.getTagName().equals("a")) 
		{
			links.click();

			Set<String> options = driver.getWindowHandles();

			for(String eString : options)
			{
				count++;
				String title = driver.switchTo().window(eString).getTitle();		
				if(title.contains("Automation Testing Practice"))
				{					
					test.info("1st browser window ID: "+eString);
					test.info("1st Page title: "+title);
					test.info("1st page URL: "+driver.getCurrentUrl());
					test.addScreenCaptureFromBase64String(capturescreenshot(),"1st browsing window");
				}

				if(title.contains("merrymoonmary Stock Image and Video Portfolio - iStock"))
				{
					test.info("2nd browser window ID: "+eString);
					test.info("2nd Page title: "+title);
					test.info("2nd page URL: "+driver.getCurrentUrl());
					test.addScreenCaptureFromBase64String(capturescreenshot(),"2nd browsing window");
				}
			}
		} 
		else 
		{
			test.info("The element is not a hyperlink.");
		}

		if(count == 2)
		{
			test.pass("merrymoonmary Stock Image and Video Portfolio - iStock, opened in a new browsing window");
		}
		else
		{
			test.fail("merrymoonmary Stock Image and Video Portfolio - iStock, opened in Same browsing window");
		}
	}


	public void bloggerHyperlink(ExtentTest test)
	{		
	WebElement blog = (blogger);
	String tagname = blog.getTagName();
	int count=0;
	if(tagname.contains("a"))
	{
		blog.click();

		Set<String> options = driver.getWindowHandles();

		for(String eString : options)
		{
			count++;
			String title = driver.switchTo().window(eString).getTitle();

			if(title.contains("Automation Testing Practice"))
			{
				test.info("1st browser window ID: "+eString);
				test.info("1st Page title: "+title);
				test.info("1st page URL: "+driver.getCurrentUrl());
				test.addScreenCaptureFromBase64String(capturescreenshot(),"1st browsing window");
			}
			if(title.contains("Blogger.com - Create a unique and beautiful blog easily."))
			{
				test.info("2nd browser window ID: "+eString);
				test.info("2nd Page title: "+title);
				test.info("2nd page URL: "+driver.getCurrentUrl());
				test.addScreenCaptureFromBase64String(capturescreenshot(),"2nd browsing window");
			}
		}
	} 
	else 
	{
		test.info("The element is not a hyperlink.");
	}

	if(count == 2)
	{
		test.pass("Blogger.com - Create a unique and beautiful blog easily., opened in a new browsing window");
	}
	else
	{
		test.fail("Blogger.com - Create a unique and beautiful blog easily., opened in Same browsing window");
	}		
	}


	public void behaviourOfHyperlinks(ExtentTest test)
	{
		WebElement blog = (blogger);
		WebElement links = (merryMoonLink);
		WebElement text = (textElement);

		String bloggercolor = blog.getCssValue("color"); 		
		String linkscolor = links.getCssValue("color");		
		String textcolor =	text.getCssValue("color");  

		if(bloggercolor.equals("rgba(38, 78, 170, 1)") && linkscolor.equals("rgba(38, 78, 170, 1)") && textcolor.equals("rgba(33, 37, 41, 1)"))
		{
			test.pass("Hyperlink & rest of the text are displayed with different color code, hyperlink is highlighted");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Footer section hyperlinks");
		}
		else 
		{
			test.fail("Hyperlink & rest of the text are displayed with same color code, hyperlink is NOT highighted");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Hyperlinks");
		}
	}

	

	public void footerContent(ExtentTest test)
	{
		String exptext = "Simple theme. Theme images by merrymoonmary. Powered by Blogger.";
		String acttext = (content).getText();		
		WebElement blogger = driver.findElement(By.linkText("Blogger"));
		WebElement merrymoon = driver.findElement(By.linkText("merrymoonmary"));

		if(blogger.getTagName().contains("a"))
		{
			test.pass("'Blogger' is a hyperlink");
		}
		else 
		{
			test.fail("'Blogger' is NOT a hyperlink");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Blogger");
		}

		if(merrymoon.getTagName().contains("a"))
		{
			test.pass("'merrymoonmary' is a hyperlink");
		}
		else 
		{
			test.fail("'merrymoonmary' is NOT a hyperlink");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"merrymoonmary");
		}

		if(exptext.equals(acttext))
		{
			test.pass("Correct text is displayed");
		}
		else 
		{
			test.fail("Wrong text is displayed");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"Text");
		}
	}



	
	

	public String capturescreenshot()
	{
		String image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return image;
	}


	public void scroll()
	{
		WebElement scrolling = driver.findElement(By.xpath("//div[@class='widget Attribution']//div[@class='widget-content']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();",scrolling);
	}
	
}
