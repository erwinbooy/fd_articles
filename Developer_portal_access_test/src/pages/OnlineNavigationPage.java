package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automationFramework.AbstractPage;

public class OnlineNavigationPage extends AbstractPage {

	// Sidebar navigation links
	public static String sidebar_id = "id('sub')";
	public static String sidebar_item = "/ul/li/a";
	public static String sidebar_overview = "[text()='Overview']";
	public static String sidebar_online_routing = "[text()='Online Routing']";
	public static String sidebar_online_maps = "[text()='Online Maps']";
	public static String sidebar_online_search = "[text()='Online Search']";
	public static String sidebar_online_traffic = "[text()='Online Traffic']";
	public static String sidebar_maps_sdk = "[text()='Maps SDK']";
	public static String sidebar_request_access = "[text()='Request access']";
	public static String sidebar_api_explorer = "[text()='API Explorer']";
	
	/**
	 * Constructor from the Abstract Class
	 * 
	 * @param driver
	 */
	public OnlineNavigationPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Check if the sidebar overview link is showing
	 * @return
	 */
	public boolean hasSideBarItemOverview(){
		try{
			findElementOnPage(By.xpath(sidebar_id+sidebar_item+sidebar_overview));
			return true;
		} catch (Exception ex){
			// We didn't find the element
		}
		return false;
	}
	
	/**
	 * Check if the sidebar online routing link is showing
	 * @return
	 */
	public boolean hasSideBarItemOnlineRouting(){
		try{
			findElementOnPage(By.xpath(sidebar_id+sidebar_item+sidebar_online_routing));
			return true;
		} catch (Exception ex){
			// We didn't find the element
		}
		return false;
	}
	
	/**
	 * Check if the sidebar online maps link is showing
	 * @return
	 */
	public boolean hasSideBarItemOnlineMaps(){
		try{
			findElementOnPage(By.xpath(sidebar_id+sidebar_item+sidebar_online_maps));
			return true;
		} catch (Exception ex){
			// We didn't find the element
		}
		return false;
	}
	
	/**
	 * Check if the sidebar online search link is showing
	 * @return
	 */
	public boolean hasSideBarItemOnlineSearch(){
		try{
			findElementOnPage(By.xpath(sidebar_id+sidebar_item+sidebar_online_search));
			return true;
		} catch (Exception ex){
			// We didn't find the element
		}
		return false;
	}
	
	/**
	 * Check if the sidebar online traffic link is showing
	 * @return
	 */
	public boolean hasSideBarItemOnlineTraffic(){
		try{
			findElementOnPage(By.xpath(sidebar_id+sidebar_item+sidebar_online_traffic));
			return true;
		} catch (Exception ex){
			// We didn't find the element
		}
		return false;
	}
	
	/**
	 * Check if the sidebar maps sdk link is showing
	 * @return
	 */
	public boolean hasSideBarItemMapsSDK(){
		try{
			findElementOnPage(By.xpath(sidebar_id+sidebar_item+sidebar_maps_sdk));
			return true;
		} catch (Exception ex){
			// We didn't find the element
		}
		return false;
	}
	
	/**
	 * Check if the sidebar request access link is showing
	 * @return
	 */
	public boolean hasSideBarItemRequestAccess(){
		try{
			findElementOnPage(By.xpath(sidebar_id+sidebar_item+sidebar_request_access));
			return true;
		} catch (Exception ex){
			// We didn't find the element
		}
		return false;
	}
	
	/**
	 * Check if the sidebar api explorer link is showing
	 * @return
	 */
	public boolean hasSideBarItemApiExplorer(){
		try{
			findElementOnPage(By.xpath(sidebar_id+sidebar_item+sidebar_api_explorer));
			return true;
		} catch (Exception ex){
			// We didn't find the element
		}
		return false;
	}
}
