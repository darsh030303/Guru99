package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
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
