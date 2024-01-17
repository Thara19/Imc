package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.Reporter;

public class Dashboard927747Page {
	
	@FindBy (xpath="//*[text()='#TD #Classifications Panel']")
	private WebElement ClassificationsPanel; 
	@FindBy (xpath="//button[text()='Search in catalogue ']")
	private WebElement SearchInCatalogue;
	@FindBy (xpath="//div[@aria-label='Catalogue']")
	private WebElement Catalogue;
	@FindBy (xpath="//*[@id=\"dashboards-section\"]/div/imc-classifications-panel/section/div/div[2]/imc-classifications/div[2]/div[2]/a")
	private WebElement LanguageSkills;
	@FindBy (xpath="//a[contains(@class,'cell_tile')]")
	private WebElement cards;
	
	public Dashboard927747Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void TextClassificationsPanel(WebDriver driver, String ePanelTitle) {
		String apanelTitle=ClassificationsPanel.getText();
		Reporter.log("Acual PanelName:"+apanelTitle,true);
		Reporter.log("expected PanelName:"+ePanelTitle,true);
		Assert.assertEquals(ePanelTitle, apanelTitle);
	}
	
	public void CatalogueLoads(WebDriver driver) {
		SearchInCatalogue.click();
		String text=Catalogue.getText();
		Reporter.log(text +" COntent is loaded", true);
		}
	
	public void ClickLanguageSkills() {
		LanguageSkills.click();
	}

	public void CardsDisplay() {
		boolean displayed = cards.isDisplayed();
		Assert.assertEquals(displayed, true);
		Reporter.log(" Classsification cards are displayed:" + displayed, true);
	}
}
