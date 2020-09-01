package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage {
	private WebDriver driver;
	ElementUtil elementUtil;
	public String name;
	
	private By header = By.xpath("//h1[contains(@class,'IndexPageRedesignHeader')]");
	private By createContactPrimary = By.xpath("//span[text()='Create contact']");
	private By email = By.xpath("//input[@id='UIFormControl-31']");
	private By firstName = By.xpath("//input[@id='UIFormControl-33']");
	private By lastName = By.xpath("//input[@id='UIFormControl-37']");
	private By jobTitle = By.xpath("//input[@id='UIFormControl-45']");
	private By createContactSecondary = By.xpath("(//span[text()='Create contact'])[position()=2]");
	private By contactsBackLink = By.xpath("(//*[text()='Contacts'])[position()=2]");
	
//	private By firstNameLastName = By.xpath("(//span[contains(@class, 'truncate-text')])[position()=1]");
	
	public ContactsPage(WebDriver driver) {
		elementUtil= new ElementUtil(driver);
		this.driver=driver;
	}
	
	public String getContactsPageTitle() {
	return	elementUtil.waitForTitlePresent(Constants.CONTACTS_PAGE_TITLE, 10);
	}
	
	public String getContactsPageHeader() {
	elementUtil.waitForElementPresent(header, 10);
			return(elementUtil.doGetText(header));
		
	}
	
	public void createContact(String email, String firstName, String lastName, String jobTitle) {
		
		elementUtil.clickWhenReady(createContactPrimary, 10);
		elementUtil.waitForElementToBeVisible(this.email, 10);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.waitForElementToBeVisible(this.jobTitle, 10);
		elementUtil.doSendKeys(this.jobTitle, jobTitle);
		elementUtil.doClick(createContactSecondary);
//		name=elementUtil.doGetText(firstNameLastName);
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		elementUtil.clickWhenReady(contactsBackLink, 10);
//		return name;
	}

}
