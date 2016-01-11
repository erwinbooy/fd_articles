package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import profiles.BirthDate;

/**
 * 
 * @author Erwin
 *
 * This class will help us with the birthdate
 */
public class BirthDateHelper {
	
	private static String birthDate = null;
	
	/**
	 * Calculate the birthdate using the day of today with the age
	 * 
	 * @param age
	 * @return
	 */
	public static Date calculateBirthDate(int age){
		// Get today from the Calendar
		Calendar today = Calendar.getInstance();
		// Subtract the age (by adding the age minus)
		today.add(Calendar.YEAR, -(age));
		// return the calculated date
		return today.getTime();
	}
	
	/**
	 * Calculate the birthdate for tomorrow
	 * This can be usefull for testing edge cases like
	 * Today I am 17 but tomorrow I am 18 years old
	 * So if you pass the age 17 you will get the birthdate back when you just became 18 years old
	 * 
	 * @param age
	 * @return
	 */
	public static BirthDate getBirthDateForTomorrow(int age){
		// Get today from the Calendar
		Calendar today = Calendar.getInstance();
		// Subtract the age (by adding the age minus)
		today.add(Calendar.YEAR, -(age));
		// Subtract 1 day to make us 1 day older (tomorrow)
		today.add(Calendar.DAY_OF_MONTH, -1);
		// return the calculated date base on tomorrow
		return new BirthDate(today.getTime());
	}
	
	/**
	 * Calculate the birthdate for yesterday
	 * This can be usefull for testing edge cases like
	 * Today I am 18 but yesterday I was 17 years old
	 * So if you pass the age 18 you will get the birthdate back when you were still 17 years old
	 * 
	 * @param age
	 * @return
	 */
	public static BirthDate getBirthDateForYesterday(int age){
		// Get today from the Calendar
		Calendar today = Calendar.getInstance();
		// Subtract the age (by adding the age minus)
		today.add(Calendar.YEAR, -(age));
		// Subtract 1 day to make us 1 day younger (yesterday)
		today.add(Calendar.DAY_OF_MONTH, 1);
		// return the calculated date base on yesterday
		return new BirthDate(today.getTime());
	}
 
	/**
	 * This method will return the Day of the birthdate in the format of dd
	 * 
	 * @param myBirthDate
	 * @return String with Day
	 */
	public static String getDayOfBirth(Date myBirthDate){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
		birthDate = dateFormat.format(myBirthDate);
		return birthDate;
	}
	
	/**
	 * This method will return the Month of the birthdate in the format of mm
	 * 
	 * @param myBirthDate
	 * @return String with Month
	 */
	public static String getMonthOfBirth(Date myBirthDate){
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
		birthDate = dateFormat.format(myBirthDate);
		return birthDate;
	}
	
	/**
	 * This method will return the Year of the birthdate in the format of yyyy
	 * 
	 * @param myBirthDate
	 * @return String with Year
	 */
	public static String getYearOfBirth(Date myBirthDate){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		birthDate = dateFormat.format(myBirthDate);
		return birthDate;
	}
	
	/**
	 * This method will return the date in the format dd-mm-yyyy
	 * 
	 * @param birthdate
	 * @return dd-mm-yyyy
	 */
	public static String getBirthDateWithDashes(Date myBirthDate){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		birthDate = dateFormat.format(myBirthDate);
		return birthDate;
	}

	/**
	 * This method will return the date in the format dd/mm/yyyy
	 * 
	 * @param birthdate
	 * @return dd/mm/yyyy
	 */
	public static String getBirthDateWithBackslash(Date myBirthDate){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		birthDate = dateFormat.format(birthDate);
		return birthDate;
	}
	
	/**
	 * This method will return the date in the format yyyy-mm-dd
	 * 
	 * @param birthdate
	 * @return yyyy-mm-dd
	 */
	public static String getBirthDateYearFirst(Date myBirthDate){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		birthDate = dateFormat.format(myBirthDate);
		return birthDate;
	}
}
