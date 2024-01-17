package page;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class ClientPage {
	@FindBy (id="contentframe")
	private WebElement frame1;
	@FindBy (id="iframe_navi:1243")
	private WebElement frame2;
	@FindBy (id="iframe_edit.200.911366")
	private WebElement frame3;

	@FindBy (xpath="//input[@id='searchTerm-inputEl']")
	private WebElement SearchInput;
	@FindBy (xpath="//a[@id='startSearchButton']")
	private WebElement SearchIcon;
	@FindBy (xpath="//a[@id='tbb_editGroup']")
	private WebElement EditClient;
	@FindBy (xpath="//span[@id='tbi_edit_global-textEl']")
	private WebElement GlobalEdit;
	@FindBy (xpath="//*[@id=\"tab-1013\"]")
	private WebElement Settings;
	@FindBy (xpath="//input[@id='enrollment.warningForTimeConflicts-inputEl']")
	private WebElement WarningTimeCheckBox;
	
	
	public ClientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ClientEdit(WebDriver driver) {
		driver.switchTo().frame(frame1);
	    driver.switchTo().frame(frame2);
	   // SearchInput.sendKeys("Client");
	   // WebDriverWait wait = new WebDriverWait(driver, 15);
	    //wait.until(ExpectedConditions.elementToBeClickable(SearchIcon)).click();
	    List<WebElement> rowsele = driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[1]/div[2]/div/table/tbody/tr"));
	    rowsele.get(0).click();
	    
		EditClient.click();
		GlobalEdit.click();
		
	}

	public void WarningTimeConflictUncheck(WebDriver driver) throws InterruptedException {
		
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
	ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tab.get(1));   
   driver.switchTo().frame(frame1);  
   driver.switchTo().frame(frame3);
   Thread.sleep(2000);
   Settings.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", WarningTimeCheckBox);
	boolean check = WarningTimeCheckBox.isSelected();
	Assert.assertEquals(check, false);
	Reporter.log("Warning of time conflicts is unchecked as default, its boolean value is:"+check, true);
		
	}
	
	public void WarningTimeConflictCheck(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
	    driver.switchTo().window(tab.get(1));   
	   driver.switchTo().frame(frame1);  
	   driver.switchTo().frame(frame3);
	   Thread.sleep(6000);
	   WebDriverWait wait = new WebDriverWait(driver, 15);
	   wait.until(ExpectedConditions.elementToBeClickable(Settings));
	   Settings.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", WarningTimeCheckBox);
		WarningTimeCheckBox.click();
		boolean check = WarningTimeCheckBox.isSelected();
		//Assert.assertEquals(check, true);
		Reporter.log("Warning of time conflicts is Checkedand its boolean value is:"+check, true);
			
		}
	
	public void SwitchtoFrontPage(WebDriver driver) {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
	    driver.close();
	    driver.switchTo().window(tab.get(0));	    
	}
}
