package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() 
	{
		prop= new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream
					("C:\\Users\\ssinha\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\qa\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			}
		} catch (IOException e) {
					e.printStackTrace();
		}
			
	}
	
	public static void initialization()
	{
		prop.getProperty("browser");
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ssinha\\\\Desktop\\\\driver\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	public void TearDown()
	{
		driver.quit();
	}

}
