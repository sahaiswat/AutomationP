package com.qa.testcase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DealsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class DealsPageTest extends TestBase {
	
	LoginPage loginPage;
	TestUtil testutil;
	HomePage homepage;
	DealsPage dealspage;
	String sheetname="Deals";
	
	public DealsPageTest()
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
		dealspage= homepage.ClickOnDeals();
		
	}
	
	
	@Test
	public void VerifyDealsLabelTest()
	{
		Assert.assertTrue( dealspage.VerifyDealsLabel(),"contacts label is mising on the page");
	}
	
		
	@DataProvider
	public Object[][] getNewDealsTestData()
	{
	Object data[][]=TestUtil.getTestData(sheetname);
	return data;
	}
	
	
	
	@Test(priority=1, dataProvider="getNewDealsTestData")
	public void CreateNewDealsTest(String salutation, String cname, String  probab, String  comm, String amt, String desc)
	{
		homepage.ClickonNewDeal();
		//dealspage.CreateNewDeals("Mr", "amazon", "20", "20", "100", "good", "Paint");
				
		dealspage.CreateNewDeals(salutation, cname, probab, comm, amt, desc);
	}
	
	
	@AfterMethod
	public void CloseApplication()
	{
		TearDown();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
