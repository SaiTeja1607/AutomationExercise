package AutomationExercise.ReusableMethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReusableMethods {

	
	public void enterDataInTextField(WebElement element, String text)
	{
		element.sendKeys(text);
		
	}
	
	public void clickOnElement(WebElement element)
	{
		element.click();
	}
	
	public void selectFromTextDropdown(WebElement dropdown, String textToSelect)
	{
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(textToSelect);
		
	}
	
	public void selectFromNumberDropdown(WebElement dropdown, String numberToSelect)
	{
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(numberToSelect);
		
	}
	
	public Boolean webElementIsDisplayed(WebElement element)
	{
	return	element.isDisplayed();
		
	}
}
