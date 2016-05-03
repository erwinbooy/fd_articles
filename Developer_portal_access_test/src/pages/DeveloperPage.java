package pages;

public interface DeveloperPage {
	public String getSignInText();
	public String getSignOutText();
	public boolean hasAccountLink();
	public boolean hasDashboardLink();
	public void clickMenuItemHome();
	public void clickMenuItemOnlineNavigation();
	public void clickMenuItemNavigationSoftware();
	public void clickMenuItemRealTimeMaps();
	public void clickMenuItemBridge();
	public void clickMenuItemSports();
	public boolean hasMenuItemHome();
	public boolean hasMenuItemOnlineNavigation();
	public boolean hasMenuItemNavigationSoftware();
	public boolean hasMenuItemRealTimeMaps();
	public boolean hasMenuItemBridge();
	public boolean hasMenuItemSports();
}
