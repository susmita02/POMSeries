package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class DealsPage extends BasePage {
	private WebDriver driver;
	ElementUtil elementUtil;
	public String name;
	
	private By header = By.xpath("//span[text()='Deals']");
	private By createDealPrimary = By.xpath("//span[text()='Create deal']");
	private By dealName = By.id("UIFormControl-19");
	private By dealAmount = By.id("UIFormControl-27");
	private By createDealSecondary= By.xpath("//*[text()='Create']");
	private By dealBackClick= By.xpath("(//*[text()='Deals'])[position()=2]");
	
	
	public DealsPage(WebDriver driver) {
		elementUtil= new ElementUtil(driver);
		this.driver=driver;
	}
	
	public String getDealsPageTitle() {
	return	elementUtil.waitForTitlePresent(Constants.DEAlS_PAGE_TITLE, 10);
	}
	
	public String getDealsPageHeader() {
	elementUtil.waitForElementPresent(header, 10);
			return(elementUtil.doGetText(header));
		
	}
	
	public void createDeal(String dealName, String dealAmount) {
		
		elementUtil.clickWhenReady(createDealPrimary, 10);
		elementUtil.waitForElementToBeVisible(this.dealName, 10);
		elementUtil.doSendKeys(this.dealName, dealName);
		elementUtil.doSendKeys(this.dealAmount, dealAmount);
		elementUtil.doClick(createDealSecondary);
		elementUtil.clickWhenReady(dealBackClick, 10);
//		elementUtil.waitForElementToBeVisible(this.dealBackClick, 10);
//		elementUtil.doClick(dealBackClick);
		System.out.println("Back button clicked");
	}

}
