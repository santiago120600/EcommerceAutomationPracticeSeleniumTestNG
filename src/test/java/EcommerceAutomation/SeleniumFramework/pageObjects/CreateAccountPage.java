package EcommerceAutomation.SeleniumFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import EcommerceAutomation.SeleniumFramework.AbstractComponents.AbstractComponent;

public class CreateAccountPage extends AbstractComponent{
	
	WebDriver driver;
	
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
	
	@FindBy(id = "toast-container")
	WebElement toastMsg;
	
	public CreateAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createNewAccount(String firstName, String lastName, String email, String phoneNumber, String occupationValue, String password) {
		fistNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		emailInput.sendKeys(email);
		phoneNumberInput.sendKeys(phoneNumber);
		Select occupationSelect = new Select(occupation);
		occupationSelect.selectByVisibleText(occupationValue);
		genderRadioBtn.click();
		passwordInput.sendKeys(password);
		confirmPasswordInput.sendKeys(password);
		eighteenYearOldCheckbox.click();
		registerBtn.click();
	}
	
	public String getToastMsg() {
		return toastMsg.getText();
	}

}
