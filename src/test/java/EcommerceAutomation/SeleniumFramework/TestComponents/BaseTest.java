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
	public void before() {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	public void takeScreenShot(){
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("src/main/resources/"+src.getName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void after() {
		takeScreenShot();
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

}
