package tests;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import automationFramework.PageProvider;
import automationFramework.TestBase;
import pages.FDPage;
import pages.GoogleSearchPage;
import utils.Article;
import utils.ArticleDatabase;
import utils.ArticleWriter;

public class GetArticleFromFD extends TestBase {
	
	private List<String> dbArticles = null;
	Log logger = null;

	/**
	 * Get the Articles from FD
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void test() throws InterruptedException {

		logger = LogFactory.getLog(this.getClass());
		
		// Get all the current Articles from our database
		dbArticles = ArticleDatabase.getAllArticlesFromDatabase();
		// Define our article array
		List<String> myArticleUrls = null;

		// First we go to the Financieel Dagblad page where we get a url's from
		// the
		// Articles
		FDPage fdPage = PageProvider.getFinancieelDagbladPage();
		fdPage.OpenPage();
		myArticleUrls = fdPage.getAllArticleUrlsFromPage();

		// Now we have the Urls we can use it to search on Google
		GoogleSearchPage googlePage = PageProvider.getGoogleSearchPage();

		// Loop through all articles and find them in google and write them to a
		// file
		// Since google only allows 5 free articles we have to clear our cookies
		// to start fresh again
		Iterator<String> iter = myArticleUrls.iterator();
		int counter = 0;
		while (iter.hasNext()) {
			String articleUrl = iter.next();
			// We first check if the article already exists. If so we don't go to Google
			if (!articleExistsInDB(articleUrl)){
				logger.info("New article found: " + articleUrl);
				// We don't have the article yet so we are going to search for it on Google
				googlePage.openPage();
				googlePage.searchGoogle(articleUrl);
				try{
					googlePage.clickFirstResult();
					// Create the article, fill it and write it to file
					Article a = new Article();
					a.setArticleUrl(articleUrl);
					a.setArticleText(fdPage.getArticleText());
					a.setArticleTitle(fdPage.getArticleTitle().replace(":", ""));
					ArticleWriter.writeArticle(a);
					
					counter++;
					if (counter == 5) {
						//googlePage.driver.manage().deleteAllCookies();
						counter = 0;
					}
				} catch (Exception e){
					logger.error(e);
				}
			}
		}
	}
	
	/**
	 * Method to check if the article already exists in the DB
	 * Currently we use the Url of the article because that never changes
	 */
	private boolean articleExistsInDB(String articleName){
		boolean exists = false;
		if (dbArticles.indexOf(articleName) >= 0){
			// The article exists so we don't search for this one again
			//logger.info("Article already in DB so we skip it: " + articleName);
			return true;
		}
		return exists;
	}
}
