package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	
	
	
	@Test(priority=2)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=1)
	public void verifySignUpLinkTest() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(loginPage.isSignUpLinkExist());
	
	}
	@Test(priority=3)
	public void verifyPrivacyPolicyLinkTest() {
		Assert.assertTrue(loginPage.isPrivacyPolicyLinkExist());
	
	}
	
	@Test(priority=4)
	public void verifyLoginPageTest() {
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	
	}
	
	

}
