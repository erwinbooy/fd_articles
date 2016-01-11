package profiles;

/**
 * Interfact that is usefull to work with the persons
 * 
 * Types of persons:
 * Yourself and Partner
 * Adults and Children
 * 
 * @author Erwin
 *
 */
public interface Person {
	
	public Gender getGender();
	public String getFirstName();
	public String getMiddleName();
	public String getSurName();
	public BirthDate getBirthDate();
	public String getPhoneNumber();
	public String getEmailAddress();
	public String getCitizenServiceNumber();
	public String getNationality();
	public String getBankAccountNbr();
	public String getIban();
	public boolean isChild();
	public boolean isPartner();
}