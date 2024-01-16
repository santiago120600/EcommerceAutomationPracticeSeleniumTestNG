package EcommerceAutomation.SeleniumFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount{
	
	WebDriver driver;
	
	@FindBy(linkText = "Register here")
	WebElement registerLink;
	
	@FindBy(id="firstName")
	WebElement fistNameInput;
	
	@FindBy(id="lastName")
	WebElement lastNameInput;
	
	@FindBy(id="userEmail")
	WebElement emailInput;
	
	@FindBy(id="userMobile")
	WebElement phoneNumberInput;
	
	@FindBy(xpath = "//label[text()='Occupation']/following-sibling::select")
	WebElement occupation;
	
	@FindBy(xpath = "(//input[@formcontrolname='gender'])[1]")
	WebElement genderRadioBtn;
	
	@FindBy(id="userPassword")
	WebElement passwordInput;
	
	@FindBy(id="confirmPassword")
	WebElement confirmPasswordInput;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement eighteenYearOldCheckbox; 
	
	@FindBy(id="login")
	WebElement registerBtn;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement loginBtn;

	public CreateAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createAccountTest() {
		registerLink.click();
		fistNameInput.sendKeys("santiago");
		lastNameInput.sendKeys("castanon");
		emailInput.sendKeys("santiagocastanonarvizu@gmail.com");
		phoneNumberInput.sendKeys("4426244708");
		Select occupationSelect = new Select(occupation);
		occupationSelect.selectByVisibleText("Engineer");
		genderRadioBtn.click();
		String password = "sAn123@0";
		passwordInput.sendKeys(password);
		confirmPasswordInput.sendKeys(password);
		eighteenYearOldCheckbox.click();
		registerBtn.click();
		//go to login
		loginBtn.click();
	}

}
