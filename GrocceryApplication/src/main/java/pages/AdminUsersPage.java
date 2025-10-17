package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {

	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	PageUtility pageutl = new PageUtility();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement userName; // or id
	@FindBy(name = "password")
	WebElement passWord;
	@FindBy(name = "user_type")
	WebElement userType;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn; // or @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newBtn;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	WebElement saveBtn;// or @FindBy(xpath="//button[@name='Create']") WebElement saveBtn;

	// search
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchBtn;
	@FindBy(id = "un")
	WebElement searchUserName;
	@FindBy(id = "ut")
	WebElement searchDrpDwn;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement srchBtn;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement searchUser;

	// reset
	@FindBy(xpath = "//i[@class='ace-icon fa fa-sync-alt']")
	WebElement resetBtn;

	// Assertion
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newAlert;

	public AdminUsersPage newBtnClick() {
		newBtn.click();
		return this;
	}

	public AdminUsersPage enterUsernameOnUsernameField(String userNam) {
		userName.sendKeys(userNam);
		return this;

	}

	public AdminUsersPage enterPasswordOnPasswordField(String passWordval) {
		passWord.sendKeys(passWordval);
		return this;
	}

	public AdminUsersPage selectDrpDwn() {
		// Select select = new Select(searchDrpDwn);
		// select.selectByValue("staff");//by index dropdwnbtn
		pageutl.selectDropdownWithValue(searchDrpDwn, "staff");// used PageUtility
		return this;

	}
	public AdminUsersPage userTypeDropDown() {
		// Select select = new Select(searchDrpDwn);
		// select.selectByValue("staff");//by index dropdwnbtn
		pageutl.selectDropdownWithValue(userType, "staff");// used PageUtility
		return this;

	}

	public AdminUsersPage saveBtnClick() {
		saveBtn.click();// New user added steps done
		return this;
	}

	public AdminUsersPage searchBtnClick() { // search
		searchBtn.click();
		return this;
	}

	public AdminUsersPage searchUserTypeClick(String user) {
		searchUserName.sendKeys(user);
		return this;
	}

	public AdminUsersPage searchUserType() {
		// Select select = new Select(userType);
		// select.selectByValue("staff");
		pageutl.selectDropdownWithValue(userType, "staff");// used page Utility
		return this;

	}

	public AdminUsersPage searchUserBtnClick() {
		srchBtn.click();
		return this;

	}

	public AdminUsersPage resetBtnClick1() {
		resetBtn.click();
		return this;
	}
	
	public String isUserListed() {
		wait.waitUntilElementIsVisible(driver, searchUser);
		return searchUser.getText();
	}

	public String alertDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement alertBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'alert') and contains(@class,'alert-dismissible')]")));
		return alertBox.getText();
	}
	// Assertion done

	public String actualURL() {
		return driver.getCurrentUrl();
	}

	public boolean IsresetHappen() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(searchUserName));// invisibility of any element?
		return searchUserName.isDisplayed();
	}
}
