package AutomationExercise.AllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationExercise.ReusableMethods.ReusableMethods;



public class AccountCreatedorDeletedConfirmationPage extends ReusableMethods {

	WebDriver driver;
	public AccountCreatedorDeletedConfirmationPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//Page Objects	
@FindBy(xpath="//b[text()='Account Created!']")
WebElement accountCreatedConfirmation;	

@FindBy(xpath="//b[text()='Account Deleted!']")
WebElement accountDeletedConfirmation;

@FindBy(linkText="Continue")
WebElement continueButton;

//Action Methods

public Boolean  accountCreatedConfirmationDisplayed()
{
 Boolean accountCreated = webElementIsDisplayed(accountCreatedConfirmation);
return accountCreated;
}

public void clickOnContinue()
{
	clickOnElement(continueButton); 
}

public Boolean accountDeletedConfirmationDisplayed()
{
Boolean accountDeleted = webElementIsDisplayed(accountDeletedConfirmation);
return accountDeleted;
}

}


