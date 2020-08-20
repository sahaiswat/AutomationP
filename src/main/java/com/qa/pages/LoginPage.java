package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(.,'Sign Up')]")
	WebElement signupbtn;
	
	@FindBy(xpath = "//img[@src='https://classic.freecrm.com/img/logo.png']")
	WebElement crmlogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
		
	}

	public boolean ValidateCRMImage() 
	
	{
	return crmlogo.isDisplayed();
    }
	
	public HomePage Login(String userid, String pwd)
	{
		username.sendKeys(userid);
		password.sendKeys(pwd);

		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click();", loginbtn);
		return new HomePage();
				
	}
	
}
