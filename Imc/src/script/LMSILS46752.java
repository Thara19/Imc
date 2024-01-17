package script;

import org.testng.annotations.Test;
import generic.BaseTest;
import generic.FWUtil;
import page.CateloguePage;
import page.Dashboard927747Page;
import page.FrontPage;
import page.LoginPage;
import page.UserProfilePage;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

public class LMSILS46752 extends BaseTest{
	@Test(priority=1)
	public void LMSILS46752test() throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException  {
		String un=FWUtil.getXLData(XL_PATH, "Sheet1", 1, 0);
		String pw=FWUtil.getXLData(XL_PATH, "Sheet1", 1, 1);
		String eTitle=FWUtil.getXLData(XL_PATH, "Sheet1", 1, 2);
		String newURL=FWUtil.getXLData(XL_PATH, "Sheet1", 1, 3);
		String ePanelTitle=FWUtil.getXLData(XL_PATH, "Sheet1", 1, 4);
		
		LoginPage l=new LoginPage(driver);
		l.SetUserName(un);
		l.SetPassWord(pw);
		l.ClickLogin();
		
		FrontPage FP=new FrontPage(driver);
		FP.VerifyFrontPageIsDisplayed(driver, eTitle);  //Verify Successful login
		
		FP.DashboardID927747(driver, newURL); //Navigating to Dashboardid 927747s
		
		Dashboard927747Page DB927747 = new Dashboard927747Page(driver);
		DB927747.TextClassificationsPanel(driver, ePanelTitle); //Classification panel is displayed
		
		DB927747.CatalogueLoads(driver); //Catalog content loads
		
		CateloguePage Catalogue=new CateloguePage(driver);
		Catalogue.BreadcrumbDashboard(driver);// Dashboard Breadcrumb elemnt		
		DB927747.TextClassificationsPanel(driver, ePanelTitle); //Navigate back and Classification panel is displayed
		
		DB927747.ClickLanguageSkills(); 
		Catalogue.Result(); //Lang skill is preset & 1 result is displayed
		
		Catalogue.CancelLangSkill(); // Remove Lang filter and unfiltered result is displayed
		
		Catalogue.BreadcrumbDashboard(driver);
		DB927747.CardsDisplay();// Classsification cards are displayed
		
		Catalogue.ClickMSOffice();
		Catalogue.Result(); //MSOffice is present and result is displayed
		
		Catalogue.ClickShowMoreResult(driver); // MSOffice more results are loaded
		
		UserProfilePage UserProfile=new UserProfilePage(driver);
		UserProfile.ClickUserProfile();
		UserProfile.ClickSignOut();
		UserProfile.LogoutSucessfull(driver, URL);// User logout successful
		UserProfile.DriverClose(driver);
}
}


