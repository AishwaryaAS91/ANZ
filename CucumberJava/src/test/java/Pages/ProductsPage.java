package Pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.GenericUtils;

public class ProductsPage {

	WebDriver driver=null;
	GenericUtils gu=null;

	public ProductsPage(WebDriver driver)
	{
		this.driver = driver;
		gu=new GenericUtils(driver);

	}

	By dress=By.xpath("(//a[text()='Dresses'])[2]");
	By inStock = By.xpath("(//div[h5[a[@class='product-name' and contains(text(),'Printed Dress')]]])[1]");
	By clickOnMore=By.xpath("(//div[h5[a[@class='product-name' and contains(text(),'Printed Dress')]]]//span[text()='More'])[1]");
	By quantityOfDress=By.xpath("//input[@id='quantity_wanted']");
	By sizeOfDress=By.xpath("//select[@id='group_1']");
	By nameOfDress=By.xpath("//h1[contains(text(),'Dress')]");
	By skuOfDress=By.xpath("//span[contains(text(),'demo')]");
	By addToCart=By.xpath("//span[text()='Add to cart']");
	By proceedToCheckoutButton=By.xpath("//span[contains(text(),'checkout')]");
	By summaryCheckout=By.xpath("(//span[contains(text(),'checkout')])[2]");
	By termsOfServiceCheckbox=By.xpath("//span[input[@id='cgv' and @type = 'checkbox']]");
	By paymentTab=By.xpath("//span[text()=' Payment']");
	By productInPaymentPage=By.xpath("(//a[contains(text(),'Printed')])[2]");
	By skuInPayment=By.xpath("//small[contains(text(),'demo')]");
	By colorSizeOfProduct=By.xpath("//a[contains(text(),'Size ')]");

	public void clickOnDresses() {
		gu.elementScrollClick(dress);
	}

	public void clickOnMore() {
		gu.elementClick(inStock);
		gu.elementClick(clickOnMore);
	}

	public void enterQuantity(String quantity) {
		gu.elementText(quantityOfDress, quantity);
	}

	public void selectSize(String size) {
		gu.elementScroll(sizeOfDress);
		gu.elementClick(sizeOfDress);
		gu.selectFromList(sizeOfDress, size);
	}

	public void clickOnAddToCartButton() {
		gu.elementClick(addToCart);
	}

	public void clickOnProceedToCheckoutButton() {
		gu.elementClick(proceedToCheckoutButton);
	}

	public void clickOnSummaryCheckout() {
		gu.elementClick(summaryCheckout);
	}

	public void clickOnTermsOnServiceButton() {
		gu.elementScroll(termsOfServiceCheckbox);
		gu.elementClick(termsOfServiceCheckbox);
		gu.elementClick(summaryCheckout);
	}

	public String[] getProductBeforeAddToCart() {
		String[] product= new String[2];
		product[0]=gu.findElement(nameOfDress).getText();
		product[1]=gu.findElement(skuOfDress).getText();
		return product;
	}

	public void verifyProductInPayment(String[] product) {
		String paymentDressName=gu.findElement(productInPaymentPage).getText();
		System.out.println("Test"+gu.findElement(skuInPayment).getText());
		String paymentSkuName =gu.findElement(skuInPayment).getText().split(":")[1].replace(" ","");
		
		assertEquals("Dressname does not match", product[0], paymentDressName);
		assertEquals("SKU does not match", product[1], paymentSkuName);
	}

}
