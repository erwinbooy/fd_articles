package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationFramework.AbstractPage;
import utils.Article;
import utils.ArticleWriter;

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
		logger.info("Find the google search box");
		
		Article a = new Article();
		String test = driver.getPageSource();
		a.setArticleText(test);
		a.setArticleTitle("google_page");
		ArticleWriter.writeArticle(a);
		driver.findElement(By.name("q")).sendKeys(searchQuery);
		//WebElement googleSearchBox = waitForElementPresent(By.id("lst-ib"));
		logger.info("Found the google search box");
		//googleSearchBox.sendKeys(searchQuery);
		logger.info("Sent the search query to the box : " + searchQuery);
		driver.findElement(By.id("sblsbb")).submit();
		//WebElement googleSearchButton = driver.findElement(By.id("sblsbb"));
		//googleSearchButton.submit();
	}

	public void clickFirstResult() {
		// We have to make sure the element is on the pagew
		WebElement firstResult = waitForElementPresent(By.xpath("//h3/a"));
		//String myText = firstResult.getText();
		firstResult.click();
	}

}
