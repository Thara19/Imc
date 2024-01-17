package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst {
	public WebDriver driver;
	
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
		
	@BeforeMethod
	public void openApp() {
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(URL);
	
		
	}
	
	public static int passcount=0, failcount=0;
	@AfterMethod
		public void closeApp(ITestResult res) {
			String testname=res.getName();
			int status=res.getStatus();
			if(status==1) {
				
				passcount++;
			}
			else {
				
				failcount++;
				String path=PHOTO_PATH+testname+".png";
				Reporter.log("Photopath:"+path,true);
				FWUtil.getphoto(driver, path);
			}
		}
	
		
		@AfterSuite
		public void print() {
			Reporter.log("PassCount:"+passcount,true);
			Reporter.log("failCount:"+failcount,true);
			FWUtil.setXLData(REPORT_PATH, "Sheet1", 1, 0, passcount);
			FWUtil.setXLData(REPORT_PATH, "Sheet1", 1, 1, failcount);
		}
	}



