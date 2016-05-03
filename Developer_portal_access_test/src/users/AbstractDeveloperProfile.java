package users;

import pages.DeveloperPage;
import pages.NavigationSoftwarePage;
import pages.OnlineNavigationPage;

/**
 * This is the Abstract class for the Profiles
 * It will hold all the information for the Basic Profile
 * 
 *  Menu links
 *  - My Account			Yes
 *  - Dashboard				Yes
 *  
 *  Menu items
 *  - Home					Yes
 *  - Online Navigation		Yes
 *  - Navigation Software	Yes
 *  - Real-Time Maps		Yes
 *  - Bridge				Yes	
 *  - Sports				Yes
 *  
 *  Sidebar Online Navigation
 *  - Overview				Yes
 *  - Online Routing		Yes
 *  - Online Maps			Yes
 *  - Online Search			Yes
 *  - Online Traffic		Yes
 *  - Maps SDK				Yes
 *  - Request Access		Yes
 *  - API Explorer			Yes
 *  
 *  Sidebar Navigation Software
 *  - Navkit				Yes
 *  - Downloads				Yes
 *  - FAQ					Yes
 *  - Integration Kit		Yes
 *  
 *  Sidebar Real-Time Maps
 *  - Overvew				Yes
 *  - NDS Map Updates		Yes
 *  - Map Input Tracker		Yes
 *  - Traffic Services		Yes
 *  
 *  Sidebar Bridge
 *  - A lot!!!				Yes
 *  
 *  Sidebar Sports
 *  - Overview				Yes
 *  - Camera Media Server	Yes
 *  - MySports Cloud		Yes
 *  
 *  Footer
 *  - Customer Support		Yes
 * 
 * @author Erwin Booij
 */
public abstract class AbstractDeveloperProfile implements DeveloperProfile{
	
	/**
	 * Method to verify that the user is logged in
	 * To do this we also need to have the page
	 * 
	 * This method could also be moved to the user because it doesn't really need the profile
	 * But lets leave it here for now
	 * @param myUser
	 * @return
	 */
	public boolean isLoggedIn(DeveloperUser myUser, DeveloperPage myPage){
		// Verify that the name is mentioned on the page
		String text = myPage.getSignInText();
		if (text.equalsIgnoreCase("Signed in as " + myUser.getUsername())){
			// Besides that the login link should have also been changed to Sign out
			text = myPage.getSignOutText();
			if (text.equalsIgnoreCase("Sign Out")){
				return true;
			}
		}
		return false;
	}

	/**;
	 * Method that checks if this profile has the correct links
	 * This profile should have the following links
	 * Note that everything is available for the highest role in the system
	 * 
	 *  Menu links
	 *  - My Account			
	 *  - Dashboard				
	 *  
	 * @param user
	 * @param myPage
	 * @return true/false
	 */
	public boolean hasCorrectLinks(DeveloperUser user, DeveloperPage myPage, boolean account, boolean dashboard){
		// First we test the links at the top
		if (!myPage.hasAccountLink() == account){
			return false;
		}
		if (!myPage.hasDashboardLink() == dashboard){
			return false;
		}
		return true;
	}

	/**
	 * Check the Menu Items for this profile
	 * 
	 *  Menu items
	 *  - Home					
	 *  - Online Navigation		
	 *  - Navigation Software	
	 *  - Real-Time Maps		
	 *  - Bridge					
	 *  - Sports				
	 *  
	 * @param user
	 * @param myPage
	 * @return true/false
	 */
	public boolean hasCorrectMenuItems(DeveloperUser user, DeveloperPage myPage, boolean home, boolean on, boolean ns, boolean rtm, boolean bridge, boolean sports){

		// Then we test the Menu items at the top
		if(!myPage.hasMenuItemHome() == home){
			return false;
		}
		if(!myPage.hasMenuItemOnlineNavigation() == on){
			return false;
		}
		if(!myPage.hasMenuItemNavigationSoftware() == ns){
			return false;
		}
		if(!myPage.hasMenuItemRealTimeMaps() == rtm){
			return false;
		}
		if(!myPage.hasMenuItemBridge() == bridge){
			return false;
		}
		if(!myPage.hasMenuItemSports() == sports){
			return false;
		}
		return true; 
	}

	/**
	 * Check the Sidebar Items for this profile
	 * 
	 *  Sidebar Online Navigation
	 *  - Overview				Yes
	 *  - Online Routing		Yes
	 *  - Online Maps			Yes
	 *  - Online Search			Yes
	 *  - Online Traffic		Yes
	 *  - Maps SDK				Yes
	 *  - Request Access		Yes
	 *  - API Explorer			Yes
	 *  
	 * @param user
	 * @param myPage
	 * @return true/false
	 */
	public boolean hasCorrectSidebarItemsON(DeveloperUser user, OnlineNavigationPage myPage, boolean ov, boolean or, boolean om, boolean os, boolean ot, boolean maps,boolean ra, boolean ae){

		if(!myPage.hasSideBarItemOverview() == ov){
			return false;
		}
		if(!myPage.hasSideBarItemOnlineRouting() == or){
			return false;
		}
		if(!myPage.hasSideBarItemOnlineMaps() == om){
			return false;
		}
		if(!myPage.hasSideBarItemOnlineSearch() == os){
			return false;
		}
		if(!myPage.hasSideBarItemOnlineTraffic() == ot){
			return false;
		}
		if(!myPage.hasSideBarItemMapsSDK() == maps){
			return false;
		}
		if(!myPage.hasSideBarItemRequestAccess() == ra){
			return false;
		}
		if(!myPage.hasSideBarItemApiExplorer() == ae){
			return false;
		}
		return true; 
	}

	/**
	 *  Sidebar Navigation Software
	 *  - Navkit				Yes
	 *  - Downloads				Yes
	 *  - Documentation			Yes
	 *  - FAQ					Yes
	 *  - Integration Kit		Yes
	 *
	 * @param user
	 * @param myPage
	 * @return true/false
	 */
	public boolean hasCorrectSidebarItemsNS(DeveloperUser user, NavigationSoftwarePage myPage, boolean nk, boolean dl, boolean doc, boolean faq, boolean ik){

		if(!myPage.hasSideBarItemNavKit() == nk){
			return false;
		}
		if(!myPage.hasSideBarItemDownloads() == dl){
			return false;
		}
		if(!myPage.hasSideBarItemDocumentation() == doc){
			return false;
		}
		if(!myPage.hasSideBarItemFAQ() == faq){
			return false;
		}
		if(!myPage.hasSideBarItemInegrationKit() == ik){
			return false;
		}
		return true; 
	}
}
