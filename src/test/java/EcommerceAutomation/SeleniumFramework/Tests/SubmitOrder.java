package EcommerceAutomation.SeleniumFramework.Tests;

import org.testng.annotations.Test;

import EcommerceAutomation.SeleniumFramework.TestComponents.BaseTest;
import EcommerceAutomation.SeleniumFramework.pageObjects.CartPage;
import EcommerceAutomation.SeleniumFramework.pageObjects.CheckoutPage;
import EcommerceAutomation.SeleniumFramework.pageObjects.CreateAccountPage;
import EcommerceAutomation.SeleniumFramework.pageObjects.LoginPage;
import EcommerceAutomation.SeleniumFramework.pageObjects.ShopLandingPage;

public class SubmitOrder extends BaseTest{
	@Test(priority = 1)
	public void submitOrderTest(){
		LoginPage login = new LoginPage(driver);
		login.doLogin("santiagocastanonarvizu@gmail.com","sAn123@0");
		ShopLandingPage landing = new ShopLandingPage(driver);
		landing.addProductToCart("IPHONE 13 PRO");
		CartPage cartPage = new CartPage(driver);
		cartPage.clickCart();
		cartPage.clickCheckout();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.placeOrder();
	}
	
	@Test(priority = 2)
	public void loginFail(){
		LoginPage login = new LoginPage(driver);
		login.doLogin("santiagocastanonarvizu@gmail.com","sAn123@000");
	}
	
	
}
