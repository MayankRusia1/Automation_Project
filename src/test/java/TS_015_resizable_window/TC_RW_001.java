package TS_015_resizable_window;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.ResizingWindow;

public class TC_RW_001
{
	WebDriver driver;


@Parameters("browser")
@BeforeTest
public void setup(@Optional("chrome") String browsername)
{
	if(browsername.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Chrome browser");
	}
	if(browsername.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		System.out.println("Edge browser");
	}

	if(browsername.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		System.out.println("Firefox browser");
	}
	driver.manage().window().maximize();
	driver.get("https://testautomationpractice.blogspot.com/");
}


@Test(description = "Cross browser testing")
public void RW_001()
{
	ResizingWindow	baseClass = new ResizingWindow(driver);
	baseClass.scroll();
	baseClass.crossBrowser();
}

@AfterTest
public void teardown() throws InterruptedException
{
	Thread.sleep(1500);
	driver.close();
}


}
