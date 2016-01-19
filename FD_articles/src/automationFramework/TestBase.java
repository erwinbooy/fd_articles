package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.TestCase;

public abstract class TestBase extends TestCase {

	private WebDriver myDriver;

	/**
	 * @param String
	 *            myUrl
	 * @throws Exception
	 */
	public void setUp() {
		myDriver = new FirefoxDriver();
		///myDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_38);
		// myDriver.setJavascriptEnabled(true);
		myDriver.manage().window().maximize();
		// wait for the page to show
		PageProvider.initialize(myDriver);
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
	 * Always make sure we close the driver at the end of the test
	 */
	public void tearDown() throws Exception {
		myDriver.quit();
	}

}
