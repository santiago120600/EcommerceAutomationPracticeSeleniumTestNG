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
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getThrowable());
    	test.log(Status.FAIL, result.getThrowable());
//    	try {
//			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		} catch (Exception e) {
//			throw new RuntimeException(e.getMessage());
//		} 
//    	String filePath = takeScreenShot(result.getMethod().getMethodName(), driver);
//    	test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
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
    	test.log(Status.PASS, "Test Passed");
    }		

}
