package profiles;

import java.util.Date;

import util.BirthDateHelper;

/**
 * This class can be used by all funnels 
 * the BirthDateHelper class has the utilities and this class should just be the dto so don't add any logic in this class!
 * 
 * @author Erwin
 *
 */
public class BirthDate {
	
	private Date myBirthDate = null;
	
	/**
	 * create a BirthDate using an age
	 * @param age
	 */
	public BirthDate(int age){
		myBirthDate = BirthDateHelper.calculateBirthDate(age);
	}
	
	/**
	 * Create a birthdate using a Date
	 * 
	 * @param myBirthDate
	 */
	public BirthDate(Date myBirthDate){
		this.myBirthDate = myBirthDate;
	}

	/**
	 * @param Date birthdate
	 * 
	 * Initialize our birthdate so it is ready to use
	 */
	public void setBirthDate(Date birthdate){
		myBirthDate = birthdate;
	}
	
	/**
	 * 
	 * @return birthdate in the format dd-mm-yyyy
	 */
	public String getBirthDateDayFirst(){
		return BirthDateHelper.getBirthDateWithDashes(myBirthDate);
	}

	/**
	 * 
	 * @return birthdate in the format yyyy-mm-dd
	 */
	public String getBirthDateYearFirst(){
		return BirthDateHelper.getBirthDateYearFirst(myBirthDate);
	}

	/**
	 * 
	 * @return Day of the birthdate as String
	 */
	public String getDayOfBirth(){
		return BirthDateHelper.getDayOfBirth(myBirthDate);
	}
	
	/**
	 * 
	 * @return Month of the birthdate as String
	 */
	public String getMonthOfBirth(){
		return BirthDateHelper.getMonthOfBirth(myBirthDate);
	}
	
	/**
	 * 
	 * @return Year of the birthdate as String
	 */
	public String getYearOfBirth(){
		return BirthDateHelper.getYearOfBirth(myBirthDate);
	}
	
	/**
	 * For the toString method we return the birthdate in the format dd-mm-yyyy
	 */
	public String toString(){
		return this.getBirthDateDayFirst();
	}
}
