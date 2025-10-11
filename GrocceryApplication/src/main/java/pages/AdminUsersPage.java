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

public class AdminUsersPage {

	public WebDriver driver;

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

	// reset
	@FindBy(xpath = "//i[@class='ace-icon fa fa-sync-alt']")
	WebElement resetBtn;

	// Assertion
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newAlert;

	public void newBtnClick() {
		newBtn.click();
	}

	public void enterUsernameOnUsernameField(String userNam) {
		userName.sendKeys(userNam);
	}

	public void enterPasswordOnPasswordField(String passWordval) {
		passWord.sendKeys(passWordval);
	}

	public void selectDrpDwn() {
		Select select = new Select(searchDrpDwn);
		select.selectByValue("staff");
	}

	public void saveBtnClick() {
		saveBtn.click();// New user added steps done
	}

	public void searchBtnClick() { // search
		searchBtn.click();
	}

	public void searchUserTypeClick() {
		searchUserName.sendKeys("pla");
	}

	public void searchUserType() {
		Select select = new Select(userType);
		select.selectByValue("staff");
	}

	public void searchUserBtnClick() {
		srchBtn.click();

	}

	public void resetBtnClick1() {
		resetBtn.click();
	}

	public String AlertDisplayed() {
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
