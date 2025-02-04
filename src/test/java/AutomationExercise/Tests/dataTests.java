package AutomationExercise.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AutomationExercise.TestComponents.BaseTestClass;

public class dataTests extends BaseTestClass{

	
	@Test(dataProvider="loginData", dataProviderClass=AutomationExercise.Utilities.DataProviderClass.class)
	public void loginUser(String newUserEmail, String newUserName) {
		
				pageHeader.clickOnSignUpOrLogin();

				boolean y = signUpOrLoginPage.newUserSignUpIsVisible();
				Assert.assertTrue(y);
				signUpOrLoginPage.enterNewUserNameAndEmail(newUserName, newUserEmail);
				signUpOrLoginPage.clickOnSignUp();
				

	//Another Conflict
	
}
}
