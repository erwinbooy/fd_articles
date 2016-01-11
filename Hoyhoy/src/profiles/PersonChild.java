package profiles;

public class PersonChild extends AbstractPerson {

	/**
	 * Create a child
	 * 
	 * @param myGender
	 * @param myBirthDate
	 * @param myEail
	 * @param isPartner
	 * @param isChild
	 */
	public PersonChild(Gender myGender, BirthDate myBirthDate, String myEmail) {
		super(myGender, myBirthDate, myEmail, false, true);
	}

}
