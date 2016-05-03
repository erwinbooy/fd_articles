package automationFramework;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.DeveloperPage;

/**
 * @author Erwin
 *
 *         Abstract class that performs the standard stuff that a Page needs It
 *         implements the HoyhoyPage interface
 */
public abstract class AbstractPage implements DeveloperPage{

	public WebDriver driver = null;
	public WebDriverWait wait = null;
	public Log logger = null;

	// These are the links from the Header which are used by all the other pages
	public static String link_signin = "//li[@class='first sign-in']/a";
	public static String link_register = "//li[@class='register']/a";
	public static String link_account = "//li[@class='account']/a";
	public static String link_dashboard = "//li[@class='dashboard toggle']/a";
	public static String link_signout = "//li[@class='last sign-out']/a";
	// These are the links from the Menu
	public static String menu_items = "//div[@id='local']";
	public static String menu_item_home = "/ul/li//a[contains(.,'Home')]";
	public static String menu_item_online_navigation = "/ul/li//a[contains(.,'Online Navigation')]";
	public static String menu_item_navigation_software = "/ul/li//a[contains(.,'Navigation Software')]";
	public static String menu_item_real_time_maps = "/ul/li//a[contains(.,'Real-Time Maps')]";
	public static String menu_item_bridge = "/ul/li//a[contains(.,'Bridge')]";
	public static String menu_item_sports = "/ul/li//a[contains(.,'Sports')]";
	
	// Text
	public static String text_signedin = "//li[@class='first status']";
	

	/**
	 * Constructor with WebDriver
	 * 
	 * @param driver
	 */
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5, 1);
		logger = LogFactory.getLog(this.getClass());
	}

	/**
	 * This method can be used to check if something exists on the page
	 * If it exists the WebElement will be returned
	 * 
	 * @param myXPath
	 * @return WebElement
	 */
	public WebElement findElementOnPage(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * This method will be a safe method to get an element because it always
	 * waits for it to be clickable
	 * 
	 * @param myXPath
	 * @return WebElement
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

	/**
	 * Can be used for debugging problems. This returns the html that is being used currently
	 */
	public String getPageHtml(){
		return driver.getPageSource();
	}

	/**
	 * Return the text when a user is signed in
	 * @return text
	 */
	public String getSignInText(){
		try{
			WebElement si = waitForElementPresent(By.xpath(text_signedin));
			return si.getText();
		} catch (Exception ex){
			return "Couldn't find the Signed in text";
		}
	}
	
	/**
	 * Return the text of the Sign out element
	 * @return text
	 */
	public String getSignOutText(){
		try{
			WebElement so = waitForElementPresent(By.xpath(link_signout));
			return so.getText();
		} catch (Exception ex){
			return "Couldn't find the Sign Out link";
		}
	}

	/**
	 * Checks if there is an account link on the page
	 * @return
	 */
	public boolean hasAccountLink(){
		try{
			findElementOnPage(By.xpath(link_account));
			return true;
		} catch (Exception ex){
			return false;
		}
	}

	/**
	 * Checks if there is a dashboard link on the page
	 * @return
	 */
	public boolean hasDashboardLink(){
		try{
			findElementOnPage(By.xpath(link_dashboard));
			return true;
		} catch (Exception ex){
			return false;
		}
	}

	/**
	 * Checks if there is a the Menu Item Home
	 * @return
	 */
	public boolean hasMenuItemHome(){
		try{
			findElementOnPage(By.xpath(menu_items+menu_item_home));
			return true;
		} catch (Exception ex){
			return false;
		}
	}

	/**
	 * Checks if there is a the Menu Item Online Navigation
	 * @return
	 */
	public boolean hasMenuItemOnlineNavigation(){
		try{
			findElementOnPage(By.xpath(menu_items+menu_item_online_navigation));
			return true;
		} catch (Exception ex){
			return false;
		}
	}

	/**
	 * Checks if there is a the Menu Item Navigation Software
	 * @return
	 */
	public boolean hasMenuItemNavigationSoftware(){
		try{
			findElementOnPage(By.xpath(menu_items+menu_item_navigation_software));
			return true;
		} catch (Exception ex){
			return false;
		}
	}

	/**
	 * Checks if there is a the Menu Item Real-Time Maps
	 * @return
	 */
	public boolean hasMenuItemRealTimeMaps(){
		try{
			findElementOnPage(By.xpath(menu_items+menu_item_real_time_maps));
			return true;
		} catch (Exception ex){
			return false;
		}
	}

	/**
	 * Checks if there is a the Menu Item Bridge
	 * @return
	 */
	public boolean hasMenuItemBridge(){
		try{
			findElementOnPage(By.xpath(menu_items+menu_item_bridge));
			return true;
		} catch (Exception ex){
			return false;
		}
	}

	/**
	 * Checks if there is a the Menu Item Sports
	 * @return
	 */
	public boolean hasMenuItemSports(){
		try{
			findElementOnPage(By.xpath(menu_items+menu_item_sports));
			return true;
		} catch (Exception ex){
			return false;
		}
	}

	/**
	 * Click on the home menu item
	 */
	public void clickMenuItemHome(){
		// First we wait for the page to have been built
		waitForElementIsClickable(By.xpath(menu_items + menu_item_home)).click();
	}
	
	/**
	 * Click on the Online Navigation menu item
	 */
	public void clickMenuItemOnlineNavigation(){
		// First we wait for the page to have been built
		waitForElementIsClickable(By.xpath(menu_items + menu_item_online_navigation)).click();
	}
	
	/**
	 * Click on the home menu item
	 */
	public void clickMenuItemNavigationSoftware(){
		// First we wait for the page to have been built
		waitForElementIsClickable(By.xpath(menu_items + menu_item_navigation_software)).click();
	}
	
	/**
	 * Click on the Real Time Maps menu item
	 */
	public void clickMenuItemRealTimeMaps(){
		// First we wait for the page to have been built
		waitForElementIsClickable(By.xpath(menu_items + menu_item_real_time_maps)).click();
	}
	
	/**
	 * Click on the Bridge menu item
	 */
	public void clickMenuItemBridge(){
		// First we wait for the page to have been built
		waitForElementIsClickable(By.xpath(menu_items + menu_item_bridge)).click();
	}
	
	/**
	 * Click on the Sports menu item
	 */
	public void clickMenuItemSports(){
		// First we wait for the page to have been built
		waitForElementIsClickable(By.xpath(menu_items + menu_item_sports)).click();
	}
}
