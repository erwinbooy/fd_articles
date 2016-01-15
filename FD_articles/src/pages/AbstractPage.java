package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Erwin
 *
 *         Abstract class that performs the standard stuff that a Page needs It
 *         implements the HoyhoyPage interface
 */
public abstract class AbstractPage {

	public WebDriver driver = null;
	public WebDriverWait wait = null;

	/**
	 * Constructor with WebDriver
	 * 
	 * @param driver
	 */
	public AbstractPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	/**
	 * This method will be a safe method to get an element because it always waits for it
	 * to be clickable
	 * @param myXPath
	 * @return
	 */
	public WebElement getClickableElementByXPath(String myXPath){
		return wait.until(ExpectedConditions.elementToBeClickable((By.xpath(myXPath))));
	}
	
	/**
	 * This method will be a safe method to check if an element is present on the page
	 * @param myXPath
	 * @return
	 */
	public WebElement waitForElementPresent(String myXPath){
		return wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(myXPath))));
	}
}
