package EcommerceAutomation.SeleniumFramework.AbstractComponents;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartBtn;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	public void clickCart() {
		cartBtn.click();
	}

	public void waitForElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitToBeInvisible(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForElementBy(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void highlightElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public void takeElementScreenShot(WebElement element){
		try {
			File src = element.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("src/main/resources/" + src.getName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
