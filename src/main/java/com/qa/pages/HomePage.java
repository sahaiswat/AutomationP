package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	HomePage homepage;
	
 @FindBy(xpath="(//td[contains(.,'User: Demo User')])[2]")
 @CacheLookup
 WebElement usernamelabel;
 
 @FindBy(xpath="//a[contains(text(),'Contacts')]")
 WebElement contactslink;
 
 @FindBy(xpath="//a[contains(text(),'Deals')]")
 WebElement dealslink;
 
 @FindBy(xpath="//a[contains(@title,'New Contact')]")
 WebElement NewContactLink;
 
 @FindBy(xpath="//a[contains(@title,'New Deal')]")
 WebElement NewDealLink;
 
 public HomePage() {
	 
	 PageFactory.initElements(driver, this);
		
	}
 public String ValidateHomePageTitle()
 {
	return driver.getTitle();
 }
 
 public boolean ValidateHomePageUserName()
 {
	 return usernamelabel.isDisplayed();
	 
 }
 
 public ContactsPage ClickOnContacts()
 {
	 contactslink.click();
	 return new ContactsPage();
 }
 
 public DealsPage ClickOnDeals()
 {
 
 dealslink.click();
 return new DealsPage();
}
 
 public void ClickonNewContact()
 { 
 Actions action=new Actions(driver);
 action.moveToElement(contactslink).build().perform();
 NewContactLink.click();

 }
 
 public void ClickonNewDeal()
 { 
 Actions action=new Actions(driver);
 action.moveToElement(dealslink).build().perform();
 NewDealLink.click();
 
 }
}
