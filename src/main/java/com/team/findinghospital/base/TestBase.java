package com.team.findinghospital.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.team.findinghospital.util.ExtetntReport;
import com.team.findinghospital.util.TestUtil;

/*
 *  This Class used to access  browsers    
 */
public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public ExtentReports report = ExtetntReport.getReportInstance();
	public ExtentTest logger;
	protected String FormDetails[] = new String[100];
	protected String LandinPageData[] = new String[100];
	

	/*
	 * Method used to get link
	 */
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\welcome\\eclipse-workspace\\findinghospital1\\src\\main\\java\\com\\team\\findinghospital\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Method used to choose browser
	 */
	public static void initialization(){
		//String browserName = prop.getProperty("browser");
		try {
		int  browserChoice =3;
		if (browserChoice == 1) {
			driver = DriverSetup.setChromeDriver();
		} else if (browserChoice == 2) {
			driver = DriverSetup.setIEDriver();
		} else if (browserChoice == 3) {
			driver = DriverSetup.setEdgeDriver();
		} else if (browserChoice == 4) {
			driver = DriverSetup.setFireFoxDriver();
		} else {
			System.out.println("Invalid data...");
		}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,60);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//flutWeight();
		driver.get(prop.getProperty("url"));
		}
		catch(Exception e) {
			e.printStackTrace();	 
		}

}
	public void URLNavigation(String url) {
		try {
			logger.log(Status.INFO, "url entered");

		driver.get(url);
		}
		catch(Exception e) {
			e.printStackTrace();	 
		}

	}
	
	public Wait<WebDriver> fluentWeight() {
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		return wait1;
		}
}
