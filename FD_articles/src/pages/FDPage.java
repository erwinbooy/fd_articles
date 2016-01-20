package pages;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import automationFramework.AbstractPage;

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
	public List<String> getAllArticleUrlsFromPage() {
		ArrayList<String> myArticles = new ArrayList<>();

		// Get all the articleUrls from the page and put them in the array
		for (int i = 1; i < 20; i++) {
			myArticles.add(getArticleUrl(i));
		}
		return myArticles;
	}

	/**
	 * Get the url of the Article Note that there are 20 Articles on the page so
	 * the max is 20!
	 * 
	 * @return String with all articleUrls
	 */
	public String getArticleUrl(int articleNbr) {
		// We don't have to use the wait here because this method is only called after
		// the page initialization
		return driver.findElement(By.xpath(xArticle + "[" + articleNbr + "]" + xArticleLink)).getAttribute("href");
	}

	/**
	 * Get the Article of the Text
	 * 
	 * @return String with the full page source of the article
	 */
	public String getArticleText() {
		String source = driver.getPageSource();
		String decodedSource = null;
		try{
			decodedSource = URLDecoder.decode(source, "UTF-8");
		} catch (Exception e){
			logger.error("Problems when trying to encode the source: " + e.toString());
			// If we can't decode it we just return the original source
			decodedSource = source;
		}
		return source;
	}

	/**
	 * Get the Title of the article
	 * 
	 * @return String with the title of the article (FD defined)
	 */
	public String getArticleTitle() {
		// We don't have to use the wait method here because we only call this
		// method after the getText and that one already waits
		return driver.findElement(By.xpath(xArticle + xArticleTitle)).getText();
	}

	/**
	 * Get the Date of the article
	 * 
	 * @return String with the date of the article
	 */
	public String getArticleDate() {
		// We don't have to use the wait method here because we only call this
		// method after the getText and that one already waits
		return driver.findElement(By.xpath(xArticle + xArticleDate)).getText();
	}
}
