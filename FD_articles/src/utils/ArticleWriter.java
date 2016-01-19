package utils;

import java.io.PrintWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ArticleWriter {

	// Make sure this directory exists on your drive
	private static String articleDirectory = "D:/FD Articles/";
	private static String cssDirectory = "css/";
	private static Log logger = LogFactory.getLog("Article Writer");

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
			ArticleDatabase.addArticleToDatabase(myArticle.getArticleUrl());
		} catch (Exception e) {
			// Do nothing?
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				// Do nothing for sure
			}
		}
	}
}
