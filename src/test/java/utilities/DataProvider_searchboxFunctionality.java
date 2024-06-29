package utilities;

import org.testng.annotations.DataProvider;

public class DataProvider_searchboxFunctionality 
{
	@DataProvider(name = "sb_006")
	public Object[] getdata1()
	{
		Object [] data = {"2365411","!!!!$%#"};
		return data;
	}
	
}
