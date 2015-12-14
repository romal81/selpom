package adactinPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdactinLogin {
	
	WebDriver driver;
	By username = By.id("username");
	By password = By.id("password");
	By login = By.id("login");
	
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
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public void login(String user, String pwd){
		this.setUserName(user);
		this.setPassword(pwd);
		this.clickLogin();
	}
}
