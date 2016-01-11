package tests.health;

import org.junit.Test;

import pages.HomePage;
import pages.health.CoveragesPage;
import pages.health.LandingPage;
import profiles.BirthDate;
import profiles.Gender;
import profiles.PostalCode;
import util.BirthDateHelper;
import util.GenderHelper;
import automationFramework.PageProvider;
import automationFramework.TestBase;

public class FieldValidationLandingPageTest extends TestBase{
	
	/**
	 * Test the validation of the BirthDate field for the Landing page
	 * Test for merging
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void test() throws InterruptedException{
		// First we open the Health funnel via the HomePage
		HomePage homePage = PageProvider.getHomePage();
		homePage.gotoHealthFunnel();

		// Now we are on the landing page we click on the Gender
		LandingPage landingPage = PageProvider.getLandingPage();
		Gender myGender = GenderHelper.getMale();
		landingPage.clickGender(myGender);

		// Now we will Validate the BirthDate
		// First we enter the birthDate of a 16 years and 12 months old which should not be valid
		BirthDate myBirthDate = BirthDateHelper.getBirthDateForYesterday(17);
		landingPage.enterBirthDate(myBirthDate);
		// We expect the field to be invalid
		assertEquals(false, landingPage.isBirthDateValid());
		// Now we change the birthdate to a 17 year old which should be valid
		myBirthDate = BirthDateHelper.getBirthDateForTomorrow(17);
		landingPage.enterBirthDate(myBirthDate);
		assertEquals(true, landingPage.isBirthDateValid());
		
		// Then we will validate the PostalCode
		// First we enter a PostalCode with only letters which should not be valid
		PostalCode myPostalCode = new PostalCode("AAAAAA");
		landingPage.enterPostalCode(myPostalCode);
		assertEquals(false,landingPage.isPostalCodeValid());
		// Now we enter a PostalCode in the correct format which is not valid
		myPostalCode = new PostalCode("AAAA99");
		landingPage.enterPostalCode(myPostalCode);
		assertEquals(false,landingPage.isPostalCodeValid());
		// Now we enter a PostalCode which is valid (the one from our profile)
		myPostalCode = new PostalCode("2253XZ");
		landingPage.enterPostalCode(myPostalCode);
		assertEquals(true,landingPage.isPostalCodeValid());
		
		// Then we will validate the HouseNumber
		// First we enter a letter which is not allowed
		landingPage.enterHouseNumber("A");
		assertEquals(false,landingPage.isHouseNumberValid());
		// Then we enter a number that doesn't belong to the PostalCode
		// This will be valid but when we press the button it should become invalid
		landingPage.enterHouseNumber(250);
		assertEquals(true, landingPage.isHouseNumberValid());
		// So now we press the button it will start showing with a warning message
		landingPage.clickCompareNowButton();
		assertEquals(true, landingPage.hasPostalCodeError());
		// Now we enter the correct housenumber from our profile press the button again and everything should be fine
		landingPage.enterHouseNumber(11);
		landingPage.clickCompareNowButton();
		// So we end up on the next page
		CoveragesPage coveragePage = PageProvider.getCoveragePage();
		assertEquals(true, coveragePage.isPageShowing());
	}
}
