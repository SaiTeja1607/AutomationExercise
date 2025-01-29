package AutomationExercise.AllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationExercise.ReusableMethods.ReusableMethods;

public class PageHeader extends ReusableMethods {
	
	WebDriver driver;

 public PageHeader(WebDriver driver)
	{
	 super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath="//a[@href='/login']") 
WebElement homeButton;
 
@FindBy(xpath="//a[@href='/products']")
WebElement productsButton;

@FindBy(xpath="//a[@href='/view_cart']")
WebElement cartButton;

@FindBy(xpath="//a[@href='/login']")
WebElement signUpOrLoginButton;

@FindBy(xpath="//a[@href='/test_cases']")
WebElement testCasesButton;

@FindBy(xpath="//a[@href='/api_list']")
WebElement apiTestingButton;
	
@FindBy(xpath="//a[@href='https://www.youtube.com/c/AutomationExercise']")
WebElement videoTutorialsButton;

@FindBy(xpath="//a[@href='/contact_us']")
WebElement contactUsButton;

@FindBy(xpath = "//a/i[@class='fa fa-user']/parent::a")
WebElement loggedInUser;

@FindBy(xpath="//a[@href='/delete_account']")
WebElement deleteAccountButton;

@FindBy(xpath="//a[@href='/logout']")
WebElement logOutButton;


public void clickOnHome()
{
	clickOnElement(homeButton);
}

public void clickOnProducts()
{
	clickOnElement(productsButton);
}

public void clickOnCart()
{
	clickOnElement(cartButton);
}

public void clickOnSignUpOrLogin()
{	
	clickOnElement(signUpOrLoginButton);
}

public void clickOnVideoTutorials()
{	
	clickOnElement(videoTutorialsButton);
}

public void clickOnContactUs()
{	
	clickOnElement(contactUsButton);
}

public void clickOnDeleteAccountButton()
{
	clickOnElement(deleteAccountButton);	
}

public void clickOnLogOutButton()
{
	clickOnElement(logOutButton);
}

public boolean loggedInAsUserDisplayed(String userName)
{
return	loggedInUser.getText().equalsIgnoreCase("Logged in As "+ userName);
}


}
