package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.MyAccountPage;
import Pages.RegisterUserPage;
import Utils.GenericUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class RegisterUserSteps {
	WebDriver driver;
	GenericUtils gu;
	LoginPage login;
	RegisterUserPage registeruser;
	MyAccountPage myaccount;
	LogoutPage logout;

	@Given("user is on YourLoga Home page")
	public void user_is_on_your_loga_home_page() {
		login=new LoginPage(driver);
		driver = login.signInpage();
		login.verifyLoginPage();

	}

	@When("user clicks on Sign In button")
	public void user_clicks_on_sign_in_button() {
		login.clickOnSignInButton();

	}
	@And("^enters (.*)$")
	public void enters_email_address(String emailaddress) {
		login.enterEmailAddress(emailaddress);

	}

	@And("clicks on Create an Account button")
	public void clicks_on_create_an_account_button() {
		login.clickOnCreateAnAccountButton();
	}

	@And("^user enters user details(.*) (.*) (.*)$")
	public void user_enters_user_details(String firstname,String lastname,String password) {
		registeruser=new RegisterUserPage(driver);
		registeruser.enterUserDetails(firstname, lastname, password);
	}

	@And("^user enters address details(.*) (.*) (.*) (.*)$")
	public void user_enters_address_details(String address,String city,String state,String zip) {
		registeruser.enterAddressDetails(address, city, state, zip);

	}

	@And("^user enters mobile number(.*)$")
	public void user_enters_mobile_number(String phone) {
		registeruser.enterPhonenumber(phone);

	}	

	@And("cliks on Register button")
	public void cliks_on_register_button() {
		registeruser.clickOnRegister();

	}

	@Then("^new user account creation is verified on landing page (.*) (.*)$")
	public void new_user_account_creation_is_verified_on_landing_page(String firstname,String lastname) {
		myaccount=new MyAccountPage(driver);
		myaccount.verifyNameOnLandingPage(firstname, lastname);
		logout=new LogoutPage(driver);
		logout.signOut(); 

	}



}
