package automationFramework;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	public Log logger = null;

	/**
	 * Constructor with WebDriver
	 * 
	 * @param driver
	 */
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		//this.wait = new WebDriverWait(driver, 5, 1);
		logger = LogFactory.getLog(this.getClass());
	}

	/**
	 * This method will be a safe method to get an element because it always
	 * waits for it to be clickable
	 * 
	 * @param myXPath
	 * @return
	 */
	public WebElement waitForElementIsClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable((locator)));
	}

	/**
	 * This method will be a safe method to check if an element is present on
	 * the page
	 * 
	 * @param myXPath
	 * @return
	 */
	public WebElement waitForElementPresent(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated((locator)));
	}
}
