package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	
	@Test
	public void verifyLogoutUponClickingLogout() throws IOException
	{
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		
		
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginButtonClick();
		
		HomePage home= new HomePage(driver);
		home.adminIconClick();
		home.logoutBtnClick();
	}


}
