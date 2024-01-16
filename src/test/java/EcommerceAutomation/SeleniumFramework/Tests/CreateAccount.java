package EcommerceAutomation.SeleniumFramework.Tests;

import org.testng.annotations.Test;

import EcommerceAutomation.SeleniumFramework.TestComponents.BaseTest;
import EcommerceAutomation.SeleniumFramework.pageObjects.CreateAccountPage;
import EcommerceAutomation.SeleniumFramework.pageObjects.LoginPage;

public class CreateAccount extends BaseTest{
	//try to create account with already existing user
	//create new user
	//validate inputs
	// validate password[min lenght, 1 uppercase, 1 lowercase, 1 special chart ]
	@Test
	public void existingUser() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickRegisterLink();
		CreateAccountPage accountPage = new CreateAccountPage(driver);
//		accountPage.createNewAccount("santiago", "castanon", "santiagocastanonarvizu@gmail.com", "4426244708", "Engineer", "sAn123@0");
		accountPage.createNewAccount("santiago", "castanon", "santiagocastanonarvizu@gmail.com", "4426244708","Engineer", "sAn123@0");
	}
}
