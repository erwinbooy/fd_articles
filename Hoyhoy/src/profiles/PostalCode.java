package profiles;

/**
 * This class can be used to handle the PostalCode for all funnels
 * It is only the dto object so it contains no logic
 * 
 * @author Erwin
 *
 */
public class PostalCode {
	private String postalCodeLetters = null;
	private String postalCodeNumbers = null;
	
	/**
	 * An easy way to construct a new PostalCode with the string AAAA99
	 *
	 * @param myPostalCode
	 */
	public PostalCode(String myPostalCode){
		postalCodeLetters = myPostalCode.substring(0,4);
		postalCodeNumbers = myPostalCode.substring(4,6);
	}
	
	/**
	 * Get the letters of the PostalCode
	 * @return letters from the PostalCode
	 */
	public String getPostalCodeLetters(){
		return postalCodeLetters;
	}
	
	/**
	 * Get the numbers of the PostalCode
	 * @return numbers of the PostalCode
	 */
	public String getPostalCodeNumbers(){
		return postalCodeNumbers;
	}
	
	/**
	 * Get the full PostalCode as AAAA99
	 * @return
	 */
	public String toString(){
		return postalCodeLetters+postalCodeNumbers;
	}
			
}
