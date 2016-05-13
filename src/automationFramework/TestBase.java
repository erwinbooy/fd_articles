package automationFramework;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import junit.framework.TestCase;

public abstract class TestBase extends TestCase {

	private InternetExplorerDriver myDriver;
	public Logger logger = null;


	/**
	 * setUp method which is used by the Test framework
	 */
	public void setUp() {
		System.setProperty("webdriver.ie.driver", "C:/Users/Erwin/AppData/Local/Microsoft/Internet Explorer/IEDriverServer.exe");
		try{
			myDriver = new InternetExplorerDriver();
		} catch (Exception e){
			logger.error(e);
		}
		myDriver.manage().window().maximize();
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
