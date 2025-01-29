package AutomationExercise.Tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
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

		try {
		if(enterNewAccountInformationPage.enterAccountInformationTextISVisible())
		{
		Assert.assertTrue(enterNewAccountInformationPage.enterAccountInformationTextISVisible());
		}
		}
		catch(Exception e)
		{
			Assert.fail();
			
		}
		enterNewAccountInformationPage.enterNewUserDetails("Mr", "Teja111", "7", "May", "1996");
		enterNewAccountInformationPage.clickOnsignUpForNewsletterCheckBox();
		enterNewAccountInformationPage.clickOnReceiveSpecialOffersCheckBox();
		enterNewAccountInformationPage.fillUserDetails("Teja", "Patel", "ITT", "Test Address", "India", "Telangana",
				"Hyderabad", "500001", "9876543210");
		enterNewAccountInformationPage.clickOnCreateAccountButton();

		accountCreatedorDeletedConfirmationPage.accountCreatedConfirmationDisplayed();
		accountCreatedorDeletedConfirmationPage.clickOnContinue();

		try {
			if(pageHeader.loggedInAsUserDisplayed("Teja"))
			{
				Assert.assertTrue(pageHeader.loggedInAsUserDisplayed("Teja"));
			}
			}
			catch(Exception e)
			{
				Assert.fail();
				
			}
		
		pageHeader.clickOnDeleteAccountButton();

		try {
			if(accountCreatedorDeletedConfirmationPage.accountDeletedConfirmationDisplayed())
			{
				Assert.assertTrue(accountCreatedorDeletedConfirmationPage.accountDeletedConfirmationDisplayed());
			}
			}
			catch(Exception e)
			{
				Assert.fail();
				
			}
		

	}

	@Test
	public void loginWithCorrectCredentials()
	{
		try {
			
	if(homePage.homePageIsDisplayed())
	{
	Assert.assertTrue(homePage.homePageIsDisplayed());
	}
		}
	catch(Exception e)
	{
		Assert.fail();
	}

	pageHeader.clickOnSignUpOrLogin();
	try {
		if(signUpOrLoginPage.loginToYourAccountIsVisible())
		{
			Assert.assertTrue(signUpOrLoginPage.loginToYourAccountIsVisible());
		}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	signUpOrLoginPage.enterLoginNameAndEmail("Tejas@test.com", "Teja111");
	signUpOrLoginPage.clickOnLogin();
	try {
		if(pageHeader.loggedInAsUserDisplayed("Tejas"))
		{
  Assert.assertTrue(pageHeader.loggedInAsUserDisplayed("Tejas"));
	}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
  pageHeader.clickOnDeleteAccountButton();
  
  try {
	 if( accountCreatedorDeletedConfirmationPage.accountDeletedConfirmationDisplayed())
	 {
	  Assert.assertTrue(accountCreatedorDeletedConfirmationPage.accountDeletedConfirmationDisplayed());
  }
  }
	 catch(Exception e)
	 {
		 Assert.fail();
	 }
 

	
	}
	
	
	

}

