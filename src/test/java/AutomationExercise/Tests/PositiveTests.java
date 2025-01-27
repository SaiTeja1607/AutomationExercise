package AutomationExercise.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationExercise.AllPages.AccountCreatedorDeletedConfirmationPage;
import AutomationExercise.AllPages.EnterNewAccountInformationPage;
import AutomationExercise.AllPages.PageHeader;
import AutomationExercise.AllPages.SignUpOrLoginPage;
import AutomationExercise.TestComponents.BaseTestClass;

public class PositiveTests extends BaseTestClass {

	
	@Test
	public void verifyRegisterUser() {
//testing git for 2nd time
		pageHeader.clickOnSignUpOrLogin();

		boolean y = signUpOrLoginPage.newUserSignUpIsVisible();
		Assert.assertTrue(y);
		signUpOrLoginPage.enterNewUserNameAndEmail("Teja", "teja@test.com");
		signUpOrLoginPage.clickOnSignUp();

		Assert.assertTrue(enterNewAccountInformationPage.enterAccountInformationTextISVisible());

		enterNewAccountInformationPage.enterNewUserDetails("Mr", "Teja111", "7", "May", "1996");
		enterNewAccountInformationPage.clickOnsignUpForNewsletterCheckBox();
		enterNewAccountInformationPage.clickOnReceiveSpecialOffersCheckBox();
		enterNewAccountInformationPage.fillUserDetails("Teja", "Patel", "ITT", "Test Address", "India", "Telangana",
				"Hyderabad", "500001", "9876543210");
		enterNewAccountInformationPage.clickOnCreateAccountButton();

		accountCreatedorDeletedConfirmationPage.accountCreatedConfirmationDisplayed();
		accountCreatedorDeletedConfirmationPage.clickOnContinue();

		Assert.assertTrue(pageHeader.loggedInAsUserDisplayed("Teja"));

		pageHeader.clickOnDeleteAccountButton();

		accountCreatedorDeletedConfirmationPage.accountDeletedConfirmationDisplayed();

	}

	//New Change 3
	
	

}
