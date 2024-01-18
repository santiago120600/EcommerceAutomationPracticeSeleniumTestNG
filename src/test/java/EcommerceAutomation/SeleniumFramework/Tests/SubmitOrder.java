package EcommerceAutomation.SeleniumFramework.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import EcommerceAutomation.SeleniumFramework.TestComponents.BaseTest;
import EcommerceAutomation.SeleniumFramework.TestComponents.Retry;
import EcommerceAutomation.SeleniumFramework.pageObjects.CartPage;
import EcommerceAutomation.SeleniumFramework.pageObjects.CheckoutPage;
import EcommerceAutomation.SeleniumFramework.pageObjects.LoginPage;
import EcommerceAutomation.SeleniumFramework.pageObjects.ShopLandingPage;

public class SubmitOrder extends BaseTest{
	@Test(priority = 1, dataProvider = "getData", retryAnalyzer = Retry.class)
	public void submitOrderTest(String email, String password, String productName){
		LoginPage login = new LoginPage(driver);
		login.doLogin(email,password);
		ShopLandingPage landing = new ShopLandingPage(driver);
		landing.addProductToCart(productName);
		CartPage cartPage = new CartPage(driver);
		cartPage.clickCart();
		cartPage.clickCheckout();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.placeOrder();
	}
	
	@Test
	@Parameters({"email","password","productName"})
	public void submitOrderTest2(String email, String password, String productName){
		LoginPage login = new LoginPage(driver);
		login.doLogin(email,password);
		ShopLandingPage landing = new ShopLandingPage(driver);
		landing.addProductToCart(productName);
		CartPage cartPage = new CartPage(driver);
		cartPage.clickCart();
		cartPage.clickCheckout();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.placeOrder();
	}
	
	@DataProvider
	public Object[] getData() {
		return new Object[][] {{"santiagocastanonarvizu@gmail.com","sAn123@0","IPHONE 13 PRO"},{"santiagocastanonarvizu@gmail.com","sAn123@0","ZARA COAT 3"}};
	}
	
}
