package EcommerceAutomation.SeleniumFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceAutomation.SeleniumFramework.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent{
	
	WebDriver driver;
	
	@FindBy(id="userEmail")
	WebElement emailInput;
	
	@FindBy(id="userPassword")
	WebElement passwordInput;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(linkText = "Register here")
	WebElement registerLink;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void doLogin(String email, String password) {
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginBtn.click();
	}
	
	public void clickRegisterLink() {
		registerLink.click();
	}

}
