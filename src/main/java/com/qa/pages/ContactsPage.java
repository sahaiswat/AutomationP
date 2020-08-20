package com.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="surname")
	WebElement surname;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(name="client_lookup")
	WebElement client_lookup;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement savebtn;
		
	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean VerifyContactsLabel()
	{
		return contactslabel.isDisplayed();
	}
	
	public void CreateNewContact(String salutation, String fname, String lastname, String companyname)
	{
		Select select=new Select(title);
		select.selectByVisibleText(salutation);
		firstname.sendKeys(fname);
		surname.sendKeys(lastname);
		client_lookup.sendKeys(companyname);
		savebtn.click();
	}
	
}

