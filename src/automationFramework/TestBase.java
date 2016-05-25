package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import junit.framework.TestCase;

public abstract class TestBase extends TestCase {

	private HtmlUnitDriver myDriver;

	/**
	 * setUp method which is used by the Test framework
	 */
	public void setUp() {
		myDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_24);
		myDriver.manage().window().maximize();
		//myDriver.setJavascriptEnabled(true);
		PageProvider.initialize(myDriver);
	}

	/**
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
