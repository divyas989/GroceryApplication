package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base {
	HomePage homePage;
	AdminUsersPage admin;

	@Test
	public void verifyUserIsAbleToAddNewUser() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		homePage=login.loginButtonClick();

	
		admin=homePage.adminUsersmoreInfolinkClick();// homepage admin users click

		RandomDataUtility random = new RandomDataUtility();
		String userNam = random.createRandomUserName();
		String passWordval = random.createRandomPassword();// faker usage
        admin.newBtnClick();
		admin.enterUsernameOnUsernameField(userNam).enterPasswordOnPasswordField(passWordval).userTypeDropDown().saveBtnClick();

		// String expected= "×\r\n"+ "Alert!\r\n"+ "User Created Successfully";
		String actual = admin.alertDisplayed();
		// System.out.println(admin.AlertDisplayed());
		Assert.assertTrue(actual.contains("User Created Successfully"), Constant.UnableToAddUserError);

	}

	@Test
	public void verifyUserIsAbleToSearchUser() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		homePage=login.loginButtonClick();

		admin=homePage.adminUsersmoreInfolinkClick();
        String user="Caleb";
	    admin.searchBtnClick().searchUserTypeClick(user).selectDrpDwn();
		admin.searchUserBtnClick();// To search for an already existing user.
		String expected=user;

	     String actual= admin.isUserListed();
	     Assert.assertEquals(actual, expected,"Unable to search");
		 
	}

	@Test
	public void verifyUserIsAbleToReset() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		homePage=login.loginButtonClick();

	
		admin=homePage.adminUsersmoreInfolinkClick();// homepage admin users click

		
		admin.searchBtnClick().searchUserBtnClick().resetBtnClick1();// to identify driver first search and then return for reset
		

		// Assertion
		Boolean resetHappened = admin.IsresetHappen();
		System.out.println(resetHappened);
		Assert.assertFalse(resetHappened, Constant.UnAbletoResetError);
	}

}
