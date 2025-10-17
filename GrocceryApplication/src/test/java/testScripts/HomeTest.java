package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	HomePage homePage;
	@Test
	public void verifyLogoutUponClickingLogout() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		homePage=login.loginButtonClick();
		
        homePage.adminIconClick();
       login= homePage.logoutBtnClick();

		String expected = "https://groceryapp.uniqassosiates.com/admin/login";
		String actual = login.actualURL();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constant.InvalidUrlError);
	
	}

}
