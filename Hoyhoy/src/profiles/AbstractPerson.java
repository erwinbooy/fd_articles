package profiles;

public class AbstractPerson implements Person{
	private Gender gender = null;
	private String firstName = "ME";
	private String middleName = "de";
	private String surName = "Test";
	private BirthDate birthDate = null;
	private String phoneNumber = "0613131313";
	private String emailAddress = null;
	private String citizenServiceNumber = "302694018";
	private String nationality = "Nederland";
	private String bankAccountNbr = "0458245950";
	private String iBan = "NL47ABNA0458245950";
	private boolean isChild = false;
	private boolean isPartner = false;

	/**
	 * Easy way to create a person
	 * Only 5 values are needed because we have fixed values for the rest 
	 * If needed they van be changed for certain tests
	 * 
	 * @param myGender
	 * @param myBirthDate
	 */
	public AbstractPerson(Gender myGender, BirthDate myBirthDate, String myEail, boolean isPartner, boolean isChild){
		gender = myGender;
		birthDate = myBirthDate;
		emailAddress = myEail;
		this.isPartner = isPartner;
		this.isChild = isChild;
	}

	@Override
	public Gender getGender() {
		return gender;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getMiddleName() {
		return middleName;
	}

	@Override
	public String getSurName() {
		return surName;
	}

	@Override
	public BirthDate getBirthDate() {
		return birthDate;
	}

	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}
				
	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String getCitizenServiceNumber() {
		return citizenServiceNumber;
	}

	@Override
	public String getNationality() {
		return nationality;
	}

	@Override
	public String getBankAccountNbr() {
		return bankAccountNbr;
	}

	@Override
	public String getIban() {
		return iBan;
	}

	@Override
	public boolean isChild() {
		return isChild;
	}

	@Override
	public boolean isPartner() {
		return isPartner;
	}
}
