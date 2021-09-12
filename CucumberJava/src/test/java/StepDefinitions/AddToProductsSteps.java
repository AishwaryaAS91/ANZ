package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.ProductsPage;
import Utils.GenericUtils;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class AddToProductsSteps {

	WebDriver driver;
	GenericUtils gu;
	LoginPage login;
	LogoutPage logout;
	ProductsPage prodpage;
	String[] getproduct;

	
	@Given("^User is logged into My Store (.*) (.*)$")
	public void user_is_logged_into_my_store(String emailaddress,String password) {
		login=new LoginPage(driver);
		driver =login.signInpage();
		login.verifyLoginPage();
		login.clickOnSignInButton();
		login.loginExistingUser(emailaddress);
		login.passwordForExistingUser(password);
		login.clickOnSignInExistingUser();
		
	}

	@When("user clicks on Dresses tab")
	public void user_clicks_on_dresses_tab() {
		prodpage=new ProductsPage(driver);
		prodpage.clickOnDresses();
	}

	@And("clicks on More button on product")
	public void clicks_on_More_button_on_product() {
		prodpage.clickOnMore();			   
	}

	@And("^selects the product by providing (.*) (.*)$")
	public void selects_the_product_by_providing_quantity_size(String quantity,String size) {
		prodpage.enterQuantity(quantity);
		//		prodpage.selectSize(size);
	}

	@And("clicks on Add to Cart button")
	public void clicks_on_add_to_cart_button() {
		getproduct=prodpage.getProductBeforeAddToCart();
		prodpage.clickOnAddToCartButton();
	}

	@And("clicks on Proceed to Checkout button")
	public void clicks_on_proceed_to_checkout_button() {
		prodpage.clickOnProceedToCheckoutButton();
		prodpage.clickOnSummaryCheckout();
		prodpage.clickOnSummaryCheckout();
	}

	@And("clicks on Agree to Terms of Service")
	public void clicks_on_agree_to_terms_of_service() {
		prodpage.clickOnTermsOnServiceButton();
	}

	@Then("product is verified in Payment page")
	public void product_is_verified_in_payment_page() {
		prodpage.verifyProductInPayment(getproduct);	
		logout=new LogoutPage(driver);
		logout.signOut(); 
	}

}


