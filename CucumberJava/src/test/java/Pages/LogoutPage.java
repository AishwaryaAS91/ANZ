package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.GenericUtils;
import io.cucumber.java.After;

public class LogoutPage {
	WebDriver driver;
	GenericUtils gu;

	public LogoutPage(WebDriver driver)
	{
		this.driver = driver;
		gu=new GenericUtils(driver);
	}
	
	By signOutButton=By.xpath("//a[@class='logout']");
	
	public void signOut() {
		gu.elementClick(signOutButton);
		driver.close();
	}
	
}
