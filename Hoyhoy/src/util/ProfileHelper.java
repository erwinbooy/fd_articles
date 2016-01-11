package util;

import profiles.Address;
import profiles.BirthDate;
import profiles.Gender;
import profiles.GenderMale;
import profiles.Person;
import profiles.PersonYourself;
import profiles.Profile;
import profiles.ProfileHealth;


/**
 * Class to make testing a bit easier.
 * Later we should do this different
 * 
 * @author Erwin
 *
 */
public class ProfileHelper {
	
	/**
	 * Standard profile of a 25 year old Man which can be used for a lot of tests
	 * @return profile 
	 */
	public static Profile getStandardProfile(){
		Gender myGender = new GenderMale();
		BirthDate myBirthDate = new BirthDate(25);
		String myEmail = "selenium@hoyhoy.nl";
		Person myPerson = new PersonYourself(myGender, myBirthDate, myEmail);
		Address myAddress = new Address(11, "2253XZ");
		Profile myProfile = new ProfileHealth(myPerson, myAddress);
		return myProfile;
	}
	
	/**
	 * Standard profile for a certain age. This is easy for testing business rules around the birthdate field for example
	 * @param age
	 * @return
	 */
	public static Profile getStandardProfile(int age){
		Gender myGender = new GenderMale();
		BirthDate myBirthDate = new BirthDate(age);
		String myEmail = "selenium@hoyhoy.nl";
		Person myPerson = new PersonYourself(myGender, myBirthDate, myEmail);
		Address myAddress = new Address(11, "2253XZ");
		Profile myProfile = new ProfileHealth(myPerson, myAddress);
		return myProfile;
	}
	
	/**
	 * Create a profile
	 * 
	 * @param myGender
	 * @param myBirthDate
	 * @param myEmail
	 * @param myPostalCode
	 * @param myHouseNumber
	 * @param myPartner
	 * @param myChild
	 * @return Profile using the given values
	 */
	public static Profile getProfile (Gender myGender, BirthDate myBirthDate, String myEmail, String myPostalCode, int myHouseNumber, boolean myPartner, boolean myChild){
		Person myPerson = new PersonYourself(myGender, myBirthDate, myEmail);
		Address myAddress = new Address(myHouseNumber,myPostalCode);
		return new ProfileHealth(myPerson, myAddress);
	}
}
