package AutomationExercise.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
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
	ThreadLocal<ExtentTest> currentTest= new ThreadLocal<ExtentTest>();
	public  void onTestStart(ITestResult result) {
	    
	
    extentTest=	extentReport.createTest(result.getMethod().getMethodName());
    currentTest.set(extentTest);
	  }

	 
	  public  void onTestSuccess(ITestResult result) {
		 currentTest.get().log(Status.PASS, "Test passed");
	  }

	 
	  public  void onTestFailure(ITestResult result) {
		  currentTest.get().fail(result.getThrowable());
		  currentTest.get().fail(result.getThrowable().getMessage());
		  String screenshotPath=null;
			try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			screenshotPath = TakeScreenshot(result.getMethod().getMethodName(), driver);
			currentTest.get().addScreenCaptureFromPath(screenshotPath);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }

	 
	  public  void onTestSkipped(ITestResult result) {
	   
	  }

	  
	  public  void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    
	  }

	 
	  public  void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	 
	  public  void onStart(ITestContext context) {
		extentReport=	extentReporterNG.ExtentReport();
	  }

	  
	  public  void onFinish(ITestContext context) {
		  extentReport.flush();
	  }
	 
	
}
