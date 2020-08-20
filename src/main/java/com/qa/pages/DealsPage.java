package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class DealsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement dealslabel;
		
	@FindBy(name="probability")
	WebElement probability;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(name="amount")
	WebElement amount;
	
	@FindBy(name="commission")
	WebElement commission;
	
	@FindBy(name="product_id")
	WebElement productid;
	
	@FindBy(name="description")
	WebElement description;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement savebtn;
	
	
	public DealsPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	
	public boolean VerifyDealsLabel()
	{
		return dealslabel.isDisplayed();
	}
	
	
	
	public void CreateNewDeals (String salutation, String cname, String probab, String comm, String amt, String desc)
	{
		title.sendKeys(salutation);
		company.sendKeys(cname);
		probability.sendKeys(probab);
		commission.sendKeys(comm);
		amount.sendKeys(amt);
		description.sendKeys(desc);
		//Select select=new Select(productid);
		//select.selectByVisibleText(product);
		savebtn.click();
	}
}
