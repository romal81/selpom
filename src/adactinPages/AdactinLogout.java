package adactinPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdactinLogout {
	
	WebDriver driver;
	
	By logoutMessage = By.className("reg_success");
	By loginLink = By.linkText("Click here to login again");
	
	public AdactinLogout(WebDriver driver){
		this.driver = driver;
	}
	
	public String getLogoutMessage(){
		return driver.findElement(logoutMessage).getText();
	}
	
	public void gotoLogin(){
		driver.findElement(loginLink).click();
	}

}
