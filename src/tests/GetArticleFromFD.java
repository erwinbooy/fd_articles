package tests;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import automationFramework.PageProvider;
import automationFramework.TestBase;
import pages.FDPage;
import pages.GoogleSearchPage;
import utils.Article;
import utils.ArticleDAO;

public class GetArticleFromFD extends TestBase {
	
	private List<String> dbArticles = null;
	private ArticleDAO articleDao = new ArticleDAO();
	Log logger = null;

	/**
	 * Get the Articles from FD
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void test() throws InterruptedException {
		
		logger = LogFactory.getLog(this.getClass());
		//showMessage("The program will start running now. It might take a while to scan FD for new articles");
		
		// Get all the current Articles from our database
		dbArticles = articleDao.getAllArticlesFromDatabase();
		List<String> myArticleUrls = null;

		// Go to the FD page and get all article Urls
		FDPage fdPage = PageProvider.getFinancieelDagbladPage();
		fdPage.OpenPage();
		myArticleUrls = fdPage.getAllArticleUrlsFromPage();

		// Open the google search page
		GoogleSearchPage googlePage = PageProvider.getGoogleSearchPage();

		// Loop through all articles and find them in google and write them to a
		Iterator<String> iter = myArticleUrls.iterator();
		int newArticleCounter = 0;
		while (iter.hasNext()) {
			String articleUrl = iter.next();
			// We first check if the article already exists. 
			// Too many double searches on Google caused a block of the ip so
			// We only want to search and store the articles once
			// 
			// But we always want to get the first article because that shows the updated articles
			// So we always make sure we have the latest update of that article
			if (newArticleCounter==0 || !articleExistsInDB(articleUrl)){
				
				// We don't have the article yet so we are going to search for it on Google
				googlePage.openPage();
				googlePage.searchGoogle(articleUrl);
				
				newArticleCounter++;
				try{
					googlePage.clickFirstResult();
					// Create the article, fill it and write it to file
					Article a = new Article();
					a.setArticleUrl(articleUrl);
					a.setArticleText(fdPage.getArticleText());
					
					// When we write the article we have to remove some possible characters which are not allowed by Windows in file names
					String myTitle = fdPage.getArticleTitle();
					myTitle = myTitle.replace(":", " ");
					myTitle = myTitle.replace("?", " ");
					myTitle = myTitle.replace("%", " ");
					myTitle = myTitle.replace("'", " ");
					myTitle = myTitle.replace(",", " ");
					myTitle = myTitle.replace(".", " ");
					a.setArticleTitle(myTitle);

					// Now we see if we can get the article
					try{
						// We only write it to the Database when we really have a new article
						if (!articleExistsInDB(a.getArticleUrl())){
							articleDao.writeArticle(a);
						}
						openFile(a.getArticleTitle());
						
						Set<Cookie> myCookies = googlePage.driver.manage().getCookies();
						Iterator<Cookie> c = myCookies.iterator();
						while (c.hasNext()){
							Cookie cookie = c.next();
							// We want to delete most cookies but not the cookieconsent one
							if(cookie.getName().equals("cookieconsent")){
								googlePage.driver.manage().deleteAllCookies();
								googlePage.driver.manage().addCookie(cookie);
								break;
							}
							//logger.error(cookie.getDomain() + " with name " + cookie.getName());
						}
					} catch (Exception f){
//						showMessage("An unexpected error occurred !! Error is : " + f.toString());
						logger.error(fdPage.driver.getPageSource());
					}
				} catch (Exception e){
//					showMessage("An unexpected error occurred !! Error is : " + e.toString());
					logger.error(googlePage.driver.getPageSource());
				}
			}
		}
		showMessage("The program ended and found : " + newArticleCounter + " new or updated articles. You can view these articles in the folder :" + articleDao.getArticleDirectory());
	}
    
    private void openFile(String myFileName) throws Exception {
    	String articleDir = articleDao.getArticleDirectory();
        File articleFile = new File(articleDir + myFileName + ".html");
        Desktop.getDesktop().open(articleFile);
    }
	
	/**
	 * This method will show a window about some progress
	 * This is useful as we are running headless
	 * @param myMessaage
	 */
	private void showMessage(String myMessage){
		JFrame frame = new JFrame("Program Update");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel(myMessage);
		frame.getContentPane().add(label, BorderLayout.CENTER);
		JOptionPane.showMessageDialog(frame, myMessage);
	}
	
	/**
	 * Method to check if the article already exists in the DB
	 * Currently we use the Url of the article because that never changes
	 */
	private boolean articleExistsInDB(String articleName){
		if (dbArticles.indexOf(articleName) >= 0){
			// The article exists
			return true;
		}
		return false;
	}
}
