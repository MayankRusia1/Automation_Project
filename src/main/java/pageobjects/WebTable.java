package pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class WebTable 
{
	public WebDriver driver;
	
	public WebTable(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	
	//locators for webElement
	public 	By webtable = By.xpath("//table[@name='BookTable']");
	public By rows = By.xpath("//table[@name='BookTable']/tbody/tr");
	public By column = By.xpath("//table[@name='BookTable']/tbody/tr/th");


	//implementation methods

	public WebElement webtableElement()
	{
		return driver.findElement(webtable);
	}

	public List<WebElement> totalRows()
	{
		return driver.findElements(rows); 
	}

	public List<WebElement> totalColumns()
	{
		return driver.findElements(column);
	}




	public void crossBrowser()
	{
		Assert.assertTrue(webtableElement().isDisplayed(), "WebTable is NOT displayed on page");
	}

	public void sortedData(ExtentTest test)
	{
		//		System.out.println("Rows: "+rows.size());
		//		System.out.println("Columns: "+column.size());

		List<WebElement> beforesort = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/td[1]"));

		List<String> stringData = new ArrayList<String>();

		//add data in List
		for (WebElement element : beforesort) 
		{
			stringData.add(element.getText());
		}

		//convert List to String array
		String[] originalStringArray = stringData.toArray(new String[0]);

		//original table data
		for(int i=0; i< originalStringArray.length; i++)
		{
			System.out.println(originalStringArray[i]);
		}

		// Sort the list of strings
		Collections.sort(stringData);

		// Convert the sorted list to an array
		String[] sortedStringArray = stringData.toArray(new String[0]);

		for(int i=0; i< sortedStringArray.length; i++)
		{
			System.out.println(sortedStringArray[i]);
		}

		if(originalStringArray.equals(sortedStringArray))
		{
			test.pass("WebTable data is arranged in ascending order");
		}
		else 
		{
			test.fail("WebTable data is NOT arranged in ascending order");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"WebTable");
		}
	}

	
	public void headers(ExtentTest test)
	{
//		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th"));

		List<String> stringData = new ArrayList<String>();

		//add data in List
		for (WebElement element : totalRows()) 
		{
			stringData.add(element.getText());
		}

		//convert List to String array
		String[] originalStringArray = stringData.toArray(new String[0]);

		String [] expdata = {"BookName","Author","Subject","Price"};

		//comparing 2 arrays, using Arrays.equals() method
		if(Arrays.equals(expdata, originalStringArray))
		{
			test.pass("Heading of table is correctly displayed");
		}
		else 
		{
			test.fail("Heading of table is NOT correctly displayed");
			test.addScreenCaptureFromBase64String(capturescreenshot(),"WebTable headings");
		}
	}




	public String capturescreenshot()
	{
		String image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return image;
	}

	public void scroll()
	{
		WebElement scrolling = driver.findElement(By.xpath("//h2[normalize-space()='Web Table']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", scrolling);
	}
	
}
