package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	@Test
	public void verifyWheterUserisAbleToLoginWithValidCredentials() throws IOException {
		
		String userNameValue =ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();
	}
	
	@Test
	
	public void verifyWhetherUserisAbleToLoginWithValidUsernameInvalidPaswrd() throws IOException {
		
		String userNameValue =ExcelUtility.readStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(1, 1, "LoginPage");
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();		
	}
	
     @Test
	
	public void verifyWhetherUserisAbleToLoginWithInvalidUsernameValidPaswrd() throws IOException {
		
    	String userNameValue =ExcelUtility.readStringData(2, 0, "LoginPage");
 		String passwordValue = ExcelUtility.readStringData(2, 1, "LoginPage");
 		
 		
 		LoginPage loginpage = new LoginPage(driver);
 		loginpage.enterUserNameOnUserNameField(userNameValue);
 		loginpage.enterPasswordOnPasswordField(passwordValue);
 		loginpage.loginButtonClick();
     }
     
     @Test
     public void verifyWheteherUserisAbleToLoginWithInvalidCredentials() throws IOException {
    	 
    	String userNameValue =ExcelUtility.readStringData(3, 0, "LoginPage");
 		String passwordValue = ExcelUtility.readStringData(3, 1, "LoginPage");
 		
 		
 		LoginPage loginpage = new LoginPage(driver);
 		loginpage.enterUserNameOnUserNameField(userNameValue);
 		loginpage.enterPasswordOnPasswordField(passwordValue);
 		loginpage.loginButtonClick();
    	 
     }

}
