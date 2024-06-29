package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBox 
{
	public WebDriver driver;
	
	public TextBox(WebDriver driver) 
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="name")
	private WebElement txt_name;
	
	@FindBy(id="email")
	private WebElement txt_email;
	
	@FindBy(id="phone")
	private WebElement txt_phone;
	
	@FindBy(id="textarea")
	private WebElement txt_address;
	
	
	
	public void enterEmailAddress(String email) {
		
		txt_email.sendKeys(email);
		
	}
	
	public void enterPhoneNumber(String phone) {
		
		txt_phone.sendKeys(phone);
	}
	
	public void enterName(String name) {
		
		txt_name.sendKeys(name);
		
	}
	
	public void enterAddress(String address) {
		
		txt_address.sendKeys(address);
	}

	
	
	
	
	public boolean checkingName()
	{
		String actname = txt_name.getAttribute("value");
		String expname = "     jay     ";
		if(expname.equals(actname)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}


	public boolean checkingEmail()
	{
		String actemail = txt_email.getAttribute("value");
		String expemail = "invalid email address";
		if(expemail.equals(actemail)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	public boolean checkingPhone()
	{
		String actphone = txt_phone.getAttribute("value");
		String expphone = "invalid phone number";
		if(expphone.equals(actphone)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	public boolean checkingAddress()
	{
		String actaddress = txt_address.getAttribute("value");
		String expaddress = "453/s      sagar,         M.P";
		if(expaddress.equals(actaddress)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	
	public int datachecking_name()
	{
		String expname = "Aman Gupta";
		String actname = txt_name.getAttribute("value");
		if(expname.equals(actname))
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
	
	
	public int datachecking_email()
	{
		String expemail = "amangupta667@yahoo.com";
		String actemail = txt_email.getAttribute("value");
		if(expemail.equals(actemail))
		{
			return 1;
		}
		else 
		{
			return 0;
		}
		
	}

	public int datachecking_phone()
	{
		String expphone = "9826311979";
		String actphone = txt_phone.getAttribute("value");		
		if(expphone.equals(actphone))
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}

	public int datachecking_address()
	{
		String expaddress = "543/4 Saharangpur road, Nagpur, Maharashtra";
		String actaddress = txt_address.getAttribute("value");	
		if(expaddress.equals(actaddress))
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}

	
	
	
	public boolean placeholderName()
	{
		String actname = txt_name.getAttribute("value");
		String expname = "Enter name";
		if(expname.equals(actname)) 
		{
			return true;
		}
		else 
		{
			return false;
		}

	}
	

	public boolean placeholderEmail()
	{
		String actemail = txt_email.getAttribute("value");
		String expemail = "Enter Email address";
		if(expemail.equals(actemail)) 
		{
			return true;
		}
		else 
		{
			return false;
		}

	}

	public boolean placeholderPhone()
	{
		String actphone = txt_phone.getAttribute("value");
		String expphone = "Enter phone number";
		if(expphone.equals(actphone)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}

	public boolean placeholderAddress()
	{
		String actaddress = txt_address.getAttribute("value");
		String expaddress = "Enter Street address";
		if(expaddress.equals(actaddress)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}


	public boolean nameOptions()
	{
		String nameCss = txt_name.getCssValue("outline-color");
		String nameNameOption = txt_name.getAttribute("type");
		
		if(nameCss.equals("rgba(73, 80, 87, 1)") && nameNameOption.equals("text"))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	
	public boolean emailOptions()
	{
		String emailCss = txt_email.getCssValue("outline-color");
		String emailNameOption = txt_email.getAttribute("type");
		
		if(emailCss.equals("rgba(73, 80, 87, 1)") && emailNameOption.equals("text"))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	
	public boolean phoneOptions()
	{
		String phoneCss = txt_phone.getCssValue("outline-color");
		String phoneNameOption = txt_phone.getAttribute("type");
		
		if(phoneCss.equals("rgba(73, 80, 87, 1)") && phoneNameOption.equals("text"))
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}

	public boolean addressOptions()
	{
		String addressCss = txt_address.getCssValue("outline-color");
		String addressNameOption = txt_address.getAttribute("type");
		
		if(addressCss.equals("rgba(73, 80, 87, 1)") && addressNameOption.equals("textarea"))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	
	public int phoneNumber_Validation(String data)
	{
		WebElement phone = 	txt_phone;
		String beforephoneCss =	phone.getCssValue("outline-color");			
		phone.sendKeys(data);
		phone.sendKeys(Keys.TAB);
		String afterphoneCss = txt_phone.getCssValue("outline-color");
		String expwarning = "invalid input data";
		String actwarning = phone.getText();
		
		if(!beforephoneCss.equals(afterphoneCss) && expwarning.equals(actwarning))
		{
			return 1;
		}
		else
		{
			return -1;
		}
		
	}

	public void nameAction() 
	{
		txt_name.sendKeys(Keys.TAB);
	}

	public void emailAction()
	{
		txt_email.sendKeys(Keys.TAB);
	}
	
	public void phoneAction()
	{
		txt_phone.sendKeys(Keys.TAB);
	}
	
}
