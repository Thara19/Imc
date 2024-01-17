package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class FrontPage{
	@FindBy (xpath="//a[@title='Categories switch']")
	private WebElement DropdownHandle;
	@FindBy (xpath="//button[@id='administrator']")
	private WebElement Admin;
	@FindBy (xpath="//span[text()=' People ']")
	private WebElement People;
	@FindBy (xpath="//span[text()='Clients']")
	private WebElement ClientsAdmin;
	@FindBy (xpath="//a[@id='navi_item_learner_catalogue']")
	private WebElement Catalogue;
	
	
	
		
	public FrontPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void VerifyFrontPageIsDisplayed(WebDriver driver, String eTitle) {
		String aTitle=driver.getTitle();
		Reporter.log("FrontPage Title:"+aTitle,true);
		Assert.assertEquals(aTitle, eTitle);
	}
	
	public void DashboardID927747(WebDriver driver, String newURL) {
		driver.navigate().to(newURL);
	}
	
	public void ClickDropdownHandle() {
		DropdownHandle.click();	}
	
	public void ClickAdmin() {
		Admin.click();	}
	
	public void ClickPeople() {
		People.click();	}
	
	public void ClickClients() {
		ClientsAdmin.click();	}
	
	public void ClickCatalogue() {
		Catalogue.click();	}

}
