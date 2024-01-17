package EcommerceAutomation.SeleniumFramework.Tests;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import EcommerceAutomation.SeleniumFramework.TestComponents.BaseTest;
import EcommerceAutomation.SeleniumFramework.pageObjects.CreateAccountPage;
import EcommerceAutomation.SeleniumFramework.pageObjects.LoginPage;

public class CreateAccount extends BaseTest {
	@Test(dataProvider = "newSuccessfullAccountData", priority = 1, enabled = false)
	public void createNewAccountSuccessfully(HashMap<String, String> input) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickRegisterLink();
		CreateAccountPage accountPage = new CreateAccountPage(driver);
		accountPage.createNewAccount(input.get("firstName"), input.get("lastName"), input.get("email"),
				input.get("phone"), input.get("occupation"), input.get("password"));
		Assert.assertEquals(accountPage.getToastMsg(), "Registered Successfully");
	}

	@Test(dataProvider = "existingAccountData")
	public void verifyErrorOnCreateAccountForExistingEmail(HashMap<String, String> input) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickRegisterLink();
		CreateAccountPage accountPage = new CreateAccountPage(driver);
		accountPage.createNewAccount(input.get("firstName"), input.get("lastName"), input.get("email"),
				input.get("phone"), input.get("occupation"), input.get("password"));
		Assert.assertEquals(accountPage.getToastMsg(), "User already exisits with this Email Id!");
	}

	// validate inputs
	// validate password[min lenght, 1 uppercase, 1 lowercase, 1 special chart ]
	@Test(dataProvider = "shortPasswordData", enabled = false)
	public void validateErrorOnCreateAccountForShortPassword(String firstName, String lastName, String email,
			String phone, String occupation, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickRegisterLink();
		CreateAccountPage accountPage = new CreateAccountPage(driver);
		accountPage.createNewAccount(firstName, lastName, email, phone, occupation, password);
		Assert.assertEquals(accountPage.getToastMsg(), "Password must be 8 Character Long!");
	}

	@DataProvider
	public Object[][] existingAccountData() {
		HashMap<String, String> map = new HashMap<>();
		map.put("firstName", "santiago");
		map.put("lastName", "castanon");
		map.put("email", "santiagocastanonarvizu@gmail.com");
		map.put("phone", "4426244708");
		map.put("occupation", "Engineer");
		map.put("password", "sAn123@0");
		return new Object[][] { { map } };
	}

	@DataProvider
	public Object[][] newSuccessfullAccountData() {
		List<HashMap<String, String>> data = getJsonDataToMap("NewAccountData.json");
		return data.stream().map(entry -> new Object[] { entry }).toArray(Object[][]::new);
	}

	@DataProvider
	public Object[][] shortPasswordData() {
		return new Object[][] {
				{ "santiago", "castanon", "santiagocastanonarvizu@gmail.com", "4426244708", "Engineer", "1234" } };
	}

}
