package utils;

import java.io.PrintWriter;

public class ArticleWriter {

	// Make sure this directory exists on your drive
	private static String articleDirectory = "D:/FD Articles/";

	/**
	 * This method will write the Article to a file
	 * 
	 * @param myText
	 */
	public static void writeArticle(Article myArticle) {

		PrintWriter writer = null;
		String fileName = myArticle.getArticleTitle().replace(":", "-");

		try {
			writer = new PrintWriter(articleDirectory + myArticle.getArticleTitle() + ".html");
			writer.write("<head><link rel='stylesheet' href='fd.css'></head><body>");
			writer.write(myArticle.getArticleText());
			writer.write("</body>");

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
