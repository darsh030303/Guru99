package testSuite;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;


public class SanityTest {
	
	WebDriver driver;
	
	LoginPage objLogin;
    HomePage objHomePage; //first comment for first commit    sss
  //  InsurancePage objInsurance;

 
  @BeforeTest
  public void beforeTest()
  {
	 // System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32_n\\chromedriver.exe");
	  WebDriverManager.chromedriver().browserVersion("83.0.4103.61").setup(); // using dependency 
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
  }

  @Test(priority=0)
  public void test1_HomePage()
  {
	  //Create Login Page object
	  objLogin = new LoginPage(driver);
	  
	  //Verify login page title
	    String loginPageTitle = objLogin.getLoginTitle();
	    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		System.out.print(loginPageTitle);
		
  }
  
  @Test(priority=1)
  public void test2_login() throws Exception 
  {
	//login to application
		String user,pwd; int row=0,col=0;
		
	//	Excel1.setExcelFile(con1.Excelfilepath+con1.Excelfilename, con1.Excelsheetname);
	
	//	user=Excel1.getCellData(row, col);
		row=0;col=1;
	//	pwd=Excel1.getCellData(row, col);
	//	System.out.print(user+" "+pwd);
		//objLogin.loginToGuru99(user,pwd);
		
	    objLogin.loginToGuru99("mngr263190", "reduvEz");
  }
  
  @Test(priority=2)
  public void test3_VerifyLogin()
  {
	  // go the next page
	    objHomePage = new HomePage(driver);
	    System.out.println(objHomePage.getHomePagetitle());
	    Assert.assertTrue(objHomePage.getHomePagetitle().contains("Guru99 Bank Manager HomePage"));
	   /*
	    try
	    {
	    	Takescreenshot.takeScreenShot1(driver);
	    }
	    catch(IOException e)
	    {
	    	System.out.print(e);
	    }
	    catch(Exception e)
	    {
	    	System.out.print(e);
	    }
	    */
  }

 
  
  
}
