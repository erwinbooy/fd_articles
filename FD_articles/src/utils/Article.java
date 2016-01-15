package utils;

public class Article {

	private String articleUrl = null;
	private String articleText = null;
	private String articleTitle = null;
	
	public String getArticleUrl() {
		return articleUrl;
	}
	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}
	public String getArticleText() {
		return articleText;
	}
	public void setArticleText(String articleText) {
		this.articleText = articleText;
	}
	public void setArticleTitle(String articleTitle){
		this.articleTitle = articleTitle;
	}
	public String getArticleTitle(){
		return articleTitle;
	}
}
