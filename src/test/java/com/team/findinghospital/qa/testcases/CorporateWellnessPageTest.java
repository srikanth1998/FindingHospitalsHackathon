package com.team.findinghospital.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team.findinghospital.base.TestBase;
import com.team.findinghospital.pages.CorporateWellnessPage;
import com.team.findinghospital.pages.DiagnosticPage;
import com.team.findinghospital.pages.LandingPage;
import com.team.findinghospital.pages.SearchFilters;
import com.team.findinghospital.util.CaptureScreen;
import com.team.findinghospital.util.ExcelData;


/*
 * This class used To check Corporate Wellness, To schedule & capture the warning message from the alert by giving invalid data
 */
public class CorporateWellnessPageTest extends TestBase{
	
	CorporateWellnessPage corporateWellnessPage;
	DiagnosticPage diagnosticPage;
	SearchFilters searchFilters;
	
	String  name,organisation,Email, number ;

	public CorporateWellnessPageTest() {
		super();
	}
	
	    
	/*
	 * Method to access Excel sheet 
	 */
	@BeforeMethod
	public void setup() {
		try {
		initialization();
		corporateWellnessPage = new CorporateWellnessPage();
		diagnosticPage = new DiagnosticPage();
		searchFilters = new SearchFilters();
		ExcelData excelData = new ExcelData();
		FormDetails  = ExcelData.readExcel();	
		}
		catch(Exception e) {
			e.printStackTrace();	 
			 }
	}
	
	/*
	 * To schedule Demo by giving name, Organisation name, Email, number correct or not
	 */
	@Test(groups={"regression"})
	public void scheduleDem1()   {
		try {
		logger = report.createTest("scheduleDem1" );
		diagnosticPage.CorparateWellness(logger);
		corporateWellnessPage.scheduleDemo(FormDetails[2],FormDetails[3],FormDetails[4],FormDetails[5],logger );
		}
		catch(Exception e) {
			e.printStackTrace();	 
			 }
	}
	
	/*
	 * To schedule Demo by giving name, Organisation name, Email, number correct or not
	 */
	@Test(groups={"regression"})
	public void scheduleDemo2()   {
		try {
		logger = report.createTest("scheduleDemo2" );
		diagnosticPage.CorparateWellness(logger);
		corporateWellnessPage.scheduleDemo(FormDetails[6],FormDetails[7],FormDetails[8],FormDetails[9],logger );	
		}
		catch(Exception e) {
			e.printStackTrace();	 
			 }
	}
	
	/*
	 * To schedule Demo by giving name, Organisation name, Email, number correct or not
	 */
	@Test(groups={"regression"})
	public void scheduleDemo3()   {
		try {
		logger = report.createTest("scheduleDemo3" );
		diagnosticPage.CorparateWellness(logger);
		corporateWellnessPage.scheduleDemo(FormDetails[10],FormDetails[11],FormDetails[12],FormDetails[13],logger );	
		}
		catch(Exception e) {
			e.printStackTrace();	 
			 }
	}
	
	/*
	 * To schedule Demo by giving name, Organisation name, Email, number correct or not
	 */
	@Test(groups={"regression"})
	public void scheduleDemo4()   {
		try {
		logger = report.createTest("scheduleDemo4" );
		diagnosticPage.CorparateWellness(logger);
		corporateWellnessPage.scheduleDemo(FormDetails[14],FormDetails[15],FormDetails[16],FormDetails[17],logger );
		}
		catch(Exception e) {
			e.printStackTrace();	 
			 }
	}
	
	@AfterMethod
	public void close(){
		try {
		
		CaptureScreen.screenShot();
		//corporateWellnessPage.sleep();
		driver.quit();
		report.flush();
		}
	catch(Exception e) {
		e.printStackTrace();	 
		 }
}

	
	
	 	
}
