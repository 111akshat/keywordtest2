package com.KeywordEngine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import com.base.Base;

public class keywordEngine {
	
	public WebDriver driver;
	public Properties prop;
	public Base base;
	
	public static Workbook book;
	public static Sheet sheet;
	 String locatorName= null;
	 String locatorValue= null;
	
	
	
	public final String Excel_path = "C:\\Users\\HP\\eclipse-workspace\\Test_keyword\\src\\main\\java\\com\\excel_file\\Test_Excel.xlsx";
	
	
	public void StartExecution(String sheetName){
		
	
		
		FileInputStream file = null;
		
		try {
			file= new FileInputStream(Excel_path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet= book.getSheet(sheetName);
		int k=0;
		try {
		for (int i=0; i < sheet.getLastRowNum(); i++) {
			
			String locatorColValue= sheet.getRow(i + 1).getCell(k+1).toString().trim();
			if (!locatorColValue.equalsIgnoreCase("NA")) 
				{
				locatorName = locatorColValue.split("=")[0].trim();
				locatorValue =locatorColValue.split("=")[1].trim();
				}
			String action = sheet.getRow(i+1).getCell(k+2).toString().trim();
			String value = sheet.getRow(i+1).getCell(k+3).toString().trim();
		
		switch (action) {
		
		case "open browser":
			base = new Base();
			prop = base.init_Properties();
			if (value.isEmpty() || value.contentEquals("NA")) {
				driver = base.init_Browser(prop.getProperty("browser"));
				}
			else {
				driver = base.init_Browser(value);
			}
			break;

		default:
			break;
		
	}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		}
	
}	
		
		
	
	
	

