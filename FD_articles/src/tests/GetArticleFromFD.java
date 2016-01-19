package tests;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import automationFramework.PageProvider;
import automationFramework.TestBase;
import pages.FDPage;
import pages.GoogleSearchPage;
import utils.Article;
import utils.ArticleDAO;

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
		showMessage(System.getProperty("user.dir"));
		
		logger = LogFactory.getLog(this.getClass());
		showMessage("The program will start running now. It might take a while to scan FD for new articles");
		
		// Get all the current Articles from our database
		dbArticles = ArticleDAO.getAllArticlesFromDatabase();
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
			if (!articleExistsInDB(articleUrl)){
				//logger.info("New article found: " + articleUrl);
				showMessage("New article found: " + articleUrl);
				
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
					ArticleDAO.writeArticle(a);
					
					newArticleCounter++;
				} catch (Exception e){
					showMessage("An unexpected error occurred !! Error is : " + e.toString());
					logger.error(e);
				}
			}
		}
		showMessage("The program ended and found : " + newArticleCounter + " new articles. You can view these articles in the folder D:/FD Articles/");
	}
	
//	/**
//	 * This method should open up our directory with FD Files
//	 * @throws Exception
//	 */
//    private void openDirectory(String myDir) throws Exception {
//        // Horribly platform specific.
//        String appData = System.getenv("APPDATA");
//        File appDataDir = new File(appData);
//        // Get a sub-directory named 'texture'
//        File textureDir = new File(appDataDir, "texture");
//        Desktop.getDesktop().open(textureDir);
//    }
	
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
