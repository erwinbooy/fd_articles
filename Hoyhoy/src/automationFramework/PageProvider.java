package automationFramework;

import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.health.CoveragesPage;
import pages.health.LandingPage;

public class PageProvider{

	private static WebDriver driver = null;
	
	/**
	 * @param WebDriver driver
	 * 
	 * We need this method to have the driver which we can use for the pages
	 */
	public static void initialize(WebDriver driver){
		PageProvider.driver = driver;
	}

	public static LandingPage getLandingPage(){
		return new LandingPage(driver);
	}
	
	public static HomePage getHomePage(){
		return new HomePage(driver);
	}
	
	public static CoveragesPage getCoveragePage(){
		return new CoveragesPage(driver);
	}
	
}
