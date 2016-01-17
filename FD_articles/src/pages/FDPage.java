package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationFramework.AbstractPage;
import utils.Article;

public class FDPage extends AbstractPage {

	private String myPageUrl = "http://fd.nl/beurs";
	private String xArticle = "//article";
	private String xArticleLink = "/a";
	private String xArticleTitle = "//h1";
	private String xArticleDate = "//time";

	/**
	 * Constructor from the Abstract Class
	 * 
	 * @param driver
	 * @param wait
	 */
	public FDPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Open our page
	 */
	public void OpenPage() {
		driver.get(myPageUrl);
	}

	/**
	 * Method to get all the 20 articles Urls from the page
	 * 
	 * @return
	 */
	public List<Article> getAllArticleUrlsFromPage() {
		// Define our arraylist where we will store everything
		ArrayList<Article> myArticles = new ArrayList<>();

		// Get the latest 5 articles and put them in the array
		for (int i = 1; i < 19; i++) {
			Article a = new Article();
			a.setArticleUrl(getArticleUrl(i));
			myArticles.add(a);
		}

		return myArticles;
	}

	/**
	 * Get the url of the Article Note that there are 20 Articles on the page so
	 * the max is 20!
	 * 
	 * @return
	 */
	public String getArticleUrl(int articleNbr) {
		// Get the first article
		logger.info("Trying to find the Article URL from the page");
		String myArticleUrl = driver.findElement(By.xpath(xArticle + "[" + articleNbr + "]" + xArticleLink)).getAttribute("href");
		logger.info("Got the Article URL from the page: " + myArticleUrl);
		return myArticleUrl;
	}

	/**
	 * Get the Article of the Text
	 * 
	 * @return
	 */
	public String getArticleText() {
		logger.info("Trying to find the Article Text on the page");
		WebElement myElement = waitForElementPresent(By.xpath(xArticle));
		logger.info("Found the Article text on the page");
		String myText = myElement.getAttribute("innerHTML");
		logger.info("Got the Article Text now");
		return myText;
	}

	/**
	 * Get the Title of the article
	 * 
	 * @return
	 */
	public String getArticleTitle() {
		logger.info("Trying to find the Article Title on the page");
		String myTitle = driver.findElement(By.xpath(xArticle + xArticleTitle)).getText();
		logger.info("Got the Article Title now");
		return myTitle;
	}

	/**
	 * Get the Date of the article
	 * 
	 * @return
	 */
	public String getArticleDate() {
		logger.info("Trying to find the Article Date on the page");
		WebElement myElement = driver.findElement(By.xpath(xArticle + xArticleDate));
		logger.info("Found the Article Date on the page");
		String myDate = myElement.getText();
		logger.info("Got the Article Date : " + myDate);
		return myDate;
	}
}
