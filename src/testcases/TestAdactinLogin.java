package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import adactinPages.AdactinHomePage;
import adactinPages.AdactinLogin;
import adactinPages.AdactinLogout;

public class TestAdactinLogin {
	
	WebDriver driver;
	AdactinLogin objLogin;
	AdactinHomePage objHomePage;
	AdactinLogout objLogout;
	
	@BeforeSuite
	@Parameters("appUrl")
	public void setup(String appUrl){
		driver = new FirefoxDriver();
		//driver = new HtmlUnitDriver();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
	
	//Valid user test cases
	@Test(priority=1)
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
		
		objHomePage.logout();
		objLogout.gotoLogin();
	}
	
}
