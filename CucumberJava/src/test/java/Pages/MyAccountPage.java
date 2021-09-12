package Pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.GenericUtils;

public class MyAccountPage {
	
	WebDriver driver;
	GenericUtils gu;

	public MyAccountPage(WebDriver driver)
	{
		this.driver = driver;
		gu=new GenericUtils(driver);

	}
	
	By myaccount=By.xpath("//a[@class='account']");
	
	public void verifyNameOnLandingPage (String firstname,String lastname) {
		String expectedfullname=firstname+" "+lastname;
		String actualfullname=gu.findElement(myaccount).getText();
		System.out.println(actualfullname);
		assertEquals(" Text did not match", expectedfullname, actualfullname);
		
	}

}
