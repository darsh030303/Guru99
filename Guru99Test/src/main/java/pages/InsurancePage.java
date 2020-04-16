package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurancePage
{
	WebDriver driver;
	
	@FindBy(linkText="Insurance Project")    WebElement insurancelinktet; 
	
	
	public InsurancePage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void clickInsuracePageLink()
	{
		insurancelinktet.click();
	}
	
	public String getInsurancePagetitle()
    {
         return     driver.getTitle();
    }
	
}
