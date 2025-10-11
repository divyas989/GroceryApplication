package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

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

	public void enterUserNameOnUserNameField(String userNameValue) {

		username.sendKeys(userNameValue);

	}

	public void enterPasswordOnPasswordField(String passwordValue) {

		password.sendKeys(passwordValue);

	}

	public void loginButtonClick() {
		loginbtn.click();
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
