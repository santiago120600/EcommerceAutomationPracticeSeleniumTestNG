package EcommerceAutomation.SeleniumFramework.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommerceAutomation.SeleniumFramework.AbstractComponents.AbstractComponent;


public class ShopLanding extends AbstractComponent{
	WebDriver driver;
	
	@FindBy(css = "#toast-container")
	WebElement toastMsg;
	
	@FindBy(css = "ngx-spinner")
	WebElement loadSpinner;
	
	@FindBy(css = ".card")
	List<WebElement> products;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartBtn;
	
	By productsBy = By.cssSelector(".mb-3");
	
	public ShopLanding(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//add product by name -- use dataprovider
	public void addProductToCart(String productName){
		WebElement product = getProductByName(productName);
		WebElement btn = product.findElement(By.xpath(".//button[contains(text(),'Add To Cart')]"));
		btn.click();
		waitForElement(toastMsg);
		waitToBeInvisible(loadSpinner);
	}
	
	public List<WebElement> getProducts() {
		waitForElementBy(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		return getProducts().stream().filter(prod -> prod.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	}

}
