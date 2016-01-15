package utils;

import java.io.PrintWriter;

public class ArticleWriter {

	private static String articleDirectory = "D:/FD Articles/";
	
	/**
	 * This method will write the Article to a file
	 * @param myText
	 */
	public static void writeArticle(Article myArticle){
		
		PrintWriter writer = null;
		
		try{
			writer = new PrintWriter(articleDirectory + myArticle.getArticleTitle() + ".txt");
			writer.write(myArticle.getArticleText());
			
		} catch (Exception e){
			// Do nothing?
		} finally {
			try {
				writer.close();
			} catch (Exception ex){
				// Do nothing for sure
			}
		}
	}
}
