package utilities;

import org.testng.annotations.DataProvider;

public class DataProvider_alertBoxes 
{
	@DataProvider(name = "ab_007")
	public Object [] getdata()
	{
		Object []data = {
				"Hello","8473968586","jjffj  ##@@ (&&)",
				"jjjaiiiia","9888 22 556 6 ^ %","aa     jh" 
				};
		return data;
	}
}
