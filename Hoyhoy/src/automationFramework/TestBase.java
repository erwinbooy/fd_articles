package automationFramework;

import junit.framework.TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class TestBase extends TestCase{
	
	private WebDriver myDriver;
//	private HtmlUnitDriver myDriver;
	
	/**
	 * @param String myUrl
	 * @throws Exception
	 */
	public void setUp(){
		myDriver = new FirefoxDriver();
//		myDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_24);
//		myDriver.setJavascriptEnabled(true);
		myDriver.manage().window().maximize();
		myDriver.get("http://www.hoyhoy.nl");
		try{
			Thread.sleep(3000);
		} catch (Exception e){
			// do nothing
		}
		// wait for the page to show
		PageProvider.initialize(myDriver);
	}
	
	/**
	 * Get the WebDriver
	 * @return WebDriver
	 */
	public WebDriver getDriver(){
		return myDriver;
	}
	
	/**
	 * Always make sure we close the driver at the end of the test
	 */
	public void tearDown() throws Exception{
		myDriver.quit();
	}
	
}
