package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automationFramework.AbstractPage;

public class DeveloperHomePage extends AbstractPage {

	// Url
	private static String myPageUrl = "http://developer.tomtom.com/";

	/**
	 * Constructor from the Abstract Class
	 * 
	 * @param driver
	 */
	public DeveloperHomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Open our page
	 */
	public void OpenPage() {
		driver.get(myPageUrl);
	}

	/**
	 * Click on the link Sign In
	 */
	public void clickSignIn(){
		// First we wait for the page to have been built
		waitForElementIsClickable(By.xpath(link_signin)).click();
	}

	/**
	 * Click on the link Sign In
	 */
	public void clickSignOut(){
		// First we wait for the page to have been built
		waitForElementIsClickable(By.xpath(link_signout)).click();
	}
}
