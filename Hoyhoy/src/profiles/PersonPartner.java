package profiles;

public class PersonPartner extends AbstractPerson {

	/**
	 * Create a Partner
	 * 
	 * @param myGender
	 * @param myBirthDate
	 * @param myEail
	 */
	public PersonPartner(Gender myGender, BirthDate myBirthDate, String myEail) {
		// For the partner we have to send true for isPartner and false for isChild
		super(myGender, myBirthDate, myEail, true, false);
	}
}
