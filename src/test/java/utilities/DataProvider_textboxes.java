package utilities;

import org.testng.annotations.DataProvider;

public class DataProvider_textboxes
{
	@DataProvider(name = "textbox_dataprovider")
	public Object[] getdata()
	{
		Object[] dataObjects = {"9826311979241","asdf652312",
								"#$%ghi","982^&*%   sfdgfd","6523   ghf$%^",
								"9 *  &hj  *98","ss    65"};
		return dataObjects;
	}
}