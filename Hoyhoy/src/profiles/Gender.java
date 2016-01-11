package profiles;


/**
 * 
 * @author Erwin
 *
 * This Interface is there to make it easier to handle the Male and Female Genders
 * In theory it could also be used for the children Boy, Girl
 */
public interface Gender {

	/*
	 * Returns the single letter as value for this Gender ('m','f')
	 */
	public String getGenderValue();
	
	/*
	 * Returns the full word as value for this Gender ('male','female')
	 */
	public String getGenderFullValue();
	
	/*
	 * Returns the single letter as text for this Gender ('M','V')
	 */
	public String getGenderText();
	
	/*
	 * Returns the full word as text for this Gender ('Man', 'Vrouw')
	 */
	public String getGenderFullText();
	
}