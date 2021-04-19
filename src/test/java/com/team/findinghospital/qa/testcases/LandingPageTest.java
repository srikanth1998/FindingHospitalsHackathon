 package com.team.findinghospital.qa.testcases;

import org.testng.SkipException;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;
import com.team.findinghospital.base.TestBase;
import com.team.findinghospital.pages.DiagnosticPage;
import com.team.findinghospital.pages.LandingPage;
import com.team.findinghospital.pages.SearchFilters;
import com.team.findinghospital.util.CaptureScreen;
import com.team.findinghospital.util.ExcelData;
import com.team.findinghospital.util.ExtetntReport;

/*
 *  This class used to test city name and choose hospital
 */
public class LandingPageTest extends TestBase {
	LandingPage landingPage;
	String LandinPageData[] = new String[2];
	public LandingPageTest() {
		super();
	}
	
	/*
	 * Method to test city name as 'Bangalore' in Search location Box  and to test Hospital in "Search doctors, clinics, hospitals, etc" Box
	 */
	@Test(groups={"smoke"})
	public void inputBoxTest() throws InterruptedException {
		try {
		logger = report.createTest("input box Test");
		landingPage.city(LandinPageData[0],logger);
		landingPage.type(LandinPageData[1],logger);
		}
		catch(Exception e) {
			e.printStackTrace();	 
			 }
		
		
	}

	/*
	 * Method to access Excel sheet and capture screenScreen
	 */
	@BeforeMethod
	public void setup() {
		try {
		initialization();
		landingPage = new LandingPage();
		ExcelData excelData = new ExcelData();
		LandinPageData  = excelData.readExcel();
		}
		catch(Exception e) {
			e.printStackTrace();	 
			 }
	}
	
	/*
	 *  Capture Screenshot and close Driver 
	 */
	@AfterMethod
	public void close() {
		try {
		report.flush();
		driver.quit();
		}
		catch(Exception e) {
			e.printStackTrace();	 
			 }
		}	
	
	
	
	
}
