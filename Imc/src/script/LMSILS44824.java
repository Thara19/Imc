package script;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.CateloguePage;
import page.ClientPage;
import page.DetailsPage;
import page.FrontPage;
import page.LoginPage;
import page.UserProfilePage;

public class LMSILS44824 extends BaseTest{
	@Test(priority=1)
	public void LMSILS46752test() throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException, InterruptedException, AWTException  {
		String Superun=FWUtil.getXLData(XL_PATH, "Sheet1", 2, 0);
		String Superpw=FWUtil.getXLData(XL_PATH, "Sheet1", 2, 1);
		String eTitle=FWUtil.getXLData(XL_PATH, "Sheet1", 1, 2);
		String un=FWUtil.getXLData(XL_PATH, "Sheet1", 3, 0);
		String pw=FWUtil.getXLData(XL_PATH, "Sheet1", 3, 1);
		String eText=FWUtil.getXLData(XL_PATH, "Sheet1", 1,5);
		
		
		LoginPage l=new LoginPage(driver);
		FrontPage FP=new FrontPage(driver);		
		ClientPage CP=new ClientPage(driver);
		UserProfilePage UserProfile=new UserProfilePage(driver);
	    DetailsPage Details=new DetailsPage(driver); 
	    CateloguePage Catalogue=new CateloguePage(driver);
	    
		l.SetUserName(Superun);
		l.SetPassWord(Superpw);
		l.ClickLogin(); // user login
		

			
		FP.ClickDropdownHandle();
		FP.ClickAdmin(); 
		FP.ClickPeople();
		FP.ClickClients();  //Navigate to Clients path
		

		CP.ClientEdit(driver);// Edit Selected Client
		
		CP.WarningTimeConflictCheck(driver); // Warning time conflict is unchecked by default
		
		CP.SwitchtoFrontPage(driver);
		

		UserProfile.ClickUserProfile();
		UserProfile.ClickSignOut();
		UserProfile.LogoutSucessfull(driver, URL);// Super User logout successful
		
	    l.SetUserName(un);
		l.SetPassWord(pw);
		l.ClickLogin(); //login as warning user
		
		
		FP.ClickCatalogue();
		Catalogue.SearchInput(driver);
		Catalogue.Warningtemplate(driver);
	    Catalogue.Result();
	    Catalogue.ClickSearchBUtton(driver); //Search for Warntiming and results are displayed
	    
	    Catalogue.ClickWarntimingResult(driver);
	    

	    Details.ClickEnrol(driver); // Details page is displayed
	    
	    Details.DismissAlert(driver); // cancel Enrol
	    
	    
		UserProfile.ClickUserProfile();
		UserProfile.ClickSignOut();
		UserProfile.LogoutSucessfull(driver, URL);// Warning User logout successful **/
	    
        l.SetUserName(Superun);
		l.SetPassWord(Superpw);
		l.ClickLogin();
		
		
			
		FP.ClickDropdownHandle();
		FP.ClickAdmin(); 
		FP.ClickPeople();
		FP.ClickClients();  //Navigate to Clients path
		
		
		CP.ClientEdit(driver);// Edit Selected Client
		
		CP.WarningTimeConflictCheck(driver); // Warning time conflict is Checked
		
		CP.SwitchtoFrontPage(driver);
	    
		
		UserProfile.ClickUserProfile();
		UserProfile.ClickSignOut();
		UserProfile.LogoutSucessfull(driver, URL); // Super User logout successful after warningtimecheck **/
		
		l.SetUserName(un);
		l.SetPassWord(pw);
		l.ClickLogin(); //login as warning user
		
		
		FP.ClickCatalogue();
		
		Catalogue.SearchInput(driver);
		Catalogue.Result();
	    Catalogue.ClickSearchBUtton(driver); //Search for Warntiming and results are displayed
	    
	    Catalogue.ClickWarntimingResult(driver);
	    
	  
	    Details.ClickEnrol(driver); // Details page is displayed
	    Details.GetAlertText(driver, eText); //Comparing text in popup
	    Details.DismissAlert(driver); //back to details page
	    
	    Details.ClickEnrol(driver);
	    Details.EnrolinAlert(driver); // course enrol
	    
	    
}
} 
