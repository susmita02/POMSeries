package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	public static ThreadLocal<WebDriver>tlDriver = new ThreadLocal<WebDriver>();
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
//			driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());	
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		else if(browserName.equalsIgnoreCase("ie")) {
		
			WebDriverManager.iedriver().setup();
//			driver = new InternetExplorerDriver();
			tlDriver.set(new InternetExplorerDriver());
		}
		else {
			System.out.println("No browser found");
		}
		
//	driver.manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	getDriver().get(prop.getProperty("url"));
		 
	return getDriver();
	}
	
	/**
	 * getDriver usring threadlocal
	 */
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 * properties call function
	 * @return
	 */
	
    public Properties init_prop() {
    prop= new Properties();
    String env = null;
    String path = null;
    
   env= System.getProperty("env");
   System.out.println("Running on environment: " +env);
    
    if(env==null) {
    	path =".\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties";
    }
    else {
    	switch (env) {
    	case "qa":
			path =".\\src\\main\\java\\com\\qa\\hubspot\\config\\config.qa.properties";
			break;
			
		case "dev":
			path =".\\src\\main\\java\\com\\qa\\hubspot\\config\\config.dev.properties";
			break;
		default:
			System.out.println("No env property available");
			break;
		}
    }
		try {
		FileInputStream ip = new FileInputStream(path);
		prop.load(ip);
	} catch (FileNotFoundException e) {
			e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return prop;
}
	
	
	/**
	 * This method is used to take screenshot
	 * @return 
	 */
	
	public String getScreenshot() {
		File src= ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+ "/screenshots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return path;
	}
	
	
	
	
}
