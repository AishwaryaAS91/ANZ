package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utils.GenericUtils;

public class RegisterUserPage {
	WebDriver driver=null;
	GenericUtils gu=null;

	public RegisterUserPage(WebDriver driver)
	{
		this.driver = driver;
		gu=new GenericUtils(driver);

	}

	By fname=By.xpath("//input[@id='customer_firstname']");
	By lname=By.xpath("//input[@id='customer_lastname']");
	By emailid=By.xpath("//input[@id='email']");
	By pass=By.xpath("//input[@id='passwd']");
	By addressfname=By.xpath("//input[@id='firstname']");
	By addresslname=By.xpath("//input[@id='lastname']");
	By myaddress=By.xpath("//input[@id='address1']");
	By cityname=By.xpath("//input[@id='city']");
	By statename=By.xpath("//select[@id='id_state']");
	By zipcode=By.xpath("//input[@id='postcode']");
	By phonenumber=By.xpath("//input[@id='phone_mobile']");
	By aliasmyaddress=By.xpath("//input[@id='alias']");
	By register=By.xpath("//span[text()='Register']");

	public void enterUserDetails(String firstname,String lastname,String password) {
		gu.elementText(fname, firstname);
		gu.elementText(lname, lastname);
		gu.elementText(pass, password);

	}

	public void enterAddressUserDetails(String addressfirstname,String addresslastname) {
		gu.elementText(addressfname, addressfirstname);
		gu.elementText(addresslname, addresslastname);

	}

	public void enterAddressDetails(String address,String city,String state,String zip) {
		gu.elementText(myaddress, address);
		gu.elementText(cityname, city);
		gu.selectFromList(statename, state);
		gu.elementText(zipcode, zip);
	}

	public void enterPhonenumber(String phone) {
		gu.elementText(phonenumber, phone);
	}

	public void clickOnRegister() {
		gu.elementClick(register);
	}


}
