package EcommerceAutomation.SeleniumFramework;

import org.testng.annotations.Test;

import EcommerceAutomation.SeleniumFramework.pageObjects.LoginPage;
import EcommerceAutomation.SeleniumFramework.pageObjects.ShopLanding;

public class TestClass extends BaseTest{
	@Test
	public void testLogin(){
		LoginPage login = new LoginPage(driver);
		login.doLogin();
		ShopLanding landing = new ShopLanding(driver);
		landing.addProductToCart("IPHONE 13 PRO");
	}
}
