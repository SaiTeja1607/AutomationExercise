package AutomationExercise.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import AutomationExercise.AllPages.AccountCreatedorDeletedConfirmationPage;
import AutomationExercise.AllPages.EnterNewAccountInformationPage;
import AutomationExercise.AllPages.HomePage;
import AutomationExercise.AllPages.PageHeader;
import AutomationExercise.AllPages.SignUpOrLoginPage;


public class BaseTestClass {

	
	protected WebDriver driver;
	
	Properties prop;
	
	protected HomePage homePage;
	protected PageHeader pageHeader;
	protected AccountCreatedorDeletedConfirmationPage accountCreatedorDeletedConfirmationPage;
	protected EnterNewAccountInformationPage enterNewAccountInformationPage;
	protected SignUpOrLoginPage signUpOrLoginPage;

	public void initializeBrowser() throws IOException
	{
		 prop= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\AutomationExercise\\Utilities\\GlobalData.properties");
		prop.load(fis);
	String browserName =	prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		driver = new ChromeDriver();
		}
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	
  @BeforeMethod
	public WebDriver navigateToUrl() throws IOException
	{
		initializeBrowser();
		String url = prop.getProperty("url");
		driver.get(url);
		return driver;
	}
	
	@BeforeMethod(dependsOnMethods= {"navigateToUrl"})
	public void setUpObjects()
	{
		 homePage = new HomePage(driver);
		  pageHeader = new PageHeader(driver);
		  signUpOrLoginPage = new SignUpOrLoginPage(driver);
		  enterNewAccountInformationPage = new EnterNewAccountInformationPage(driver);
		  accountCreatedorDeletedConfirmationPage = new AccountCreatedorDeletedConfirmationPage(driver);	
	}
	
	//This BeforeMethod will run only before the methods specified under Required Methods
	@BeforeMethod(dependsOnMethods="setUpObjects")
	public void createUsersForTesting(ITestResult result)
	{
	String testName=	result.getMethod().getMethodName();
	//Required methods
	if(testName.equals("loginWithCorrectCredentials"))
	{
		pageHeader.clickOnSignUpOrLogin();
		signUpOrLoginPage.enterNewUserNameAndEmail( "Tejas","Tejas@test.com");
		signUpOrLoginPage.clickOnSignUp();
		enterNewAccountInformationPage.enterNewUserDetails("Mr", "Teja111", "7", "May", "1996");
		enterNewAccountInformationPage.clickOnsignUpForNewsletterCheckBox();
		enterNewAccountInformationPage.clickOnReceiveSpecialOffersCheckBox();
		enterNewAccountInformationPage.fillUserDetails("Teja", "Patel", "ITT", "Test Address", "India", "Telangana",
				"Hyderabad", "500001", "9876543210");
		enterNewAccountInformationPage.clickOnCreateAccountButton();

		accountCreatedorDeletedConfirmationPage.accountCreatedConfirmationDisplayed();
		accountCreatedorDeletedConfirmationPage.clickOnContinue();
		pageHeader.clickOnLogOutButton();
		pageHeader.clickOnHome();
	}
	}
	
	public String TakeScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		String screenshotName = testCaseName+".png";
		  String screenshotPath=System.getProperty("user.dir")+"\\screenshots\\"+screenshotName;
		  if(driver!=null)
		  {
		 TakesScreenshot ss=(TakesScreenshot)driver;
			File srcFile= ss.getScreenshotAs(OutputType.FILE);
			File destLocation=new File(screenshotPath);
			FileUtils.copyFile(srcFile, destLocation);		
	}
		  return screenshotPath;
	}

	
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
		
	}
	
	
	
}
