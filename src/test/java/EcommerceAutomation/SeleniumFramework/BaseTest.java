package EcommerceAutomation.SeleniumFramework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;

	public BaseTest() {
		super();
	}

	@BeforeTest
	public void before() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
	}

	@AfterMethod
	public void afterMethod() throws IOException {
		takeScreenShot();
	}
	
	public void takeScreenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("src/main/resources/"+src.getName()));
	}

	@AfterTest
	public void after() {
		driver.quit();
	}

}
