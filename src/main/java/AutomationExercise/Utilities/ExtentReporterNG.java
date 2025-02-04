package AutomationExercise.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {

	
	public ExtentReports ExtentReport()
	{
		
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\test-output\\TestReport.html");
		extentSparkReporter.config().setReportName("Test Report");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setDocumentTitle("Test Automation Exercise");
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(extentSparkReporter);
		extentReport.setSystemInfo("Tester", "Teja");
		return extentReport;
	}	
	
	
	
	
}
