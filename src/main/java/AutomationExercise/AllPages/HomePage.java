package AutomationExercise.AllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import AutomationExercise.ReusableMethods.ReusableMethods;

public class HomePage extends ReusableMethods {

	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
}
