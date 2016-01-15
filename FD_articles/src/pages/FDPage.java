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
	private String xArticleText = "//div[contains(@class,'body')]";
	private String xArticleTitle = "//h1";

	/**
	 * Constructor from the Abstract Class
	 * 
	 * @param driver
	 * @param wait
	 */
	public FDPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
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
		WebElement myElement = waitForElementPresent(xArticle + "[" + articleNbr + "]" + xArticleLink);
		String myArticleUrl = myElement.getAttribute("href");
		return myArticleUrl;
	}

	/**
	 * Get the Article of the Text
	 * 
	 * @return
	 */
	public String getArticleText() {
		WebElement myElement = waitForElementPresent(xArticle);
		String myText = myElement.getAttribute("innerHTML");
		return myText;
	}

	/**
	 * Get the Title of the article
	 * 
	 * @return
	 */
	public String getArticleTitle() {
		WebElement myElement = driver.findElement(By.xpath(xArticle + xArticleTitle));
		String myText = myElement.getText();
		return myText;
	}

}
