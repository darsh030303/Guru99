package test;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.InsurancePage;
import pages.LoginPage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SanityTest {
	
	WebDriver driver;
	
	LoginPage objLogin;
    HomePage objHomePage; //first comment for first commit    sss
    InsurancePage objInsurance;
 
  @BeforeTest
  public void beforeTest()
  {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");	
  }

  @Test(priority=0)
  public void test_MainPage_Check()
  {
	  //Create Login Page object
	  objLogin = new LoginPage(driver);
	  
	  //Verify login page title
	    String loginPageTitle = objLogin.getLoginTitle();
	    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

  }
  
  @Test(priority=1)
  public void login()
  {
	//login to application
	    objLogin.loginToGuru99("mngr252548", "buvEnat");
  }
  
  @Test(priority=2)
  public void VerifyLogin()
  {
	  // go the next page
	    objHomePage = new HomePage(driver);
	    
	   // System.out.println(objHomePage.getHomePagetitle());

	  //Verify home page
	    Assert.assertTrue(objHomePage.getHomePagetitle().contains("Guru99 Bank Manager HomePage"));
	    
	    System.out.println("Homepage test pass");
  }

  @Test(priority=3)
  public void gotoInsurancePage()
  {
	  objInsurance = new InsurancePage(driver);
	  objInsurance.clickInsuracePageLink();
	  
	  //Verify insurance page 
	  System.out.println(objInsurance.getInsurancePagetitle());
	  String InsurancePageTitle = objInsurance.getInsurancePagetitle();
	  Assert.assertTrue(InsurancePageTitle.contains("Insurance Broker System - Login"));
  }
  
  @AfterTest
  public void afterTest()
  {
	  driver.close();
  }
}
