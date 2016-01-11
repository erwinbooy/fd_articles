package pages.health;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.HoyhoyAbstractPage;

public class CoveragesPage extends HoyhoyAbstractPage {
	
	public CoveragesPage(WebDriver driver) {
		super(driver);
	}

	/** 
	 * Method to verify the page is showing
	 * @return boolean true/false 
	 */
	public boolean isPageShowing(){
		boolean isShowing = false;
		// We know that the page is showing when we see the text
		try{
			// If we found the element we are on the correct page
			this.driver.findElement(By.xpath("//h2[contains(.,'Hoe wil jij je zorgverzekering samenstellen')]"));
			isShowing = true;
		} catch (Exception e){
			// Obviously we didn't find the page
			isShowing = false;
		}
		return isShowing;
	}
}
