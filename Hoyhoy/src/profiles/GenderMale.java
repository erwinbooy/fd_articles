package profiles;


public class GenderMale implements Gender{
	private static String genderValue = "m";
	private static String genderFullValue = "male";
	private static String genderText = "M";
	private static String genderFullText = "Man";
	
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
