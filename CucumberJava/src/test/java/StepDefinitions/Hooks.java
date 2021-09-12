package StepDefinitions;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Pages.LoginPage;
import Pages.LogoutPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;


public class Hooks {
	WebDriver driver;
//	LoginPage login;
//	LogoutPage logout;
//	
	/*
	 * public Hooks(WebDriver driver) { this.driver = driver;
	 * 
	 * }
	 */
//
//	@Before
//	public void launchUrl() {
//		login=new LoginPage(driver);
//		driver = login.signInpage();
//	}
//
//	@After
//	public void logout() { 
//		logout=new LogoutPage(driver);
//		logout.signOut(); 
//	}
	@Before
	public void setup(Scenario scenario) {
		Allure.step(scenario.getName()+" Has been Started");
		System.out.println("inside Before:");
	}
	@After
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	    	Allure.step(scenario.getName()+" failed");	
	    	System.out.println(scenario.getName()+" failed");
	    }
	}
}
