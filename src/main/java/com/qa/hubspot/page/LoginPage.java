package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
//	By locators
	
	private By emailId = By.id("username");
	private By password = By.id("password");
	private By loginButton = By.id("loginBtn");
	private By signUpLink = By.linkText("Sign up");
	private By privacyPolicy = By.linkText("Privacy Policy");
//	Constructor of the page
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}
	
//	Page Actions
	
	public String getLoginPageTitle() {
//		return driver.getTitle();
	return	elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	public boolean isSignUpLinkExist() {
//		return driver.findElement(signUpLink).isDisplayed();
	return	elementUtil.doIsDisplayed(signUpLink);
	}
	
	public boolean isPrivacyPolicyLinkExist() {
//		return driver.findElement(privacyPolicy).isDisplayed();
		return elementUtil.doIsDisplayed(privacyPolicy);
	}
	public HomePage doLogin(String un, String pwd) {
//		driver.findElement(emailId).sendKeys(un);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginButton).click();
		
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		
		return new HomePage(driver);
		
	}
	
	
}
