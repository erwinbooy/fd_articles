package tests;

import java.sql.Driver;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import automationFramework.PageProvider;
import automationFramework.TestBase;
import pages.FDPage;
import pages.GoogleSearchPage;
import utils.Article;
import utils.ArticleWriter;

public class GetArticleFromFD extends TestBase {

	/**
	 * Get the Article Url from FD
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void test() throws InterruptedException {

		// Define the Articles
		List<Article> myArticles = null;

		// First we go to the Financieel Dagblad page where we get a url's from the
		// Articles
		FDPage fdPage = PageProvider.getFinancieelDagbladPage();
		fdPage.OpenPage();
		myArticles = fdPage.getAllArticleUrlsFromPage();

		// Now we have the Urls we can use it to search on Google
		GoogleSearchPage googlePage = PageProvider.getGoogleSearchPage();

		// Loop through all articles and find them in google and write them to a file
		// Since google only allows 5 free articles we have to clear our cookies to start fresh again
		Iterator<Article> iter = myArticles.iterator();
		int counter = 0;
		while(iter.hasNext()){
			Article a = iter.next();
			googlePage.openPage();
			googlePage.searchGoogle(a.getArticleUrl());
			googlePage.clickFirstResult();
			a.setArticleText(fdPage.getArticleText());
			a.setArticleTitle(fdPage.getArticleTitle());
			ArticleWriter.writeArticle(a);
			counter++;
			if (counter==5){
				googlePage.driver.manage().deleteAllCookies();
				counter = 0;
			}
		}
	}
}
