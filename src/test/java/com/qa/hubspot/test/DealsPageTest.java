package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class DealsPageTest extends BaseTest{
	
	
	@BeforeClass
	public void homePagesetUp() {
	homePage=	loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	dealsPage=homePage.goToDealssPage();
	
//	try {
//		Thread.sleep(5000);
//	} catch (InterruptedException e) {
//		
//		e.printStackTrace();
//	}
	}
	
	@Test(priority=1)
	public void verifyDealsPageTitle() {
		String title =dealsPage.getDealsPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.DEAlS_PAGE_TITLE);
		
	}
	
	@Test(priority =2)
	public void verifyDealsPageHeader() {
		String header =dealsPage.getDealsPageHeader();
		System.out.println(header);
		Assert.assertTrue(header.contains(Constants.DEALS_PAGE_HEADER));
	
	}
	
	@DataProvider
	public Object[][] getDealTestData(){
		Object data[][]=ExcelUtil.getTestData(Constants.DEALS_SHEET_NAME);
		return data;
	}
	@Test(dataProvider="getDealTestData")
	public void createDeals(String dealName, String dealAmount) {
		dealsPage.createDeal(dealName, dealAmount);
		System.out.println("Deals Created");
	}
//	@Test(priority =3)
//	public void createDeals(){
//		dealsPage.createDeal("Susmita1", "123");
//		System.out.println("Deals created");
//}
}
