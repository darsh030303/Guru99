package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

	@FindBy(name="uid")    WebElement user99GuruName; // Page Factory is an inbuilt pom concept for Selenium WebDriver but it is very optimized.
	@FindBy(name="password")     WebElement password99Guru;    
	@FindBy(className="barone")     WebElement titleText;
    @FindBy(name="btnLogin")     WebElement login;
    
    public LoginPage(WebDriver driver)
    {

        this.driver = driver;
      //AjaxElementLocatorFactory    It is working on lazy loading concept
        // One of the key advantages of using Page Factory pattern is AjaxElementLocatorFactory Class.
        //Here, when an operation is performed on an element the wait for its visibility starts from that moment only. 
        //If the element is not found in the given time interval, Test Case execution will throw 'NoSuchElementException' exception.


        //AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,10);//this can be use to check all elements are visbile before starting test
        //This initElements method will create all WebElements
        //PageFactory.initElements(factory, this);
        //or use below 
        
        PageFactory.initElements(driver, this);
    }
  //Set user name in textbox
    public void setUserName(String strUserName)
    {
        try
    	{
        	user99GuruName.sendKeys(strUserName);
        }
    	catch(NoSuchElementException e)
    	{
    		System.out.println(e);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}

    }

  //Set password in password textbox
    public void setPassword(String strPassword)
    {

       	try
    	{
    		password99Guru.sendKeys(strPassword);
        }
    	catch(NoSuchElementException e)
    	{
    		System.out.println(e);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}

    }
    
  //Click on login button
    public void clickLogin()
    {

      	try
    	{
    		login.click();
        }
    	catch(NoSuchElementException e)
    	{
    		System.out.println(e);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}

    }
    
  //Get the title of Login Page
    public String getLoginTitle()
    {

    	try
    	{
    		return    titleText.getText();
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
    
    public void loginToGuru99(String strUserName,String strPasword)
    {

        //Fill user name

        this.setUserName(strUserName); //removing this keyword will also work 

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();        
    }
    
}
