package com.qa.testcase;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	TestUtil testutil;
	HomePage homepage;
	ContactsPage contactpage;
	String sheetname="Contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialization();
		testutil= new TestUtil();
		loginPage =new LoginPage();
		homepage= loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchtoFrame();
		contactpage= homepage.ClickOnContacts();
		
	}
	
		
	@Test
	public void VerifyContactsLabelTest()
	{
		Assert.assertTrue(contactpage.VerifyContactsLabel(),"contacts label is mising on the page");
	}
	
	
	@DataProvider
	public Object[][] getNewContactTestData()
	{
	Object data[][]=TestUtil.getTestData(sheetname);
	return data;
	}
	
	@Test(priority=1, dataProvider="getNewContactTestData")
	public void CreateNewContacttest(String salutation, String fname, String lastname, String companyname)
	{
		homepage.ClickonNewContact();
		//contactpage.CreateNewContact("Mr", "test1", "test2", "brave");
		contactpage.CreateNewContact(salutation, fname, lastname, companyname);
	}
	
	@AfterMethod
	public void CloseApplication()
	{
		TearDown();
	}
	
	
	
	
	
	
	
	
	
	

}
