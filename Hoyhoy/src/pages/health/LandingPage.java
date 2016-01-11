package pages.health;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.HoyhoyAbstractPage;
import profiles.Address;
import profiles.BirthDate;
import profiles.Gender;
import profiles.Person;
import profiles.PostalCode;
import profiles.Profile;

public class LandingPage extends HoyhoyAbstractPage{
	
	// This class inherits the driver from the Abstract class
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}

	private static String idForm = "health-form";
	private static String idBirthDate = "geboortedatum";
	private static String idPostalCode = "postcode";
	private static String idHouseNumber = "huisnummer";
	private static String xGender = "//label[contains(.,'Geslacht')]/following-sibling::div/label[contains(.,'$GENDER')]";
	private static String xCompareNowButton = "//button[contains(@class,'btn-primary')][contains(.,'Vergelijk nu')]";
	private static String xInputInvalid = "//input[contains(@aria-invalid,'true')]";
	private static String xErrorTag = "//div[contains(@class,'has-error')]";
	private static String xPostalCodeError = "//div[contains(@class,'form-group--postcode')]";
		
	/**
	 * @param gender
	 * @throws InterruptedException
	 * 
	 * Click on the button which belongs to the given Gender
	 */
	public void clickGender(Gender gender) throws InterruptedException {
		// First we get the form and from there we search the elements
		WebElement myForm = driver.findElement(By.id(idForm));
		String myXPath = xGender.replace("$GENDER", gender.getGenderFullText());
		myForm.findElement(By.xpath(myXPath)).click();
	}

	/**
	 * @param Person
	 * @throws InterruptedException
	 * 
	 * Click on the button which belongs to the given Gender
	 */
	public void clickGender(Person myPerson) throws InterruptedException {
		// First we get the form and from there we search the elements
		WebElement myForm = driver.findElement(By.id(idForm));
		myForm.findElement(By.xpath("//label[contains(.,'Geslacht')]/following-sibling::div/label[contains(.,'" + myPerson.getGender().getGenderFullText() + "')]")).click();
	}
	
	/**
	 * @param birthDate in format (dd-mm-yyyy)
	 * @throws InterruptedException
	 */
	public void enterBirthDate(BirthDate birthDate) throws InterruptedException{
		driver.findElement(By.id(idBirthDate)).clear();
		driver.findElement(By.id(idBirthDate)).sendKeys(birthDate.getBirthDateDayFirst());
	}
	
	/**
	 * @param Person
	 * @throws InterruptedException
	 */
	public void enterBirthDate(Person myPerson) throws InterruptedException{
		driver.findElement(By.id(idBirthDate)).clear();
		driver.findElement(By.id(idBirthDate)).sendKeys(myPerson.getBirthDate().getBirthDateDayFirst());
	}
	
	/**
	 * @param String zipcode in format (AAAAZZ)
	 * @throws InterruptedException
	 */
	public void enterPostalCode(PostalCode myPostalCode) throws InterruptedException{
		driver.findElement(By.id(idPostalCode)).clear();
		driver.findElement(By.id(idPostalCode)).sendKeys(myPostalCode.toString());
	}
	
	/**
	 * @param Address
	 * @throws InterruptedException
	 */
	public void enterPostalCode(Address myAddress) throws InterruptedException{
		driver.findElement(By.id(idPostalCode)).clear();
		driver.findElement(By.id(idPostalCode)).sendKeys(myAddress.getPostalCode().toString());
	}
	
	/**
	 * @param int housenumber
	 * @throws InterruptedException
	 */
	public void enterHouseNumber(int housenumber) throws InterruptedException{
		driver.findElement(By.id(idHouseNumber)).clear();
		driver.findElement(By.id(idHouseNumber)).sendKeys(new Integer(housenumber).toString());
	}

	/**
	 * @param String housenumber
	 * @throws InterruptedException
	 */
	public void enterHouseNumber(String housenumber) throws InterruptedException{
		driver.findElement(By.id(idHouseNumber)).clear();
		driver.findElement(By.id(idHouseNumber)).sendKeys(housenumber);
	}
	
	/**
	 * @param Address
	 * @throws InterruptedException
	 */
	public void enterHouseNumber(Address myAddress) throws InterruptedException{
		driver.findElement(By.id(idHouseNumber)).clear();
		driver.findElement(By.id(idHouseNumber)).sendKeys(myAddress.getHouseNumber());
	}

	/**
	 * Click on the Vergelijk Nu button
	 */
	public void clickCompareNowButton() throws InterruptedException{
		// First we get the form and from there we search the elements
		WebElement myForm = driver.findElement(By.id(idForm));
		myForm.findElement(By.xpath(xCompareNowButton)).click();
	}
	
	/**
	 * Easy method to just fill out the form using your profile and continue to the next step
	 */
	public void fillForm(Profile myProfile) throws InterruptedException{
		this.clickGender(myProfile.getPerson().getGender());
		this.enterBirthDate(myProfile.getPerson().getBirthDate());
		this.enterPostalCode(myProfile.getAddress().getPostalCode());
		this.enterHouseNumber(myProfile.getAddress().getHouseNumberExt());
		this.clickCompareNowButton();
	}
	
	/**
	 * Verify if there is an error on the BirthDate field
	 * @return true/false
	 */
	public boolean isBirthDateValid(){
		WebElement myField = driver.findElement(By.id(idBirthDate));
		return isValid(myField);
	}
	
	/**
	 * Verify if there is an invalid tag on the PostalCode field
	 * @return
	 */
	public boolean isPostalCodeValid(){
		WebElement myField = driver.findElement(By.id(idPostalCode));
		return isValid(myField);
	}

	/**
	 * Verify if there is an invalid tag on the HouseNumber field
	 * @return
	 */
	public boolean isHouseNumberValid(){
		WebElement myField = driver.findElement(By.id(idHouseNumber));
		return isValid(myField);
	}
	
	/**
	 * Verify if there is an error on the PostalCode
	 * @return
	 */
	public boolean hasPostalCodeError(){
		WebElement myField = driver.findElement(By.xpath(xPostalCodeError));
		return hasError(myField);
	}
	
	/**
	 * Method to validate a WebElement
	 * @param myField
	 * @return true if the field is valid or false if the field is invalid
	 */
	private boolean isValid(WebElement myField){
		boolean isValid = false;
		try{
			// Try to find the field with the Invalid tag
			myField.findElement(By.xpath(xInputInvalid));
		} catch (Exception e){
			// We couldn't find the Invalid tag which means the field is valid
			isValid = true;
		}
		return isValid;
	}
	
	/**
	 * Method to check if the WebElement has an Error
	 * @param myField
	 * @return true if the field has an Error and false when there is no error
	 */
	private boolean hasError(WebElement myField){
		boolean hasError = false;;
		try {
			// Try to find the field with the Error tag
			myField.findElement(By.xpath(xErrorTag));
			hasError = true;
		} catch (Exception e) {
			// We couldn't find the Error tag which means the field is okay
		}
		return hasError;	}
	
}
