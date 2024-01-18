package EcommerceAutomation.SeleniumFramework.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;

	public BaseTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void before(ITestContext context) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\EcommerceAutomation\\SeleniumFramework\\resources\\GlobalData.properties");
			prop.load(fis);
			String browserName = prop.getProperty("browser");
			switch (browserName.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				this.driver = new ChromeDriver();				
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				this.driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				this.driver = new EdgeDriver();
				break;
			default:
				throw new IllegalArgumentException("Unsupported browser: " + browserName);
			}
	        context.setAttribute("driver", this.driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	@AfterMethod(alwaysRun = true)
	public void after() {
		driver.quit();
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String fileName){
		try {			
			String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\EcommerceAutomation\\SeleniumFramework\\data\\"+fileName), StandardCharsets.UTF_8);
			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String takeScreenShot(String testName, WebDriver driver){
		String path = "";
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			path = System.getProperty("user.dir")+"\\reports\\"+testName+"_"+System.currentTimeMillis()+".png";
			FileUtils.copyFile(src, new File(path));
			
		} catch (Exception e) {
			throw new RuntimeException("Failed to capture screenshot. Error: " + e.getMessage());
		}
		return path;
	}

}
