package adactinPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdactinHomePage {
	WebDriver driver;
	
	By loggedinUserName = By.id("username_show");
	By welcomeMessage = By.xpath("//td[contains(text(),'Welcome to')]");
	By logoutLink = By.linkText("Logout");
	By searchHotelLink = By.linkText("Search Hotel");
	By bookedItineraryLink = By.linkText("Booked Itinerary");
	By changePasswordLink = By.linkText("Change Password");
	
	
	public AdactinHomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
	public String getLoggedinUserName(){
	/*
		String[] arr = driver.findElement(loggedinUserName).getAttribute("value").split(" ");
		return arr[1].substring(0,arr[1].length()-1);
	*/	
		String uName = driver.findElement(loggedinUserName).getAttribute("value");
		return uName.substring(6, uName.length()-1);
	}
	
	public String getWelcomMessage(){
		return driver.findElement(welcomeMessage).getText();
	}
		
	public void gotoSearcHotel(){
		driver.findElement(searchHotelLink).click();	
	}
	
	public void gotoBookedItinerary(){
		driver.findElement(bookedItineraryLink).click();
	}

	public void gotoChangePassword(){
		driver.findElement(changePasswordLink).click();
	}
	
	//This is logout from the application
	public void logout(){
		driver.findElement(logoutLink).click();
	}
}
