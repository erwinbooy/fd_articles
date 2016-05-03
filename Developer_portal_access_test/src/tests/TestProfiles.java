package tests;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import automationFramework.PageProvider;
import automationFramework.TestBase;
import pages.DeveloperHomePage;
import pages.LoginPage;
import users.DeveloperUser;
import utils.TestUserTool;

public class TestProfiles extends TestBase {

	/**
	 * Sign in with TomTom Developer portal
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void test() throws InterruptedException {
		
		// Get the users from the Database
		List<DeveloperUser> users = TestUserTool.getTestUsers();

		// Now loop through all the users and perform the tests
		Iterator<DeveloperUser> iter = users.iterator();
		DeveloperUser myUser = null;
		while (iter.hasNext()){
			// Go to the FD page and get all article Urls
			DeveloperHomePage homePage = PageProvider.getDeveloperHomePage();
			homePage.OpenPage();
			homePage.clickSignIn();
			
			// Now Sign in
			myUser = iter.next();
			
			LoginPage loginPage = PageProvider.getLoginPage();
			loginPage.signIn(myUser);
			
			// Verify that the user is logged in
			assertTrue(myUser.getProfile().isLoggedIn(myUser,homePage));
			// Verify that the user has the correct links on the Top of the page
			assertTrue(myUser.getProfile().hasCorrectLinks(myUser,homePage));
			// Verify that the user has the correct menu items on the Top of the page
			assertTrue(myUser.getProfile().hasCorrectMenuItems(myUser,homePage));

			// Now we go to the Online Navigation page and test everything there
			homePage.clickMenuItemOnlineNavigation();
			// Verify that the user has the correct sidebarlinks on Online Navigation Page
			assertTrue(myUser.getProfile().hasCorrectSideBarItemsON(myUser,PageProvider.getOnlineNavigationPage()));

			// Now we go to the Navigation Software page and test everything there
			homePage.clickMenuItemNavigationSoftware();
			// Verify that the user has the correct sidebarlinks on Navigation Software Page
			assertTrue(myUser.getProfile().hasCorrectSideBarItemsNS(myUser,PageProvider.getNavigationSoftwarePage()));
			
			// Sign out for the next user
			homePage.clickSignOut();
		}
	}
}
