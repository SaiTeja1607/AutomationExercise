package AutomationExercise.AllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationExercise.ReusableMethods.ReusableMethods;

public class SignUpOrLoginPage extends ReusableMethods {
	
	WebDriver driver;
	public SignUpOrLoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//h2[text()='Login to your account']")	
WebElement logInToYourAccountText;

@FindBy(css="input[type='email']:nth-child(2)")
WebElement loginEmailAddressField;

@FindBy(name="password")
WebElement passwordField;

@FindBy(xpath="//button[text()='Login']")
WebElement loginButton;

@FindBy(xpath="//h2[text()='New User Signup!']")	
WebElement newUserSignUpText;

@FindBy(name="name")
WebElement userNameField;

@FindBy(css="input[type='email']:nth-child(3)")
WebElement signUpEmailAddressField;

@FindBy(xpath="//button[text()='Signup']")
WebElement signUpButton;


public boolean newUserSignUpIsVisible()
{
	return webElementIsDisplayed(newUserSignUpText);
}

public void enterLoginNameAndEmail(String emailAddress, String password)
{
	enterDataInTextField(loginEmailAddressField, emailAddress);
	enterDataInTextField(passwordField, password);
}

public void enterNewUserNameAndEmail(String userName, String emailAddress)
{	
	enterDataInTextField(userNameField, userName);
	enterDataInTextField(signUpEmailAddressField, emailAddress);
}

public void clickOnSignUp()
{
	clickOnElement(signUpButton);
}

}
