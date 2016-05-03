package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automationFramework.AbstractPage;

public class NavigationSoftwarePage extends AbstractPage {

	// Sidebar navigation links
	public static String sidebar_id = "id('sub')";
	public static String sidebar_item = "/ul/li/a";
	public static String sidebar_navkit = "[text()='NavKit']";
	public static String sidebar_sub_item = "/ul/ul/li/a";
	public static String sidebar_documentation = "[text()='Documentation']";
	public static String sidebar_downloads = "[text()='Downloads']";
	public static String sidebar_faq = "[text()='FAQ']";
	public static String sidebar_integration_kit = "[text()='Integration Kit']";
	
	/**
	 * Constructor from the Abstract Class
	 * 
	 * @param driver
	 */
	public NavigationSoftwarePage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Check if the sidebar NavKit is showing
	 * @return
	 */
	public boolean hasSideBarItemNavKit(){
		try{
			findElementOnPage(By.xpath(sidebar_id+sidebar_item+sidebar_navkit));
			return true;
		} catch (Exception ex){
			// We didn't find the element
		}
		return false;
	}
	
	/**
	 * Check if the sidebar Documentation is showing
	 * @return
	 */
	public boolean hasSideBarItemDocumentation(){
		try{
			findElementOnPage(By.xpath(sidebar_id+sidebar_sub_item+sidebar_documentation));
			return true;
		} catch (Exception ex){
			// We didn't find the element
		}
		return false;
	}
	
	/**
	 * Check if the sidebar Downloads is showing
	 * @return
	 */
	public boolean hasSideBarItemDownloads(){
		try{
			findElementOnPage(By.xpath(sidebar_id+sidebar_sub_item+sidebar_downloads));
			return true;
		} catch (Exception ex){
			// We didn't find the element
		}
		return false;
	}
	
	/**
	 * Check if the sidebar FAQ is showing
	 * @return
	 */
	public boolean hasSideBarItemFAQ(){
		try{
			findElementOnPage(By.xpath(sidebar_id+sidebar_sub_item+sidebar_faq));
			return true;
		} catch (Exception ex){
			// We didn't find the element
		}
		return false;
	}
	
	/**
	 * Check if the sidebar Integration Kit is showing
	 * @return
	 */
	public boolean hasSideBarItemInegrationKit(){
		try{
			findElementOnPage(By.xpath(sidebar_id+sidebar_sub_item+sidebar_integration_kit));
			return true;
		} catch (Exception ex){
			// We didn't find the element
		}
		return false;
	}
}
