package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ArticleDAO {

	// The program runs from the /bin/ so that is our user.dir
	private static String running_dir = System.getProperty("user.dir");
	private static String articleDirectory = running_dir + "../FD Articles/";
	private static String cssDirectory = "css/"; // relative path to the FD Articles
	private static Log logger = LogFactory.getLog("Article Writer");

	// File that contains our article database
	private static String articleFile = running_dir + "../db/articles_db.txt";

	/**
	 * This method will write the Article to a file
	 * 
	 * @param myText
	 */
	public static void writeArticle(Article myArticle) {

		PrintWriter writer = null;
		String fileName = myArticle.getArticleTitle();

		try {
			writer = new PrintWriter(articleDirectory + fileName + ".html");
			writer.write("<head><link rel='stylesheet' href='" + cssDirectory + "fd.css'></head><body>");
			writer.write(myArticle.getArticleText());
			writer.write("</body>");
			logger.info("Article written in FD directory");

			// When we wrote the article we also want to update the database accordingly
			addArticleToDatabase(myArticle.getArticleUrl());
		} catch (Exception e) {
			// Do nothing?
			logger.error("Something went wrong while trying to write our article " + e);
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				// Do nothing for sure
			}
		}
	}
	
	/**
	 * This method will add the articleUrl to the database 
	 *  
	 * @param articleUrl
	 */
	public static void addArticleToDatabase(String articleUrl){
		BufferedWriter dbWriter = null;
		try{
			dbWriter = new BufferedWriter(new FileWriter(articleFile,true));
			dbWriter.append(articleUrl);
			dbWriter.append("\r\n");
			logger.info("Article added in Article DB");
		} catch (IOException ioe){
			logger.error("Something went wrong whilee trying to update our database: " + ioe);
		} finally {
			try{
				dbWriter.close();
			} catch (Exception e){
				logger.warn("Exception while trying to close the file writer");
				// Ignore
			}
		}
	}

	/**
	 * This method will get all the articleUrls from the database 
	 * 
	 * @return List<String> with articleUrls
	 */
	public static List<String> getAllArticlesFromDatabase(){
		ArrayList<String> articles = new ArrayList<>();
		BufferedReader dbReader = null;
		String line = null;
		try{
			dbReader = new BufferedReader(new FileReader(articleFile));
			while((line = dbReader.readLine()) != null){
				articles.add(line);
			}
		} catch (IOException ioe){
			logger.error(ioe);
		} finally {
			try{
				dbReader.close();
			} catch (Exception e){
				logger.warn("Exception while trying to close the file reader");
			}
		}
		return articles;
	}
}
