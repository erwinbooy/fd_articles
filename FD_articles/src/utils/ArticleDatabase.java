package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ArticleDatabase {

	// File that contains all our articles
	private static String articleFile = "D:/FD Articles/db/articles_db.txt";
	// Logger
	private static Log log = null;

	/**
	 * This method will add the article name to the database
	 */
	public static void addArticleToDatabase(String articleTitle){
		log = LogFactory.getLog("ArticleDatabase");
		BufferedWriter dbWriter = null;

		try{
			dbWriter = new BufferedWriter(new FileWriter(articleFile,true));
			dbWriter.append(articleTitle);
			dbWriter.append("\r\n");
			log.info("Article added in Article DB");
		} catch (IOException ioe){
			log.error(ioe);
		} finally {
			try{
				dbWriter.close();
			} catch (Exception e){
				log.warn("Exception while trying to close the file writer");
				// Ignore
			}
		}
	}
	
	/**
	 * This method will read all articles from our database(file)
	 */
	public static List<String> getAllArticlesFromDatabase(){
		
		log = LogFactory.getLog("ArticleDatabase");
		
		ArrayList<String> articles = new ArrayList<>();
		// Reader to read our file
		BufferedReader dbReader = null;
		String line = null;
		
		try{
			dbReader = new BufferedReader(new FileReader(articleFile));
			while((line = dbReader.readLine()) != null){
				articles.add(line);
			}
		} catch (IOException ioe){
			log.error(ioe);
		} finally {
			try{
				dbReader.close();
			} catch (Exception e){
				log.warn("Exception while trying to close the file reader");
				// Ignore
			}
		}
		return articles;
	}
}
