package util;

import profiles.Gender;
import profiles.GenderFemale;
import profiles.GenderMale;

/**
 * Class to make it even easier to get a certain Gender
 * @author Erwin
 *
 */
public class GenderHelper {

	public static Gender getMale(){
		return new GenderMale();
	}
	
	public static Gender getFemale(){
		return new GenderFemale();
	}
}
