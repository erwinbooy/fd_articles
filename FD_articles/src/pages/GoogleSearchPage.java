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
		waitForElementPresent(By.name("btnG"));
		// get the search box from the google page and send our search query
		driver.findElement(By.name("q")).sendKeys(searchQuery);
		
		try {
			driver.findElement(By.name("btnG")).submit();
		} catch (Exception e){
			logger.info("btnG was not found so lets try btnG");
		}
	}

	/**
	 * This method will click on the first item in the google results
	 * We do only click on results that are from the FD website
	 */
	public void clickFirstResult() throws Exception{
		try{
			WebElement e = waitForElementIsClickable(By.xpath("//h3/a[contains(@href,'fd.nl')]"));
			e.click();
		} catch (Exception e){
			logger.info("Element //h3/a was not found so we try the Thumb");
			// Sometimes google doesn't show a Url but a thumb.
			// So therefore we might have to use this but this is very rare
			try{
				waitForElementIsClickable(By.xpath("//div[contains(@class,'thumb')]"));
			} catch (Exception ex){
				logger.info("Element thumb was ALSO not found so something is really wrong!!");
			}
		}
	}
}
