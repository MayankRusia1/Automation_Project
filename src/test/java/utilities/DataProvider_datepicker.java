package utilities;

import org.testng.annotations.DataProvider;

public class DataProvider_datepicker 
{


	@DataProvider(name = "date_Combinations")
	public Object[] getdata()
	{
		Object [] data = {
				"05/11/2023","12/05/2055","8-22-2023",
				"3*15*2022","31/5/1997","15,dec 1997",
				"1997/6/11","23,may 23"
		};
		return data;
	}
	
	
	
	@DataProvider(name = "date_accepting_different_data")
	public Object[] getdata1()
	{
		Object [] data = {
				"fkjbdkfj","32423/*-*/dfdf","df    _4548937-**",
				"6464**54","5465/*-+dfds$#@","third december, two thousand twenty three",
				"5/15/1997","36*15*twenty three","213/8978/654/2131"
		};
		return data;
	}
	
}
