package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends HoyhoyAbstractPage{
	
	private static String xHealthFunnel = "//div[contains(@class,'home-header__container')]/a[contains(@href,'zorgverzekering')]";
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * This method will open the Health funnel
	 */
	public void gotoHealthFunnel(){
		driver.findElement(By.xpath(xHealthFunnel)).click();
	}
	
}
