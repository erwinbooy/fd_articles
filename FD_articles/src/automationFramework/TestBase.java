package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

public abstract class TestBase extends TestCase {

	private WebDriver myDriver;
	private WebDriverWait waiter;
	// private HtmlUnitDriver myDriver;

	/**
	 * @param String
	 *            myUrl
	 * @throws Exception
	 */
	public void setUp() {
		myDriver = new FirefoxDriver();
		// myDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_24);
		// myDriver.setJavascriptEnabled(true);
		myDriver.manage().window().maximize();
		waiter = new WebDriverWait(myDriver, 10000);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// do nothing
		}
		// wait for the page to show
		PageProvider.initialize(myDriver, waiter);
	}

	/**
	 * Get the WebDriver
	 * 
	 * @return WebDriver
	 */
	public WebDriver getDriver() {
		return myDriver;
	}

	/**
	 * Return the waiter that can be used for the pages
	 * 
	 * @return
	 */
	public WebDriverWait getWaiter() {
		return waiter;
	}

	/**
	 * Always make sure we close the driver at the end of the test
	 */
	public void tearDown() throws Exception {
		myDriver.quit();
	}

}
