package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import adactinPages.AdactinHomePage;
import adactinPages.AdactinLogin;

public class TestAdactinInvalidLogin {
	
	WebDriver driver;
	AdactinLogin objLogin;
	AdactinHomePage objHomePage;
	
	/*@BeforeClass
	@Parameters("appUrl")
	public void setup(String appUrl){
		driver = new FirefoxDriver();
		//driver = new HtmlUnitDriver();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}*/
	
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
	
	@Test(priority=1,dataProvider="loginCreds")
	public void testInvalidLogin(String user, String pwd){
		objLogin = new AdactinLogin(driver);
		objHomePage = new AdactinHomePage(driver);
		
		objLogin.setUserName(user);
		objLogin.setPassword(pwd);
		objLogin.clickLogin();
		
		//System.out.println("The title of login page is: " + objLogin.getLoginPageTitle());
		Assert.assertEquals(objLogin.getLoginPageTitle(), "AdactIn.com - Hotel Reservation System");
		
		if(user.isEmpty()){
			Assert.assertEquals(objLogin.getUserMissingError(), "Enter Username");
		}
		else if(!user.isEmpty() && pwd.isEmpty()){
			Assert.assertEquals(objLogin.getPasswordMissingError(), "Enter Password");
		}
		else if(!user.isEmpty() && !pwd.isEmpty()){
			Assert.assertEquals(objLogin.getAuthenticationError(), "Invalid Login Details");
		}

	}

}
