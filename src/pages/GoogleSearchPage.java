package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationFramework.AbstractPage;

public class GoogleSearchPage extends AbstractPage {

	private static String myUrl = "https://www.google.nl";

	public GoogleSearchPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * This method will open the Health funnel
	 */
	public void openPage() {
		driver.get(myUrl);
	}

	/**
	 * This method will perform a search on Google
	 * 
	 * @param searchQuery
	 */
	public void searchGoogle(String searchQuery) {
		// wait for the Button to show on the page
		WebElement button = waitForElementPresent(By.name("btnG"));
		// get the search box from the google page and send our search query
		driver.findElement(By.name("q")).sendKeys(searchQuery);
		try {
			button.click();
		} catch (Exception e){
			logger.error(driver.getPageSource());
			logger.error("btnG was also not found so something is really wrong");
		}
	}

	/**
	 * This method will click on the first item in the google results
	 * We do only click on results that are from the FD website
	 * The problem is that we get multiple search results sometimes so we have to take care of that
	 * Therefore there are a few try catch parts because we never know in advance how the page looks
	 */
	public void clickFirstResult() throws Exception{
		// First we wait for the page to have been built
		waitForElementPresent(By.xpath("//a[contains(.,'Voorwaarden')]"));
		
		WebElement we = null;
		// Then we check if there is a Thumb nail showing and click on it
		try{
			we = findElementOnPage(By.xpath("//img[contains(@class,'th')]"));
			we.click();
		} catch(Exception ex){
			// We assume that there is a H3 tag but this is not always the case
			try{
				// Obiously there was no thumbnail so lets just click on the link
				we = waitForElementIsClickable(By.xpath("//h3/a[contains(@href,'fd.nl')]"));
				we.click();
			} catch (Exception e){
				// Then lets hope for something else to lead us to the FD
				logger.error(getPageHtml());
				logger.error("GoogleSearch:: last try to get the link");
				we = waitForElementIsClickable(By.xpath("//div[contains(@class,'_I2')]//a[contains(@href,'fd.nl')]"));
				we.click();
			}
		}
	}
}
