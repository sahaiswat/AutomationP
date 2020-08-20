package com.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginPage;
	TestUtil testutil;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
	initialization();
	testutil= new TestUtil();
	loginPage =new LoginPage();
	homepage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void VerifyHomepageTitleTest()
	{
		String homepagetitle=homepage.ValidateHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO", "Homepage title not matched");
	}
	
	@Test(priority=2)
	public void VerifyUsernameLabelTest()
	{
		testutil.switchtoFrame();
		Boolean flag=homepage.ValidateHomePageUserName();
		Assert.assertTrue(flag);
	}
	
		
	@Test(priority=3)
	public void ClickOnDealsPagetest()
	{
		testutil.switchtoFrame();
		homepage.ClickOnDeals();
	}
	
	@Test(priority=4)
	public void ClickonContactsPageTest()
	{
		testutil.switchtoFrame();
	homepage.ClickOnContacts();
	}
	
	
	
	@AfterMethod
	public void CloseApplication()
	{
		TearDown();
	}
	

}
