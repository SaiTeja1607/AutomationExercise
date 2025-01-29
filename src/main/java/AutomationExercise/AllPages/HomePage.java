package AutomationExercise.AllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import AutomationExercise.ReusableMethods.ReusableMethods;

public class HomePage extends ReusableMethods {

	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	
		PageFactory.initElements(driver, this);
		
	}
	
	
	public boolean homePageIsDisplayed()
	{
	String title=	getTitleOfPage();
return	title.equals("Automation exercise");
	}
	
	
	
}
