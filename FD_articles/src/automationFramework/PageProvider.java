package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.FDPage;
import pages.GoogleSearchPage;

public class PageProvider {

	private static WebDriver driver = null;
	private static WebDriverWait waiter = null;

	/**
	 * @param WebDriver
	 * @param WebDriverWait
	 *            We need this method to have the driver which we can use for
	 *            the pages The Waiter is just to make our life easier later
	 */
	public static void initialize(WebDriver driver) {
		PageProvider.driver = driver;
	}

	public static GoogleSearchPage getGoogleSearchPage() {
		return new GoogleSearchPage(driver);
	}

	public static FDPage getFinancieelDagbladPage() {
		return new FDPage(driver);
	}
}
