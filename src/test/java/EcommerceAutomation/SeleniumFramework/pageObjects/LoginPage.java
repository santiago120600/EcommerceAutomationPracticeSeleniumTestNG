package EcommerceAutomation.SeleniumFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	WebDriver driver;
	
	@FindBy(id="userEmail")
	WebElement emailInput;
	
	@FindBy(id="userPassword")
	WebElement passwordInput;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void doLogin() {
		emailInput.sendKeys("santiagocastanonarvizu@gmail.com");
		String password = "sAn123@0";
		passwordInput.sendKeys(password);
		loginBtn.click();
	}

}
