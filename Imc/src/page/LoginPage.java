package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

		@FindBy (xpath="//input[@id='externalForm:login']")
		private WebElement UserName;
		@FindBy (xpath="//input[@id='externalForm:password']")
		private WebElement PassWord;
		@FindBy (xpath="//button[@id='externalForm:loginButtonAbsolute']")
		private WebElement LoginBTN;
		
		public LoginPage (WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void SetUserName(String un) {
			UserName.sendKeys(un);
		}
		
		public void SetPassWord(String pw) {
			PassWord.sendKeys(pw);
		}

		public void ClickLogin() {
			LoginBTN.click();
		}
	}


