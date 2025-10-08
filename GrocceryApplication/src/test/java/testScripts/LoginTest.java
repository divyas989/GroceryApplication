package testScripts;

import java.io.IOException;

import org.testng.Assert;
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
		
		boolean dashBoardDisplay=loginpage.isDashboardDisplayed();
		Assert.assertTrue(dashBoardDisplay,"User unable to successfully login with valid credentials");
		//Assertion applied
	}
	
	@Test
	
	public void verifyWhetherUserisAbleToLoginWithValidUsernameInvalidPaswrd() throws IOException {
		
		String userNameValue =ExcelUtility.readStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(1, 1, "LoginPage");
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();	
		
		String expected="7rmart supermarket";
		String actual=loginpage.isTitleDisplayed();
		Assert.assertEquals(actual, expected,"User able tologin with invalid credentials");
		
	}
	
     @Test
	
	public void verifyWhetherUserisAbleToLoginWithInvalidUsernameValidPaswrd() throws IOException {
		
    	String userNameValue =ExcelUtility.readStringData(2, 0, "LoginPage");
 		String passwordValue = ExcelUtility.readStringData(2, 1, "LoginPage");
 		
 		
 		LoginPage loginpage = new LoginPage(driver);
 		loginpage.enterUserNameOnUserNameField(userNameValue);
 		loginpage.enterPasswordOnPasswordField(passwordValue);
 		loginpage.loginButtonClick();
 		
 		
 		String expected= "https://groceryapp.uniqassosiates.com/admin/login";
		String actual= loginpage.actualURL();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "user is able to login with invalid credentials");
     }
     
     @Test
     public void verifyWheteherUserisAbleToLoginWithInvalidCredentials() throws IOException {
    	 
    	String userNameValue =ExcelUtility.readStringData(3, 0, "LoginPage");
 		String passwordValue = ExcelUtility.readStringData(3, 1, "LoginPage");
 		
 		
 		LoginPage loginpage = new LoginPage(driver);
 		loginpage.enterUserNameOnUserNameField(userNameValue);
 		loginpage.enterPasswordOnPasswordField(passwordValue);
 		loginpage.loginButtonClick();
 		
 		boolean alertBoxDisplayed=loginpage.isAlertboxDisplayed();
		System.out.println(alertBoxDisplayed);
		Assert.assertFalse(!alertBoxDisplayed, "user is able to login with invalid credentials");
		
    	 
     }

}
