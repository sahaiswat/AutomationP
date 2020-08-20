package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage= new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title=loginPage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.", "Loginpage title not matched");
	}
	
	@Test(priority=2)
	public void CRMLogoImageTest()
	{
		Boolean flag=loginPage.ValidateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LoginTest()
	{
		loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void CloseApplication()
	{
		TearDown();
	}

}
