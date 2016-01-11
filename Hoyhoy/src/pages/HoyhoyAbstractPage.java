package pages;

import org.openqa.selenium.WebDriver;

/**
 * @author Erwin
 *
 * Abstract class that performs the standard stuff that a Page needs
 * It implements the HoyhoyPage interface
 */
public abstract class HoyhoyAbstractPage{
	
	public WebDriver driver = null;
	
	/**
	 * Constructor with WebDriver
	 * @param driver
	 */
	public HoyhoyAbstractPage(WebDriver driver){
		this.driver = driver;
	}
}
