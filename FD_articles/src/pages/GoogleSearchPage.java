package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationFramework.AbstractPage;

public class GoogleSearchPage extends AbstractPage {

	private static String myUrl = "https://www.google.nl";

	public GoogleSearchPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	/**
	 * This method will open the Health funnel
	 */
	public void openPage() {
		driver.get(myUrl);
	}

	// This method will use the input string and search Google
	public void searchGoogle(String searchQuery) {
		WebElement googleSearchBox = waitForElementPresent(By.id("lst-ib"));
		googleSearchBox.sendKeys(searchQuery);
		WebElement googleSearchButton = driver.findElement(By.id("sblsbb"));
		googleSearchButton.submit();
	}

	public void clickFirstResult() {
		// We have to make sure the element is on the pagew
		WebElement firstResult = waitForElementPresent(By.xpath("//h3/a"));
		//String myText = firstResult.getText();
		firstResult.click();
	}

}
