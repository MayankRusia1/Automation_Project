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

public class Drag_drop 
{
	public WebDriver driver;
	
	public Drag_drop(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//div[@class='column-right-outer']//div[5]")
	public WebElement drag_drop;
	
	@FindBy(xpath = "//div[@id='draggable']")
	public WebElement draggable;

	@FindBy(xpath = "//div[@id='droppable']")
	public WebElement droppable;

	


	//implementation methods
	public boolean crossBrowserTesting()
	{
		return drag_drop.isDisplayed();
	}

	
	public boolean droppableElement(String data)
	{
		String exptext = data;
		String acttext = droppable.getText();
		if(exptext.equals(acttext))
		{
			return true;
		}
		else 
		{	
			return false;
		}
	}
	
		
	public boolean draggableElement(String data)
	{
		String exptext = data;
		String acttext = draggable.getText();
		if(exptext.equals(acttext))
		{
			return true;
		}
		else 
		{	
			return false;
		}
	}
	
	
	public boolean properties_draggableElement()
	{
		String act = draggable.getCssValue("outline-color");
		String exp = "rgb(51, 51, 51)";
		if(act.equals(exp))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public boolean properties_droppableElement()
	{
		String act = droppable.getCssValue("outline-color");
		String exp = "rgb(51, 51, 51)";
		if(act.equals(exp))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public boolean behaviourOfDrag_drop()
	{
		Actions actions = new Actions(driver);
		WebElement drag = draggable;
		WebElement drop = droppable;
		
		Point beforedragelement = drag.getLocation();

		//drag element
		actions.dragAndDropBy(drag, 25, 50).build().perform();
		actions.dragAndDropBy(drag, -25, 80).build().perform();
		actions.dragAndDropBy(drag, 75, 100).build().perform();
		actions.dragAndDropBy(drag, 152, -50).build().perform();
		actions.dragAndDropBy(drag, 140, 80).build().perform();

		Point afterdragelement = drag.getLocation();

		Point beforedropwindow = drop.getLocation();


		//drop window
		actions.dragAndDropBy(drop, 50, 80).build().perform();
		actions.dragAndDropBy(drop, -50, 280).build().perform();
		actions.dragAndDropBy(drop, -100, 140).build().perform();
		actions.dragAndDropBy(drop, 88, 20).build().perform();

		Point afterdropwindow = drop.getLocation();

		if(beforedropwindow.equals(afterdropwindow) && !beforedragelement.equals(afterdragelement))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	
	
	public boolean working_drag_drop()
	{
		WebElement drag = draggable;
		WebElement drop = droppable;
		
		//before dropping
		String expbeforedrop = "Drop here";
		String actbeforedrop = drop.getText();

		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).build().perform();

		//after drop
		String expafterdrop = "Dropped!";
		String actafterdrop = drop.getText();

		if(actbeforedrop.equals(expbeforedrop) && actafterdrop.equals(expafterdrop))
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
		WebElement scrollingElement = driver.findElement(By.xpath("//h2[normalize-space()='Drag and Drop']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", scrollingElement);
	}
}
