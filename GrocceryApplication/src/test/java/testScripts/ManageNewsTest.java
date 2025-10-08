package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	  @Test	
	     public void verifyWhetherUserIsAbleToAddNewNews() throws IOException {
	    	String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
	 		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
	 		LoginPage loginpage = new LoginPage(driver);
	 		loginpage.enterUserNameOnUserNameField(userNameValue);
	 		loginpage.enterPasswordOnPasswordField(passwordValue);
	 		loginpage.loginButtonClick();
	 		
	 		HomePage homePage = new HomePage(driver);
	 		homePage.manageNewsMoreInfoClick();

	 		ManageNewsPage mnp=new ManageNewsPage(driver);
	 		mnp.newBtnClick();
	 		mnp.newTextBoxMsg();
	 		mnp.saveButtonClick();
	 		
	 		boolean newscreatedSuccess =mnp.isNewsCreationSuccessAlertDisplayed();
	  		System.out.println(newscreatedSuccess);
	  		Assert.assertTrue(newscreatedSuccess, "Unable to add new news");
	 		
	  
	  }
	  
	  @Test
	     public void verifyWhetherUserIsAbleToSearchAddedNews() throws IOException {
	    	String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
	  		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
	  		LoginPage loginpage = new LoginPage(driver);
	  		loginpage.enterUserNameOnUserNameField(userNameValue);
	  		loginpage.enterPasswordOnPasswordField(passwordValue);
	  		loginpage.loginButtonClick();
	  		
	  		HomePage homePage = new HomePage(driver);
	  		homePage.manageNewsMoreInfoClick();
	  		
	  		ManageNewsPage mnp=new ManageNewsPage(driver);
	 		mnp.searchButtonClick();
	 		mnp.searchNewsText();
	 		mnp.searchSubmitButtonClick();
	 		
	 		String expected= "Morning Dews";
	  		String actual = mnp.isUserListed();
			Assert.assertEquals(actual,expected,"Searched News is not available in the List");
	  		
	  		
	  }
}
