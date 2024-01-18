package EcommerceAutomation.SeleniumFramework.TestComponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import EcommerceAutomation.SeleniumFramework.resources.ExtentReporterNG;

public class Listener extends BaseTest implements ITestListener {
	ExtentReports extent = ExtentReporterNG.getReportObj();
	ExtentTest test;
	WebDriver driver;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
        ITestContext context = result.getTestContext();
    	driver = (WebDriver)context.getAttribute("driver");
    	String filePath = takeScreenShot(result.getMethod().getMethodName(), driver);
    	extentTest.get().addScreenCaptureFromPath(filePath);
	}
	
	@Override		
    public void onFinish(ITestContext result) {					
		extent.flush();
    }		

    @Override		
    public void onStart(ITestContext result) {					
        // TODO Auto-generated method stub				
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
        // TODO Auto-generated method stub				
    }		

		
    @Override		
    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub				
    }		
	

    @Override		
    public void onTestSuccess(ITestResult result) {					
    	extentTest.get().log(Status.PASS, "Test Passed");
    }		

}
