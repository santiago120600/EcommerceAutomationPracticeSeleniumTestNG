package EcommerceAutomation.SeleniumFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceAutomation.SeleniumFramework.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkoutBtn;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCheckout() {
		waitForElement(checkoutBtn);
		checkoutBtn.click();
	}

}
