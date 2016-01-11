package profiles;


public class GenderFemale implements Gender{
	private static String genderValue = "f";
	private static String genderFullValue = "female";
	private static String genderText = "V";
	private static String genderFullText = "Vrouw";
	
	public String getGenderValue() {
		return genderValue;
	}
	
	public String getGenderFullValue(){
		return genderFullValue;
	}
	
	public String getGenderText(){
		return genderText;
	}
	
	public String getGenderFullText(){
		return genderFullText;
	}
	
}
