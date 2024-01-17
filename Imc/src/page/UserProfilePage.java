package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

public class UserProfilePage {

	@FindBy (xpath="//a[@title='User profile folder']")
	private WebElement UserProfile;
	@FindBy (xpath="//span[text()='Sign out']")
	private WebElement SignOut;
	
	public UserProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickUserProfile() {
		UserProfile.click();
	}
	
	public void ClickSignOut() {
		SignOut.click();
	}
	
	public void LogoutSucessfull(WebDriver driver,String eURL) {
		String aURL=driver.getCurrentUrl();
		Assert.assertEquals(eURL, aURL);
		
	}
	public void DriverClose(WebDriver driver) {
    driver.close();		
	}
}
