package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import adactinPages.AdactinHomePage;
import adactinPages.AdactinLogin;

public class TestAdactinLogin {
	
	WebDriver driver;
	AdactinLogin objLogin;
	AdactinHomePage objHomePage;
	
	@BeforeClass
	@Parameters("appUrl")
	public void setup(String appUrl){
		//driver = new FirefoxDriver();
		driver = new HtmlUnitDriver();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	//Valid user test cases
	@Test(priority=2, enabled=true)
	public void testValidLogin(){
		
		objLogin = new AdactinLogin(driver);
		objHomePage = new AdactinHomePage(driver);
		//System.out.println("The title of login page is: " + objLogin.getLoginPageTitle());
		Assert.assertEquals(objLogin.getLoginPageTitle(), "AdactIn.com - Hotel Reservation System");
		objLogin.setUserName("selpomuser1");
		objLogin.setPassword("selpomuser1");
		objLogin.clickLogin();
		
		Assert.assertEquals(objHomePage.getLoggedinUserName(), "selpomuser1");
		System.out.println("The logged in user name is: " + objHomePage.getLoggedinUserName());
		
		Assert.assertEquals(objHomePage.getWelcomMessage(), "Welcome to AdactIn Group of Hotels");
		System.out.println("The welcome message is: " + objHomePage.getWelcomMessage());
	}
		
	@DataProvider
	public static Object[][] loginCreds(){
		Object[][] login = new Object[4][2];
		
		login[0][0] = "";
		login[0][1] = "";
		
		login[1][0] = "admin";
		login[1][1] = "";
		
		login[2][0] = "";
		login[2][1] = "admin@123";
		
		login[3][0] = "selpomuser1";
		login[3][1] = "Selpomuser1";
		
		return login;		
	}
	
	//Invalid user test cases
	@Test(priority=1,dataProvider="loginCreds")
	public void testInvalidLogin(String user, String pwd){
		objLogin = new AdactinLogin(driver);
		objHomePage = new AdactinHomePage(driver);
		
		objLogin.setUserName(user);
		objLogin.setPassword(pwd);
		objLogin.clickLogin();
		
		//System.out.println("The title of login page is: " + objLogin.getLoginPageTitle());
		Assert.assertEquals(objLogin.getLoginPageTitle(), "AdactIn.com - Hotel Reservation System");
		

	}
	
}
