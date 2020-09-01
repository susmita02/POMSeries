package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
//	By Locator
	
	private By header = By.tagName("h1");
	private By accountName = By.cssSelector("span.account-name");
	private By settingsIcon = By.id("navSetting");
	
	
	private By contactsParentMenu = By.id("nav-primary-contacts-branch");
	private By contactsSubMenu = By.id("nav-secondary-contacts");
	
	private By salesMenu = By.xpath("(//a[@id='nav-primary-sales-branch'])[position()=1]");
	private By dealsMenu = By.xpath("(//a[@id='nav-secondary-deals'])[position()=1]");
	
//	Constructor
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}
	
//	Page Actions

	public String getHomePageTitle() {
//		return driver.getTitle();
		return elementUtil.waitForTitlePresent(Constants.HOME_PAGE_TITLE, 10);
	}
	
	public String getHeaderValue() {
//		if(driver.findElement(header).isDisplayed()) {
//			return driver.findElement(header).getText();
//		}
//		return null;
		
		if(elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}
	
	public String getAccountName() {
//		if(driver.findElement(accountName).isDisplayed()) {
//			return driver.findElement(accountName).getText();
//		}
//		return null;
		
		if(elementUtil.doIsDisplayed(accountName)) {
			return elementUtil.doGetText(accountName);
		}
		return null;
	}
	
	public boolean isSettingIconExist() {
//		return driver.findElement(accountName).isDisplayed(); 
		return elementUtil.doIsDisplayed(settingsIcon);
		
	}
	
	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	private void clickOnContacts() {
		elementUtil.waitForElementPresent(contactsParentMenu, 10);
		elementUtil.doClick(contactsParentMenu);
		elementUtil.waitForElementPresent(contactsSubMenu, 10);
		elementUtil.doClick(contactsSubMenu);
		
	}
	
	public DealsPage goToDealssPage() {
		clickOnDeals();
		return new DealsPage(driver);
	}
	
	private void clickOnDeals() {
		elementUtil.waitForElementPresent(salesMenu, 10);
		elementUtil.doClick(salesMenu);
		elementUtil.waitForElementPresent(dealsMenu, 10);
		elementUtil.doClick(dealsMenu);
		elementUtil.doClick(salesMenu);
		elementUtil.doClick(dealsMenu);
	}
}
