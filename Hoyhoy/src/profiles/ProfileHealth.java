package profiles;

public class ProfileHealth extends AbstractProfile {
	
	/**
	 * Simple constructor for this class using all the basic elements
	 * These are all the elements that are entered on the Landing page
	 */
	public ProfileHealth(Person myPerson, String myPostalCode, int myHouseNumber) {
		super(myPerson, new Address(myHouseNumber, myPostalCode));
	}
	
	/**
	 * Simple constuctor using some basic elements
	 * These are all the elements needed for the Takeout
	 */
	public ProfileHealth(Person myPerson, Address myAddress){
		super(myPerson, myAddress);
	}
}
