package users;

import pages.DeveloperPage;
import pages.NavigationSoftwarePage;
import pages.OnlineNavigationPage;

/**
 * Interface to be used for testing the Developer Profiles

 * @author Erwin
 */
public interface DeveloperProfile {
	/**
	 * Check if the user is logged in
	 */
	public boolean isLoggedIn(DeveloperUser user, DeveloperPage page);
	/**
	 * Check if the correct links are showing at the top
	 */
	public boolean hasCorrectLinks(DeveloperUser user, DeveloperPage page);
	/**
	 * Check if the correct menu items are showing at the top
	 */
	public boolean hasCorrectMenuItems(DeveloperUser user, DeveloperPage page);
	/**
	 * Check if the Sidebar items for the Online Navigation are correct
	 */
	public boolean hasCorrectSideBarItemsON(DeveloperUser user, OnlineNavigationPage page);
	/**
	 * Check if the Sidebar items for the Navigation Software are correct
	 */
	public boolean hasCorrectSideBarItemsNS(DeveloperUser user, NavigationSoftwarePage page);
}
