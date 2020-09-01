package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.hubspot.page.ContactsPage;
import com.qa.hubspot.page.DealsPage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;

public class BaseTest {
	
	
	public WebDriver driver;
	public Properties prop;
	public BasePage basePage ;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	public DealsPage dealsPage;
	
	@Parameters({"browser"})
//	
//	@BeforeTest
//	public void setUp(String browserName) {
//		
//		System.out.println("Browser name is : " +browserName);
//		basePage= new BasePage();
//		prop =basePage.init_prop();
//		prop.setProperty("browser", browserName);
//        driver = basePage.init_driver(prop);
//		loginPage = new LoginPage(driver);
//	}

	@BeforeTest
	public void setUp() {
		
		basePage= new BasePage();
		prop =basePage.init_prop();
        driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
