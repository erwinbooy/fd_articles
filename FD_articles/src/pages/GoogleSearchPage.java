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

	// This method will use the input string and search Google
	public void searchGoogle(String searchQuery) {
		//logger.info("Find the google search box");
		waitForElementPresent(By.name("btnG"));
		
		driver.findElement(By.name("q")).sendKeys(searchQuery);
		//logger.info("Sent the search query to the box : " + searchQuery);
		
		try {
			driver.findElement(By.name("btnG")).submit();
		} catch (Exception e){
			logger.info("btnG was not found so lets try btnG");
		}
		//logger.info("Submitted the form");
	}

	/**
	 * This method will click on the first item in the google results
	 */
	public void clickFirstResult() throws Exception{
		
		try{
			WebElement e = waitForElementIsClickable(By.xpath("//h3/a[contains(@href,'fd.nl')]"));
			e.click();
			//driver.findElement(By.xpath("//h3/a")).click();
		} catch (Exception e){
			logger.info("Element //h3/a was not found so we try the Thumb");
			try{
				waitForElementIsClickable(By.xpath("//div[contains(@class,'thumb')]"));
				//driver.findElement(By.xpath("//div[contains(@class,'thumb')]")).click();
			} catch (Exception ex){
				logger.info("Element thumb was ALSO not found so something is really wrong!!");
			}
		}
	}
}
