package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long Page_Load_Timeout=20;
    public static long Implicit_Wait=10;
    static XSSFWorkbook wb;
    static XSSFSheet sheet;
    public static String TestData_Sheet_Path="C:\\Users\\ssinha\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\qa\\testdata\\FreeCrmTestData.xlsx";
     
    public void switchtoFrame()
    
    {
       	driver.switchTo().frame("mainpanel");
    }
    
    public static Object[][]getTestData(String sheetname)
    {
    	FileInputStream fis=null;
    			try {
					fis=new FileInputStream(TestData_Sheet_Path);
				} catch (FileNotFoundException e) {
				
					e.printStackTrace();
				}
    	try {
			wb=new XSSFWorkbook(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	sheet=wb.getSheet(sheetname);
    			
    		Object [][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    		for (int i=0; i<sheet.getLastRowNum(); i++) {
    			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
    			{
    				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
    			
    			}
    		}
    		return data;	
    }
    
public static void capturescreenshot(WebDriver driver)	{
		
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("./Screenshots/Amazon"+getCurrentDateTime()+".png"));
			System.out.println("Screenshot Captured");
		} catch (IOException e) {
			
			System.out.println("Screenshot not captured"+e.getMessage());
		}
		
		
	}
public static String getCurrentDateTime()
{
	DateFormat format= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	Date currentdate=new Date();
	return format.format(currentdate);
}

}
