package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.hubspot.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	public static String flashElement;
	/**
	 * browser initialize function
	 * @param browserName
	 * @return driver
	 */
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName =prop.getProperty("browser");
		System.out.println("Browser name is : " +browserName);
		optionsManager = new OptionsManager(prop);
		flashElement= prop.getProperty("highlight").trim();
		
	if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsManager.getChromeOptions());
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());	
			
		}
		else if(browserName.equalsIgnoreCase("ie")) {
		
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("No browser found");
		}
		
//	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
		 
	return driver;
	}
	
	/**
	 * properties call function
	 * @return
	 */
	
    public Properties init_prop() {
    	
	prop= new Properties();
	
	try {
		FileInputStream ip = new FileInputStream(".\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
			e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return prop;
}
	
	
	
	
	
	
	
	
	
}
