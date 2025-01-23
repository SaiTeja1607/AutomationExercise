package AutomationExercise.AllPages;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ContactUsPage{

	WebDriver driver;
	public ContactUsPage(WebDriver driver) {		
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//h2[text()='Get In Touch']")
WebElement getInTouch;

@FindBy(css="input[name='name']")
WebElement nameField;

@FindBy(name="email")
WebElement emailField;

@FindBy(xpath="//input[@name='subject']")
WebElement subjextField;

@FindBy(id="message")
WebElement enterMessage;

@FindBy(xpath="//input[@name='submit']")
WebElement submitButton;

@FindBy(className="alert-success")
List<WebElement> successMessage;

public void  getinTouchVisible()
{
	//return webElementisDisplayed(getInTouch);
}
	




}


