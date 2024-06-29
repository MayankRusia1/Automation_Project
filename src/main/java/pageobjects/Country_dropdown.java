package pageobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Country_dropdown 
{
	
	public WebDriver driver;
	
	public Country_dropdown(WebDriver ldriver)
	{
		driver	= ldriver;
		PageFactory.initElements(driver,this);
	}


	

	@FindBy(id = "country")
	public  WebElement countryDropDown;

	
	//implementation methods
	
	public boolean optionSelection()
	{
		Select select = new Select(countryDropDown);
		select.selectByVisibleText("India");

		//retrieving name of option selected & displayed on drop-down bar
		WebElement selectedoption =	select.getFirstSelectedOption();
		String actselectedtext = selectedoption.getText();

		String expselectedtext = "India";

		if(actselectedtext.equals(expselectedtext))
		{
			return true;
		}
		else
		{
			return false;
		}

	}
	
	public boolean sortedDropdownElement(ExtentTest tests)
	{
		Select select = new Select(countryDropDown);
		List<String> orglist = new ArrayList<String>();

		List<WebElement> optionsElements = select.getOptions();

		//adding drop-down options
		for(WebElement e : optionsElements)
		{
			orglist.add(e.getText());
		}
		//		System.out.println("Original list: "+orglist);
		
		tests.info("Original Country drop-down elements");
		tests.info(MarkupHelper.createUnorderedList(orglist));

		List<String> templist = new ArrayList<String>();
		List<WebElement> options1 = select.getOptions();

		//adding drop-down options
		for(WebElement e1 : options1)
		{
			templist.add(e1.getText());
		}


		//sorting
		Collections.sort(templist);

		//	System.out.println("List after sort: "+templist);
		tests.info("Required/Sorted Country drop-down elements");
		tests.info(MarkupHelper.createUnorderedList(templist));

		
		if(orglist == templist)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public boolean waysOfSelectingElement(String a) 
	{
		Select select = new Select(countryDropDown);

		if(a.equalsIgnoreCase("visible text"))
		{
			select.selectByVisibleText("India");
			String expc1 = "india";
			String actc1 = countryDropDown.getAttribute("value");
			if(expc1.equals(actc1))
			{
				return true;
			}
			else
			{
				return false;
			}
		}


		else if(a.equalsIgnoreCase("index"))
		{		
			select.selectByIndex(2);
			String expc2 = "uk";
			String actc2 = countryDropDown.getAttribute("value");
			if(expc2.equals(actc2))
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		else if(a.equalsIgnoreCase("value"))
		{
			select.selectByValue("france");
			String expc3 = "france";
			String actc3 = countryDropDown.getAttribute("value");
			if(expc3.equals(actc3))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}

	
	public boolean directJumpingOnOptions(ExtentTest test) throws InterruptedException
	{
		countryDropDown.click();									Thread.sleep(1500);
		test.info("Country drop-down is clicked");
		countryDropDown.sendKeys("A");							Thread.sleep(1500);
		test.info("'A' is pressed , using keyboard keys ");		
		countryDropDown.sendKeys(Keys.ENTER);						Thread.sleep(1500);		
		test.info("ENTER button is pressed");
		
		String expc1 = "australia";
		String actc1 = countryDropDown.getAttribute("value");

		if(expc1.equals(actc1))
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
		WebElement scrolling = driver.findElement(By.xpath("//label[normalize-space()='Country:']"));
		JavascriptExecutor sc = (JavascriptExecutor) driver;
		sc.executeScript("arguments[0].scrollIntoView();",scrolling);
	}	
}