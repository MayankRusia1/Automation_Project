package pageobjects;

import java.time.Duration;
import java.util.Arrays;
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

public class PaginationTable 
{
	public WebDriver driver;

	public PaginationTable(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}

	//locators for webElement
	public 	By paginationTable = By.xpath("//body/div[@class='content']/div[@class='content-outer']/div[@class='fauxborder-left content-fauxborder-left']/div[@class='content-inner']/div[@class='main-outer']/div[@class='fauxborder-left main-fauxborder-left']/div[@class='region-inner main-inner']/div[@class='columns fauxcolumns']/div[@class='columns-inner']/div[@class='column-center-outer']/div[@class='column-center-inner']/div[@name='Main']/div[3]");
	public 	By checkbox = By.xpath("//tbody/tr[2]/td[4]/input[1]");


	//implementation methods
	public WebElement paginationTableElement()
	{
		return driver.findElement(paginationTable);
	}

	public WebElement checkboxSelection()
	{
		return driver.findElement(checkbox);
	}

	public List<WebElement> paginationNumbers()
	{
		List<WebElement> paginationnumber = driver.findElements(By.xpath("//ul[@id='pagination']/li"));
		return paginationnumber;
	}

	public List<WebElement> totalRows()
	{
		List<WebElement> rows =	driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
		return rows;
	}

	public WebElement heading()
	{
		WebElement headingdata = driver.findElement(By.xpath("//table[@id='productTable']/thead/tr"));
		return headingdata;
	}


	public void crossBrowser()
	{
		Assert.assertTrue(paginationTableElement().isDisplayed(), "Pagination table is NOT displayed");
	}


	public void rowSelection(ExtentTest test)
	{
		checkboxSelection().click();
		if(checkboxSelection().isSelected())
		{
			test.pass("2nd row checkbox is selected");
		}
		else 
		{
			test.fail("2nd row checkbox is NOT selected");
			test.addScreenCaptureFromBase64String(capturescreenshot());
		}
	}


	public void sortedData(ExtentTest test) throws InterruptedException
	{
		List<WebElement> paginationnumber = driver.findElements(By.xpath("//ul[@id='pagination']/li"));
		List<WebElement> rows =	driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

		int totalsize = (paginationnumber.size() * rows.size());
		int [] actdata = new int[totalsize];

		int count =0;

		for(int i=1; i<= paginationnumber.size(); i++)
		{
			driver.findElement(By.xpath("//ul[@id='pagination']/li["+i+"]")).click();
			Thread.sleep(1000);

			for(int j=1; j<= rows.size(); j++)
			{
				String result =	driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]/td[1]")).getText();
				actdata[count] = Integer.parseInt(result); 
				count++;
			}
		}


		//		System.out.println("********Before sort********");
		for(int i=0; i<totalsize; i++)
		{
			System.out.print(actdata[i]+" ");
		}
		System.out.println();

		Arrays.sort(actdata);

		int [] sortdata = new int[totalsize];
		for(int i=0; i<totalsize; i++)
		{
			sortdata[i] = actdata[i];
		}


		//		System.out.println("********After sort********");
		for(int i=0; i<totalsize; i++)
		{
			System.out.print(sortdata[i]+" ");
		}

		if(Arrays.equals(sortdata, actdata))
		{
			test.pass("Pagination table data is arranged in asceding order, according to its ID");
		}
		else
		{
			test.fail("Pagination table data is NOT arranged in ascending order, as per its ID");
			test.addScreenCaptureFromBase64String(capturescreenshot());
		}
	}


	public void navigateAnyPageUsingNumbers(ExtentTest test) throws InterruptedException
	{
		//			List<WebElement> paginationnumber = driver.findElements(By.xpath("//ul[@id='pagination']/li"));
		//			List<WebElement> rows =	driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

		String[] actdata = new String[totalRows().size()];
		int count = 0;

		String beforeclickcolor = driver.findElement(By.xpath("//a[normalize-space()='3']")).getCssValue("color");
		String beforeclickbgcolor = driver.findElement(By.xpath("//a[normalize-space()='3']")).getCssValue("background-color");;

		WebElement afterclick = driver.findElement(By.xpath("//a[normalize-space()='3']"));
		String afterclickcolor = null;
		String afterclickbgcolor = null;


		for(int i=1; i<= paginationNumbers().size(); i++)
		{
			if(i == 3)
			{
				driver.findElement(By.xpath("//ul[@id='pagination']/li["+i+"]")).click();
				Thread.sleep(1000);

				afterclickcolor = afterclick.getCssValue("color");
				afterclickbgcolor = afterclick.getCssValue("background-color");;

				for(int j=1; j<= totalRows().size(); j++)
				{
					String result =	driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+j+"]")).getText();
					actdata[count] = result; 
					count++;
				}
			}
		}


		String expdata[] = new String[totalRows().size()];
		expdata[0] = "11 Product 11 $20.99";
		expdata[1] = "12 Product 12 $24.99";
		expdata[2] = "13 Product 13 $30.99";
		expdata[3] = "14 Product 14 $19.99";
		expdata[4] = "15 Product 15 $2.99";


		System.out.println(beforeclickbgcolor);
		System.out.println(afterclickbgcolor);
		System.out.println(beforeclickcolor);
		System.out.println(afterclickcolor);

		for(int i=0; i< expdata.length; i++)
		{
			System.out.print(expdata[i]+" ");
		}


		for(int j=0; j< totalRows().size(); j++)
		{
			System.out.print(actdata[j]+" ");
		}
		if(!beforeclickbgcolor.equals(afterclickbgcolor) && !beforeclickcolor.equals(afterclickcolor) && Arrays.equals(expdata, actdata))
		{
			test.pass("User able to navigate to different pages of table & content is properly displayed");
		}
		else 
		{
			test.fail("User is NOT  able to navigate to different pages of table & content is NOT properly displayed");
			test.addScreenCaptureFromBase64String(capturescreenshot());
		}
	}




	public void headingDisplay(ExtentTest test)
	{
		String heading = null;
		//			List<WebElement> pagination = driver.findElements(By.xpath("//ul[@id='pagination']/li"));

		String expdata = "ID Name Price Select";

		System.out.println("*******Expected heading on each page*******");
		System.out.println(expdata);

		System.out.println("*******Actual heading on every page*******");
		for(int i=1; i<= paginationNumbers().size(); i++)
		{
			driver.findElement(By.xpath("//ul[@id='pagination']/li["+i+"]")).click();
			heading = heading().getText();
			System.out.println(heading);
		}

		if(expdata.equals(heading))
		{
			test.pass("Proper heading is displayed");
		}
		else 
		{
			test.fail("Proper heading is NOT displayed");
			test.addScreenCaptureFromBase64String(capturescreenshot());
		}
	}



	public void selectMultipleOptions(ExtentTest test) throws InterruptedException
	{
		boolean expresult1 = true;
		boolean expresult2 = true;
		boolean expresult3 = true;
		boolean expresult4 = true;

		boolean result1=false;
		boolean result2 =false;
		boolean result3 =false;
		boolean result4 = false;

		for(int i=1; i<= paginationNumbers().size(); i++)
		{
			driver.findElement(By.xpath("//ul[@id='pagination']/li["+i+"]")).click();
			Thread.sleep(1000);

			if(i==1)
			{
				driver.findElement(By.xpath("//tbody/tr[2]/td[4]/input[1]")).click();
				result1 = driver.findElement(By.xpath("//tbody/tr[2]/td[4]/input[1]")).isSelected();
				test.addScreenCaptureFromBase64String(capturescreenshot(),"1st page checkbox");
			}

			if(i==2)
			{
				driver.findElement(By.xpath("//tbody/tr[3]/td[4]/input[1]")).click();
				result2 = driver.findElement(By.xpath("//tbody/tr[3]/td[4]/input[1]")).isSelected();
				test.addScreenCaptureFromBase64String(capturescreenshot(),"2nd page checkbox");
			}

			if(i==3)
			{
				driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]")).click();
				result3 = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]")).isSelected();
				test.addScreenCaptureFromBase64String(capturescreenshot(),"3rd page checkbox");
			}

			if(i==4)
			{
				driver.findElement(By.xpath("//tbody/tr[4]/td[4]/input[1]")).click();
				result4 = driver.findElement(By.xpath("//tbody/tr[4]/td[4]/input[1]")).isSelected();			
				test.addScreenCaptureFromBase64String(capturescreenshot(),"4th page checkbox");
			}
		}

		if(result1 == expresult1 && result2 == expresult2 && result3 == expresult3 && result4 == expresult4)
		{
			test.pass("User is able to select all the different checkboxes on different pages");
		}
		else 
		{
			test.fail("User is unable to select all the different checkboxes on different pages");
			test.addScreenCaptureFromBase64String(capturescreenshot());
		}
	}



	public void validateStatus(ExtentTest test)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement firstpage = driver.findElement(By.xpath("//a[normalize-space()='1']"));
		firstpage.click();

		WebElement button1 = driver.findElement(By.xpath("//tbody/tr[2]/td[4]/input[1]"));
		button1.click();
		test.addScreenCaptureFromBase64String(capturescreenshot(),"1st page screenshot");
		boolean beforestatus = button1.isSelected();

		WebElement secondpage = driver.findElement(By.xpath("//a[normalize-space()='2']"));
		secondpage.click();

		WebElement button2 = driver.findElement(By.xpath("//tbody/tr[3]/td[4]/input[1]"));
		button2.click();
		test.addScreenCaptureFromBase64String(capturescreenshot(),"2nd page screenshot");

		firstpage.click();
		boolean afterstatus = driver.findElement(By.xpath("//tbody/tr[2]/td[4]/input[1]")).isSelected();
		test.addScreenCaptureFromBase64String(capturescreenshot(),"After coming back to page 1");

		if(beforestatus == afterstatus)
		{
			test.pass("Checkbox doesnot get unchecked, until page is refreshed or reloaded, when user navigate to different pages");
		}
		else 
		{
			test.fail("Checkbox get unchecked automatically, as user navigate to different pages");			
		}
	}






	public void scroll()
	{
		WebElement scrollingElement = driver.findElement(By.xpath("//h2[normalize-space()='Pagination Table']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", scrollingElement);
	}


	public String capturescreenshot()
	{
		String image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return image;
	}

}
