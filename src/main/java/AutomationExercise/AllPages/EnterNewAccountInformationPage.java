package AutomationExercise.AllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationExercise.ReusableMethods.ReusableMethods;

public class EnterNewAccountInformationPage extends ReusableMethods {

	WebDriver driver;

	public EnterNewAccountInformationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//b[text()='Enter Account Information']")
	WebElement enterAccountInformationText;

	@FindBy(xpath = "//label[@for='id_gender1']")
	WebElement genderMale;

	@FindBy (xpath = "//label[@for='id_gender2']")
	WebElement genderFemale;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "days")
	WebElement dobDayDropdown;

	@FindBy(id = "months")
	WebElement dobMonthDropdown;

	@FindBy(id = "years")
	WebElement dobYeardropdown;

	@FindBy(xpath = "//label[text()='Sign up for our newsletter!']")
	WebElement signUpForNewsletterCheckBox;

	@FindBy(xpath = "//label[text()='Receive special offers from our partners!']")
	WebElement receiveSpecialOffersCheckBox;

	@FindBy(id = "first_name")
	WebElement enterFirstName;

	@FindBy(id = "last_name")
	WebElement enterLastName;

	@FindBy(id = "company")
	WebElement enterCompanyName;

	@FindBy(id = "address1")
	WebElement enterAddr1;

	@FindBy(id = "address2")
	WebElement enterAddr2;

	@FindBy(id = "country")
	WebElement selectCountry;

	@FindBy(id = "state")
	WebElement enterState;

	@FindBy(id = "city")
	WebElement enterCity;

	@FindBy(id = "zipcode")
	WebElement enterZip;

	@FindBy(id = "mobile_number")
	WebElement enterMobileNum;

	@FindBy(css = "button[data-qa='create-account']")
	WebElement createAccountButton;

	public boolean enterAccountInformationTextISVisible() {
		return enterAccountInformationText.isDisplayed();
	}

	public void enterNewUserDetails(String gender, String password, String day, String month, String year) {

		if (genderMale.getText().equalsIgnoreCase(gender+".")) {
			clickOnElement(genderMale);
		}
		if (genderFemale.getText().equalsIgnoreCase(gender+".")) {
			clickOnElement(genderFemale);
		}
		enterDataInTextField(passwordField, password);

		selectFromNumberDropdown(dobDayDropdown, day);
		selectFromTextDropdown(dobMonthDropdown, month);
		selectFromNumberDropdown(dobYeardropdown, year);

	}

	public void clickOnsignUpForNewsletterCheckBox() {

		clickOnElement(signUpForNewsletterCheckBox);
	}

	public void clickOnReceiveSpecialOffersCheckBox() {
		clickOnElement(receiveSpecialOffersCheckBox);
	}

	public void fillUserDetails(String firstName, String lastName, String companyName, String address, String country, String state, String city, String zipCode, String mobileNumber)
	{
		enterDataInTextField(enterFirstName, firstName);
		enterDataInTextField(enterLastName, lastName);
		enterDataInTextField(enterCompanyName, companyName);
		enterDataInTextField(enterAddr1, address);
		selectFromTextDropdown(selectCountry, country);
		enterDataInTextField(enterState, state);
		enterDataInTextField(enterCity, city);
		enterDataInTextField(enterZip, zipCode);
		enterDataInTextField(enterMobileNum, mobileNumber);
	}
	
	public void clickOnCreateAccountButton()
	{
		clickOnElement(createAccountButton);
		
	}
	
}
