package AutomationExercise.TestComponents;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import AutomationExercise.Utilities.ExtentReporterNG;

public class Listeners extends BaseTestClass implements ITestListener{
	ExtentReporterNG extentReporterNG= new ExtentReporterNG();;
	ExtentReports extentReport;
	ExtentTest extentTest;
	public  void onTestStart(ITestResult result) {
	    
	extentReport=	extentReporterNG.ExtentReport();
    extentTest=	extentReport.createTest(result.getMethod().getMethodName());
	
	  }

	 
	  public  void onTestSuccess(ITestResult result) {
		 extentTest.log(Status.PASS, "Test passed");
	  }

	 
	  public  void onTestFailure(ITestResult result) {
		  extentTest.fail(result.getThrowable());
	  }

	 
	  public  void onTestSkipped(ITestResult result) {
	   
	  }

	  
	  public  void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    
	  }

	 
	  public  void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	 
	  public  void onStart(ITestContext context) {
	    
	  }

	  
	  public  void onFinish(ITestContext context) {
		  extentReport.flush();
	  }
	 
	
}
