package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base{
	
	@Test
	public void verifyUserIsAbleToAddNewUser() throws IOException
	{
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginButtonClick();
		
		HomePage home= new HomePage(driver);
		home.adminUsersmoreInfolinkClick();//homepage admin users click
		
		RandomDataUtility random=new RandomDataUtility();
		String userNam=random.createRandomUserName();
		String passWordval=random.createRandomPassword();//faker usage
		
		AdminUsersPage admin= new AdminUsersPage(driver);
		admin.newBtnClick();
		admin.enterUsernameOnUsernameField(userNam);
		admin.enterPasswordOnPasswordField(passWordval);
		admin.selectDrpDwn();
		admin.saveBtnClick();
		
		//String expected= "×\r\n"+ "Alert!\r\n"+ "User Created Successfully";
		String actual= admin.AlertDisplayed();
		//System.out.println(admin.AlertDisplayed());
		Assert.assertTrue(actual.contains("User Created Successfully"),"User not added successfully");
		
	}
	@Test
	public void verifyUserIsAbleToSearchUser() throws IOException
	{
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginButtonClick();
		
		HomePage home= new HomePage(driver);
		home.adminUsersmoreInfolinkClick();
		
		AdminUsersPage admin= new AdminUsersPage(driver);
		admin.searchBtnClick();
		admin.searchUserTypeClick();
		admin.selectDrpDwn();
		admin.searchUserBtnClick();//To search for an already existing user.
		
		//String expected="https://groceryapp.uniqassosiates.com/admin/user/index?un=&ut=&Search=sr";
		/*String actual= admin.actualURL();
		System.out.println(actual);
		boolean val= actual.contains("Search=sr");
		System.out.println(val);
		Assert.assertTrue(val,"search not happened");*/
	}
	@Test
	public void verifyUserIsAbleToReset() throws IOException
	{
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userNameValue);
		login.enterPasswordOnPasswordField(passwordValue);
		login.loginButtonClick();
		
		HomePage home= new HomePage(driver);
		home.adminUsersmoreInfolinkClick();//homepage admin users click
		
		AdminUsersPage admin= new AdminUsersPage(driver);
		admin.searchBtnClick();
		admin.searchUserBtnClick();// to identify driver first search and then return for reset
		admin.resetBtnClick1();
		
		//Assertion
		Boolean resetHappened= admin.IsresetHappen();
		System.out.println(resetHappened);
		Assert.assertFalse(resetHappened,"reset has not happened");
	}


}
