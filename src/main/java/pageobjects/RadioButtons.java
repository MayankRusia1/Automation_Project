package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.*;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

public class RadioButtons 
{
	public WebDriver driver;
	
	public RadioButtons(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="male")
	public  WebElement male;
	
	@FindBy(id="female")
	public WebElement female;
	
	@FindBy(xpath ="//label[normalize-space()='Male']")
	public WebElement maletext;
	
	@FindBy(xpath ="//label[normalize-space()='Female']")
	public WebElement femaletext;
	
	
	

	//implementation methods
public WebElement maleElement()
{
	return male;
}
	
public WebElement femaleElement()
{
	return female;
}

public WebElement maleText()
{
	return maletext;
}

public WebElement femaleText()
{
	return femaletext;
}



	public void crossBrowserTesting()
	{
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(maleElement().isDisplayed(),"Male radio button not loaded successfully");
		softAssert.assertTrue(femaleElement().isDisplayed(),"Female radio button not loaded successfully");
		softAssert.assertAll();
	}
	
	public void Validations(ExtentTest test)
	{
		if(maleElement().isDisplayed() && maleElement().isEnabled())
		{
			test.pass("Male radio button is displayed & enabled");
		}
		else 
		{
			test.fail("Male radio button is NOT displayed & it is disabled");
			test.addScreenCaptureFromBase64String(captureScreenshot(),"Male radio button");
		}
		
		if(femaleElement().isDisplayed() && femaleElement().isEnabled())
		{
			test.pass("Female radio button is displayed & enabled");			
		}
		else 
		{
			test.fail("Female radio button is NOT displayed & it is disabled");
			test.addScreenCaptureFromBase64String(captureScreenshot(),"Female radio button");			
		}
	}
	
	public void RadioButtonFunctionality(ExtentTest test)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		maleElement().click();
		if(maleElement().isSelected() && !femaleElement().isSelected())
		{
			test.pass("Male radio button is Selected & female radio button is unselected");
		}
		else 
		{
			test.fail("Male radio button is NOT working as per requirement");
			test.addScreenCaptureFromBase64String(captureScreenshot(),"Male radio button");
		}
	}
	
	
	public void maleTextClick(ExtentTest test)
	{
		maleText().click();
		if(maleElement().isSelected())
		{
			test.pass("Male radio button is Selected"); 
		}
		else 
		{
			test.fail("Male radio button is NOT working as per requirement");
			test.addScreenCaptureFromBase64String(captureScreenshot(),"Male radio button");
		}
	}
	
	
	public void maleButtonClick(ExtentTest test)
	{
		maleElement().click();
		if(maleElement().isSelected())
		{
			test.pass("Male radio button is Selected"); 
		}
		else 
		{
			test.fail("Male radio button is NOT working as per requirement");
			test.addScreenCaptureFromBase64String(captureScreenshot(),"Male radio button");
		}
	}
	

	
	
	public void femaleTextClick(ExtentTest test)
	{
		femaleText().click();
		if(femaleElement().isSelected())
		{
			test.pass("Female radio button is Selected"); 
		}
		else 
		{
			test.fail("Female radio button is NOT working as per requirement");
			test.addScreenCaptureFromBase64String(captureScreenshot(),"Female radio button");
		}
	}
	
	
	public void femaleButtonClick(ExtentTest test)
	{
		femaleElement().click();
		if(femaleElement().isSelected())
		{
			test.pass("Female radio button is Selected"); 
		}
		else 
		{
			test.fail("Female radio button is NOT working as per requirement");
			test.addScreenCaptureFromBase64String(captureScreenshot(),"Female radio button");
		}
	}

	
	public void UIOfRadioButtons(ExtentTest test)
	{
		String expmaletext = "Male";
		String actmaletext = maleText().getText();
		String expfemaletext = "Female";
		String actfemaletext = femaleText().getText();

		if(expmaletext.equals(actmaletext))
		{
			test.pass("Male text is correctly spelled");
		}
		else
		{
			test.fail("Male text is Wrong spelled");
			test.addScreenCaptureFromBase64String(captureScreenshot(),"Male radio button");
		}

		if(expfemaletext.equals(actfemaletext))
		{
			test.pass("Female text is correctly spelled");			
		}
		else 
		{
			test.fail("Female text is Wrong spelled");
			test.addScreenCaptureFromBase64String(captureScreenshot(),"Female radio button");			
		}
	}
	
	
	
	public String captureScreenshot()
	{
		String image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return image;
	}
	public void scroll()
	{
		WebElement scrolling = driver.findElement(By.xpath("//label[normalize-space()='Gender:']"));
		JavascriptExecutor jExecutor = (JavascriptExecutor) driver;
		jExecutor.executeScript("arguments[0].scrollIntoView();", scrolling);

	}

	
	
	
}
