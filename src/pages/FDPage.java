package pages;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import automationFramework.AbstractPage;

public class FDPage extends AbstractPage {

	private String myPageUrl = "http://fd.nl/beurs";
	private String xArticle = "//article";
	private String xArticleLink = "/a";
	private String xArticleTitle = "//h1";
	private String xArticleDate = "//time";
	private String xShareButton = "//span[@class='share-social as-button']";
	private String cookieId = "cookieconsent1";

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
		((HtmlUnitDriver)driver).setJavascriptEnabled(true);
		driver.get(myPageUrl);
		clickCookieMessage();
		((HtmlUnitDriver)driver).setJavascriptEnabled(false);
	}

	/**
	 * Method to get all the 20 articles Urls from the page
	 * 
	 * @return
	 */
	public List<String> getAllArticleUrlsFromPage() {
		ArrayList<String> myArticles = new ArrayList<String>();

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
		String articleUrl = "not found";
		try{
			articleUrl = driver.findElement(By.xpath(xArticle + "[" + articleNbr + "]" + xArticleLink)).getAttribute("href");
			logger.info("returning article url: " + articleUrl);
		} catch (Exception e){
			logger.info("couldn't find article url: " + e.toString());
			logger.error(driver.getPageSource());
		}
		return articleUrl;
	}

	/**
	 * Get the Article of the Text
	 * 
	 * @return String with the full page source of the article
	 */
	public String getArticleText() {
		// First make sure that the page is fully shown
		waitForElementIsClickable(By.xpath(xShareButton));
		String source = driver.getPageSource();
		String decodedSource = null;
		try{
			decodedSource = URLDecoder.decode(source, "UTF-8");
		} catch (Exception e){
			logger.warn("Problems when trying to encode the source: " + e.toString());
			// If we can't decode it we just return the original source
			decodedSource = source;
		}
		return decodedSource;
	}

	/**
	 * Get the Title of the article
	 * 
	 * @return String with the title of the article (FD defined)
	 */
	public String getArticleTitle() {
		// We don't have to use the wait method here because we only call this
		// method after the getText and that one already waits
		String e = "Title Not Found";
		try{
			e = driver.findElement(By.xpath(xArticle + xArticleTitle)).getText();
		} catch (Exception ex){
			// We couldn't find E which usually means the cookie message is showing
			clickCookieMessage();
			e = driver.findElement(By.xpath(xArticle + xArticleTitle)).getText();
		}
		return  e;
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
	
	/**
	 * When we don't have the cookie we have to accept it on the page
	 */
	public void clickCookieMessage(){
		try{
			// With UnitDriver we don't have JavaScript enabled so we have to execute it ourselves to remove this cookie message
			//((JavascriptExecutor) this.driver).executeAsyncScript("handleClick", "cookieconsent");
			driver.findElement(By.id(cookieId)).click();
		}catch (Exception e){
			// If the message is not there it doesn't matter and we just continue
			logger.warn("cookieId not found");
		}
	}
}
