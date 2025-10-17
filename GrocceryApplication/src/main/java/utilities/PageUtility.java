package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}

	public void selectDropdownWithIndex(WebElement element, int index) {

		Select object = new Select(element);
		object.selectByIndex(index);

	}
	
	public void selectDropdownWithVisibleText(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByVisibleText(value);

	}
	
	public void selectCheckBox(WebElement element) {
		element.click();
	}
	
	public void selectRadioButton(WebElement element) {
		element.click();
	}
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions actions= new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions actions= new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	public void dragAndDrop(WebDriver driver,WebElement drag, WebElement drop)
	{
		Actions actions= new Actions(driver);
		actions.dragAndDrop(drag, drop).build().perform();
	}
}
