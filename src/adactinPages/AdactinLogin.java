package adactinPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdactinLogin {
	
	WebDriver driver;
	By username = By.id("username");
	By password = By.id("password");
	By login = By.id("login");
	By forgotPasswordLink = By.linkText("Forgot Password?");
	By userMissingError = By.xpath("//span[@id='username_span']");
	By passwordMissingError = By.xpath("//span[@id='password_span']");
	By authError = By.xpath("//b[contains(.,'Invalid Login Details')]");
	
	
	public AdactinLogin(WebDriver driver){
		this.driver = driver;
	}
	
	public void setUserName(String strUserName){
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(strUserName);
	}

	public void setPassword(String strPassword){
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(strPassword);
	}
	
	public void clickLogin(){
		driver.findElement(login).click();
	}
	
	public void gotoForgotPassword(){
		driver.findElement(forgotPasswordLink).click();
	}
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public String getUserMissingError(){
		return driver.findElement(userMissingError).getText();
	}
	
	public String getPasswordMissingError(){
		return driver.findElement(passwordMissingError).getText();
	}
	
	public String getAuthenticationError(){
		return driver.findElement(authError).getText();
	}
	
	public void login(String user, String pwd){
		this.setUserName(user);
		this.setPassword(pwd);
		this.clickLogin();
	}
}
