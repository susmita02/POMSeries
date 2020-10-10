package com.qa.hubspot.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactsPageTest extends BaseTest{
	
	
	@BeforeClass
	public void homePagesetUp() {
	homePage=	loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	contactsPage=homePage.goToContactsPage();
	
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@Test(priority=1)
	public void verifyContactsPageTitle() {
		String title =contactsPage.getContactsPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
		
	}
	
	@Test(priority =2)
	public void verifyContactsPageHeader() {
		String header =contactsPage.getContactsPageHeader();
		System.out.println(header);
		Assert.assertTrue(header.contains(Constants.CONTACTS_PAGE_HEADER));
	
	}
	
	@DataProvider
	public Object[][] getContactTestData() {
		Object data[][]=ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
		return data;
	}

	@Test(dataProvider="getContactTestData")
	public void createContacts(String email, String firstName, String lastName) {
		contactsPage.createContact(email, firstName, lastName);
		System.out.println("Contact created");
}
//	@Test(priority=3)
//	public void createContacts() {
//		contactsPage.createContact("susmita@gmail.com", "Susmita", "Panda", "QA");
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//		Assert.assertEquals(contactsPage.getName(), "test1 test1");
	
}
