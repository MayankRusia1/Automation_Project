package utitilites;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter 
{	
	public static ExtentReports getExtentReport()
	{	
		ExtentSparkReporter sparkReporter =
				new ExtentSparkReporter(".//Reports//FS_005.html");			
		sparkReporter.config().setReportName("Slider functionality testing report");
		sparkReporter.config().setDocumentTitle("Test Execution Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Operating System","Windows 11");
		extent.setSystemInfo("Executed By","Mayank Rusia");
		
		return extent;
	}

}
