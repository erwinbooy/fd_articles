package profiles;

public class PersonYourself extends AbstractPerson{

	/**
	 * Create Yourself 
	 * 
	 * @param myGender
	 * @param myBirthDate
	 * @param myEail
	 */
	public PersonYourself(Gender myGender, BirthDate myBirthDate, String myEail) {
		// For ourselves we have to set isPartner to false
		super(myGender, myBirthDate, myEail, false, false);
	}
}
