package page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class DetailsPage {
	@FindBy (xpath="//button[@id=\"courseInfoButton_863640_enrolCourse\"]")
	private WebElement Enrol;
	@FindBy (xpath="//div[contains(@id,'mycourses_enrol_reveal')]")
	private WebElement Popup;
	@FindBy (xpath="//*[@id=\"mycourses_enrol_reveal_863640\"]/div[2]/ng-component/div/div[2]/imc-dynamic-form/div/form/div/div[1]/imc-button")
	private WebElement Cancelbutton;
	@FindBy (xpath="//*[@id=\"mycourses_enrol_reveal_863633\"]/div[2]/ng-component/div/div[2]/imc-dynamic-form/div/form/div/div[2]/imc-button")
	private WebElement EnrolAlertButton;


	public DetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickEnrol(WebDriver driver) {
		String actual=driver.getTitle();
		//Reporter.log(actual, true);
		//Assert.assertEquals("IMC Learning Suite - Catalogue", actual);
		
		Enrol.click();
	}
	
	public void DismissAlert(WebDriver driver)  {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Cancelbutton));
		Cancelbutton.click();
		}
	
	public void GetAlertText(WebDriver driver, String eText) {
		String s1=driver.findElement(By.xpath("//*[@id='mycourses_enrol_reveal_863640']/div[2]/ng-component/div/div[1]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(s1, eText);;
		s.assertAll();
		
	}
	
	public void EnrolinAlert(WebDriver driver)  {
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(EnrolAlertButton));
		//EnrolAlertButton.click();
		System.out.println("This is the last step, clicking enrol will enrol to course and for further run enrol will not be available ");
			
		}
		
		}
	

