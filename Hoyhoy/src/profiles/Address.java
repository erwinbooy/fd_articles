package profiles;

public class Address {
	private String streetName = null;
	private String houseNumber = null;
	private String houseNumberExt = null;
	private PostalCode postalCode = null;
	
	/**
	 * Simple constructor to fill the address.
	 */
	public Address(String myStreetName, int myHouseNumber, String myHouseNumberExt, String myPostalCode){
		streetName = myStreetName;
		houseNumber = Integer.toString(myHouseNumber);
		houseNumberExt = myHouseNumberExt;
		postalCode = new PostalCode(myPostalCode);
	}

	/**
	 * Most simple constructor to fill the address.
	 */
	public Address(int myHouseNumber, String myPostalCode){
		streetName = "";
		houseNumber = Integer.toString(myHouseNumber);
		houseNumberExt = "";
		postalCode = new PostalCode(myPostalCode);
	}

	/**
	 * The streetName doesn't have to be filled for the address so it can be empty
	 * 
	 * @return String with the StreetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * The houseNumber should always be filled for an address
	 * 
	 * @return int with the HouseNumber
	 */
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * The houseNumber should always be filled for an address
	 * 
	 * @return String with the HouseNumber
	 */
	public String getHouseNumberExt() {
		return houseNumberExt;
	}

	/**
	 * The postalCode should always be filled for an address
	 * 
	 * @return PostalCode
	 */
	public PostalCode getPostalCode() {
		return postalCode;
	}
}
