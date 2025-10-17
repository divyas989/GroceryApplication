package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {

	public WebDriver driver;
	PageUtility pageutl = new PageUtility();
	WaitUtility wait = new WaitUtility();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement loginbtn;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement loginTitle;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertbox;

	public LoginPage enterUserNameOnUserNameField(String userNameValue) {
		username.sendKeys(userNameValue);
		return this;

	}

	public LoginPage enterPasswordOnPasswordField(String passwordValue) {
		password.sendKeys(passwordValue);
		return this;

	}

	public HomePage loginButtonClick() {
		wait.waitUntilElementToBeClickable(driver, loginbtn);// wait applied
		loginbtn.click();
		return new HomePage(driver);
	}

	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();

	}

	public String isTitleDisplayed() {
		return loginTitle.getText();
	}

	public String actualURL() {
		return driver.getCurrentUrl();
	}

	public boolean isAlertboxDisplayed() {
		return alertbox.isDisplayed();
	}

}
