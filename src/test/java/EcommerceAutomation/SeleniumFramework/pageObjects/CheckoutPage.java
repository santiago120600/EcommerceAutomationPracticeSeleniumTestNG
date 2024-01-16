package EcommerceAutomation.SeleniumFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import EcommerceAutomation.SeleniumFramework.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	WebDriver driver;
	
	@FindBy(partialLinkText = "Place Order")
	WebElement placeOrderBtn;
	
	@FindBy(xpath = "//button[text()='Apply Coupon']")
	WebElement applyCouponBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Name on Card')]//following-sibling::input")
	WebElement nameOnCartInput;
	
	@FindBy(xpath = "//div[contains(text(),'CVV Code')]//following-sibling::input")
	WebElement cvvCodeInput;
	
	@FindBy(xpath = "//div[contains(text(),'Apply Coupon')]//following-sibling::input")
	WebElement applyCouponInput;
	
	@FindBy(xpath = "//select[@class='input ddl'][2]")
	WebElement epiricyDateDay;
	
	@FindBy(xpath = "//select[@class='input ddl'][1]")
	WebElement epiricyDateMonth;
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countrySelect;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void placeOrder() {
		Select epiricyDateDaySelect = new Select(epiricyDateMonth);
		Select epiricyDateMonthSelect = new Select(epiricyDateDay);
		epiricyDateDaySelect.selectByVisibleText("02");
		epiricyDateMonthSelect.selectByVisibleText("06");
		cvvCodeInput.sendKeys("213");
		nameOnCartInput.sendKeys("santiago castanon");
//		placeOrderBtn.click();
	}
	
	
}
