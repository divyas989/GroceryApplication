package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage homePage;
	ManageNewsPage mnp;

	@Test
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		homePage = login.loginButtonClick();

		mnp = homePage.manageNewsMoreInfoClick();
		mnp.newBtnClick().newTextBoxMsg().saveButtonClick();

		boolean newscreatedSuccess = mnp.isNewsCreationSuccessAlertDisplayed();
		System.out.println(newscreatedSuccess);
		Assert.assertTrue(newscreatedSuccess, Constant.AddingNewsError);

	}

	@Test
	public void verifyWhetherUserIsAbleToSearchAddedNews() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		homePage = login.loginButtonClick();

		mnp = homePage.manageNewsMoreInfoClick();
		mnp.searchButtonClick().searchNewsText().searchSubmitButtonClick();

		String expected = "Morning Dews";
		String actual = mnp.isUserListed();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constant.SearchingNewsError);

	}
}
