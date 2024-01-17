package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class CateloguePage {
	
	@FindBy (xpath="//div[contains(@class,'breadcrumbs')]")
	private WebElement DashboardBreadCrumb;
	@FindBy (xpath="//span[contains(@class,'result')]")
	private WebElement Result;
	@FindBy (xpath="//*[@id=\"course-section\"]/div[2]/facet-search-summary/div/div/imc-summary-bar/span/span[2]/span[2]/span/button/span[1]")
	private WebElement LanguageSkills;
	@FindBy (xpath="//*[@id=\"course-section\"]/div[2]/facet-search-summary/div/div/imc-summary-bar/span/span[1]/span")
	private WebElement UnfilteredResult;
	@FindBy (xpath="(//a[contains(@class,'cell_tile')])[4]")
	private WebElement MSOffice;
	@FindBy (xpath="//a[contains(text(),'Show more results')]")
	private WebElement ShowMoreResult;
	@FindBy (xpath="//div[@class='imc-list-title ng-binding']")
	private WebElement MSOfficeResult;
	@FindBy (xpath="//input[@id='searchField']")
	private WebElement SearchField;
	@FindBy (xpath="//*[@id='startSearchBtn']")
	private WebElement SearchButton;
    @FindBy (xpath="//*[@id='one-column-list-layout-item-cs_result_item_863640']/div/div/a")
	private WebElement WarntimingResult;

	
	
	public CateloguePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void BreadcrumbDashboard(WebDriver driver) {
		try{
			DashboardBreadCrumb.click();
		 }
		catch (Exception e)  { }
		finally { 
			Reporter.log("Dashboard breadcrumb is not visible as chrome is in control of automation tool/bot",true);
			driver.navigate().back(); }		
	}
	
	public void Result() {
		String result=Result.getText();
		Reporter.log(result +" is displayed ", true);	
	}
	
	public void CancelLangSkill() {
		LanguageSkills.click();
		String UnFilresult=UnfilteredResult.getAttribute("innerHTML");
		Reporter.log("Unfiltered"  + UnFilresult +"  is displayed ", true);
	}
	
	public void ClickMSOffice() {
		MSOffice.click();
		
	}
	
    public void ClickShowMoreResult(WebDriver driver) {
    	String Lastresult1=MSOfficeResult.getText();
    	Reporter.log("Title of last displayed tile"+ Lastresult1, true);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView();", ShowMoreResult);
    	ShowMoreResult.click();
    	List<WebElement> tiles = driver.findElements(By.xpath("//a[contains(@class,'list-item')]"));
    	int total = tiles.size();
    	String Lastresult2=tiles.get(9).getText();
    	Reporter.log(total  +" more results are displayed ", true);
    	//Reporter.log("Title of last displayed tile"+Lastresult2, true);
    }

    public void SearchInput(WebDriver driver) {
    	SearchField.sendKeys("#warntiming");    }
    
    public void Warningtemplate(WebDriver driver) {
    	List<WebElement> templates = driver.findElements(By.xpath("//*[contains(@id,'typeahead-13-7860-option/div')]"));
    	int count=templates.size();
    	Reporter.log("Templates are Displayed ", true);
    }
    
    
	public void ClickSearchBUtton(WebDriver driver) {
		SearchButton.click();
	}
	
	public void WarnTimingResultNumber() {
		String result=Result.getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(result, 4);
		s.assertAll();
		Reporter.log(result +" is displayed ", true);
	}
	
	public void ClickWarntimingResult(WebDriver driver) {
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(WarntimingResult));
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView();", WarntimingResult);
		WarntimingResult.click();
	}
}
