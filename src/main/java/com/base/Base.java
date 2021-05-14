package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_Browser(String browserName) throws Exception {
		
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Test_keyword\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			Thread.sleep(300);
			}
		else {
			driver = new FirefoxDriver();
		}
		return driver;
		
	}
	
	public Properties init_Properties() {
		prop= new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\Test_keyword\\src\\main\\java\\com\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
	return prop;
	
	
	}
	
	
	

}
