package AutomationExercise.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v129.page.model.Screenshot;
import org.openqa.selenium.support.ui.Select;

public class ReusableMethods {

	WebDriver driver;
	public  ReusableMethods(WebDriver driver)
	{
		this.driver=driver;
	}
	
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
	
	public String  getTitleOfPage()
	{
	 return driver.getTitle();
	}
	
	public void RandomUserCreds()
	{
		HashMap<String, String> creds = new HashMap<String, String>();
		String userName = RandomStringUtils.randomAlphabetic(10);
		String userEmail = RandomStringUtils.random(6).concat("@test.com");
		String password = RandomStringUtils.random(8);
		creds.put("randomUserName", userName);
		creds.put("randomUserEmail", userEmail);
		creds.put("RandomPassword", password);
		System.out.println(creds.keySet());	
	}
	
	
}
