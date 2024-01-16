package EcommerceAutomation.SeleniumFramework.TestComponents;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Failure of test cases and its details are : " + result.getName()+result.getThrowable());
	}

}
