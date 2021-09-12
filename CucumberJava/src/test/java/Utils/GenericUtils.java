package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {

	WebDriver driver;
	WebDriverWait wait; 
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,30);

	}
	public WebElement findElement(By locator)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
		//wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement wb=driver.findElement(locator);
		return wb;
	}

	public void elementScroll(By locator)
	{
		WebElement wb=findElement(locator);
		//wait.until(ExpectedConditions.elementToBeClickable(wb));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].scrollIntoView(true);", wb);
	   // executor. executeScript("arguments[0]. click();", wb);
	}

	public void elementScrollClick(By locator)
	{
		WebElement wb=findElement(locator);
		//wait.until(ExpectedConditions.elementToBeClickable(wb));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].scrollIntoView(true);", wb);
	    executor. executeScript("arguments[0]. click();", wb);
	}
	
	public void elementClick(By locator)
	{
		WebElement wb=findElement(locator);
		wait.until(ExpectedConditions.elementToBeClickable(wb));
		wb.click();
	}

	public void elementText(By locator,String text)
	{
		WebElement wb=findElement(locator);
		wb.clear();
		wb.sendKeys(text);
	}

	public void selectFromList(By locator,String listelement)
	{
		WebElement wb=findElement(locator);
		Select sel=new Select(wb);
		sel.selectByVisibleText(listelement);
	}
	
}


