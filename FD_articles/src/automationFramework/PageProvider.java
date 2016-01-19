package automationFramework;

import org.openqa.selenium.WebDriver;

import pages.FDPage;
import pages.GoogleSearchPage;

public class PageProvider {

	private static WebDriver driver = null;

	/**
	 * @param WebDriver
	 * @param WebDriverWait
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
