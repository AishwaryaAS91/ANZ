package Pages;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utils.GenericUtils;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	WebDriver driver=null;
	GenericUtils gu=null;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;

	}

	By signIn =By.xpath("//a[contains(text(),'Sign in')]");
	By username=By.xpath("//input[@id='email_create']");
	By createaccount=By.xpath("//button[@id='SubmitCreate']");
	By existingusername=By.xpath("//input[@id='email']");
	By existinguserpassword=By.xpath("//input[@id='passwd']");
	By signInbutton=By.xpath("//button[@id='SubmitLogin']");

	public WebDriver signInpage() {
		
		/*
		 * String path = System.getProperty("user.dir");
		 * System.setProperty("webdriver.chrome.driver", path
		 * +"/src/test/resources/drivers/chromedriver.exe"); driver = new
		 * ChromeDriver();
		 */
		 
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("--incognito");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		gu=new GenericUtils(driver);
		return driver;
	}
	
	public void verifyLoginPage() {
		String expectedTitle="My Store";
		String actualTitle=driver.getTitle();
		assertEquals("Title does not match", expectedTitle, actualTitle);
	}
	
	public void clickOnSignInButton() {
		gu.elementClick(signIn);
	}

	public void enterEmailAddress(String emailaddress) {
		gu.elementText(username,emailaddress);
	}

	public void clickOnCreateAnAccountButton() {
		gu.elementClick(createaccount);
	}

	public void loginExistingUser(String emailaddress) {
		gu.elementText(existingusername, emailaddress);	
	}
	
	public void passwordForExistingUser(String password) {
		gu.elementText(existinguserpassword, password);
	}
	
	public void clickOnSignInExistingUser() {
		gu.elementClick(signInbutton);
	}
	
	
}
