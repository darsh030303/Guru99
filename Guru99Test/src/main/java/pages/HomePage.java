package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver, 10);
	   
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Get the User name from Home Page
    public String getHomePagetitle()
    {
    	
    	try
    	{
    		return     driver.getTitle();
    	}
    	catch(NoSuchElementException e)
    	{
    		System.out.println(e);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
		return null;
    }
}
