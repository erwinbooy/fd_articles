package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationFramework.AbstractPage;
import users.DeveloperUser;

public class LoginPage extends AbstractPage {

	//private String myPageUrl = "https://secure.mashery.com/login/developer.tomtom.com/";
	private static String field_userid = "handle";
	private static String field_userpwd = "passwd";
	private static String button_signin = "process-login";

	/**
	 * Constructor from the Abstract Class
	 * 
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Enter user credentials and click SignIn
	 */
	public void signIn(DeveloperUser user){
		// First we wait for the page to have been built
		waitForElementPresent(By.id("handle"));
		WebElement userName = findElementOnPage(By.id(field_userid));
		userName.sendKeys(user.getUserid());
		WebElement userPwd = findElementOnPage(By.id(field_userpwd));
		userPwd.sendKeys(user.getUserpwd());
		// Now press the Sign in button
		WebElement signInButton = findElementOnPage(By.id(button_signin));
		signInButton.click();
	}
}
