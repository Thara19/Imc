package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class FWUtil {
	// to get data from xl
	public static String getXLData(String path, String sheet, int r, int c) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {
		String v="";
		try {
		Workbook wb=WorkbookFactory.create(new FileInputStream(path));
		v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return v;		
		}
	
	//counts the number of row
	public static int getRowCount(String path, String sheet){
		int count=0;
		try {
		Workbook wb=WorkbookFactory.create(new FileInputStream(path));
		count=wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
//	public static int getColumnCount(String path, String sheet){
//		int count=0;
//		try {
//		Workbook wb=WorkbookFactory.create(new FileInputStream(path));
//		count=wb.getSheet(sheet).; // dont know which method to use after getcolumn count
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return count;
//	}
	
	//enters value into excel sheet
	public static void setXLData(String path, String sheet, int r, int c, int v){
		// here instead of int v it is suppose to be Strig v, if u get error in some prog then change this and check
		try {
		Workbook wb=WorkbookFactory.create(new FileInputStream(path));
		wb.getSheet(sheet).getRow(r).getCell(c).setCellValue(v);
		wb.write(new FileOutputStream(path));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void getphoto(WebDriver driver, String path) {
		try {
			TakesScreenshot t=( TakesScreenshot) driver;
			File srcfile=t.getScreenshotAs(OutputType.FILE);
			File dstFile=new File(path);
			FileHandler.copy(srcfile, dstFile);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}			
		}
	
	
		
		
		
		
		
	}


