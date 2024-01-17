package EcommerceAutomation.SeleniumFramework.resources;

import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public static ExtentReports getReportObj() {
		try {
			FileInputStream fis;
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\EcommerceAutomation\\SeleniumFramework\\resources\\Report.properties");
			Properties prop = new Properties(); 
			prop.load(fis);
			String path = System.getProperty("user.dir")+prop.getProperty("reportPath");
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName(prop.getProperty("reportName"));
			reporter.config().setDocumentTitle(prop.getProperty("reportTile"));
			ExtentReports extent  = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Environment", prop.getProperty("system.info.environment"));
			return extent;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
