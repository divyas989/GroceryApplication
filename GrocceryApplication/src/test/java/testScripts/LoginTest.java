package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(priority = 1, description = "User is trying to login with valid credentials", groups = { "smoke" })
	public void verifyWheterUserisAbleToLoginWithValidCredentials() throws IOException {

		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();

		boolean dashBoardDisplay = loginpage.isDashboardDisplayed();
		Assert.assertTrue(dashBoardDisplay, "User unable to successfully login with valid credentials");
		// Assertion applied
	}

	@Test(priority = 3, description = "User is trying to login with valid username and invalid password", retryAnalyzer = retry.Retry.class)

	public void verifyWhetherUserisAbleToLoginWithValidUsernameInvalidPaswrd() throws IOException {

		String userNameValue = ExcelUtility.readStringData(11, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(1, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();

		String expected = "7rmart supermarket";
		String actual = loginpage.isTitleDisplayed();
		Assert.assertEquals(actual, expected, "User able tologin with invalid credentials");

	}

	@Test(priority = 4)

	public void verifyWhetherUserisAbleToLoginWithInvalidUsernameValidPaswrd() throws IOException {

		String userNameValue = ExcelUtility.readStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(2, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();

		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		String actual = loginpage.actualURL();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "user is able to login with invalid credentials");
	}

	@Test(priority = 2,description="User is trying to login with Invalid credentials" ,groups = { "smoke" },dataProvider = "loginProvider")
	public void verifyWheteherUserisAbleToLoginWithInvalidCredentials(String userNameValue, String passwordValue) throws IOException {

		//String userNameValue = ExcelUtility.readStringData(3, 0, "LoginPage");
		//String passwordValue = ExcelUtility.readStringData(3, 1, "LoginPage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();

		boolean alertBoxDisplayed = loginpage.isAlertboxDisplayed();
		System.out.println(alertBoxDisplayed);
		Assert.assertFalse(!alertBoxDisplayed, "user is able to login with invalid credentials");

	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}

}
