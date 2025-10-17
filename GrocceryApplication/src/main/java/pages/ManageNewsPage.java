package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {

	public WebDriver driver;
	WaitUtility wait = new WaitUtility();

	public ManageNewsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButton;
	@FindBy(id = "news")
	WebElement newTextbox;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@type='text']")
	WebElement searchText;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchSubmitBtn;

	// Assertion
	@FindBy(xpath = "//div[contains(@class, 'alert-success')]")
	WebElement newsCreationSuccessMsg;
	@FindBy(xpath = "//tr[1]/td[1]")
	WebElement searchResultTable;

	public ManageNewsPage newBtnClick() {
		newButton.click();
		return this;
	}

	public ManageNewsPage newTextBoxMsg() {
		newTextbox.sendKeys("Morning Dews");
		return this;
		
	}

	public ManageNewsPage saveButtonClick() {
		saveButton.click();
		return this;
	}

	public ManageNewsPage searchButtonClick() {
		searchButton.click();
		return this;
	}

	public ManageNewsPage searchNewsText() {
		searchText.sendKeys("Morning Dews");
		return this;
	}

	public ManageNewsPage searchSubmitButtonClick() {
		searchSubmitBtn.click();
		return this;
	}

	// Assertion
	public boolean isNewsCreationSuccessAlertDisplayed() {
		return newsCreationSuccessMsg.isDisplayed();
	}

	public String isUserListed() {
		wait.waitUntilElementIsVisible(driver, searchResultTable);
		return searchResultTable.getText();
	}

}
