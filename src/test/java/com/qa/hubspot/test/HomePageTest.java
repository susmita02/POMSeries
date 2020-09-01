package com.qa.hubspot.test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;


public class HomePageTest extends BaseTest{
 
	@BeforeClass
	public void homePagesetUp() {
	homePage=	loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyHomePageHeaderTest() {
		String header = homePage.getHeaderValue();
		System.out.println(header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}
	

	@Test(priority=3)
	public void verifyAccountTest() {
		String accountName = homePage.getAccountName();
		System.out.println(accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname").trim());
	}
	
	@Test(priority=4)
	public void verifySettingsIconTest() {
	
		Assert.assertTrue(homePage.isSettingIconExist());
	}
	

}
