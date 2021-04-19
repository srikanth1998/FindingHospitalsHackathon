package com.team.findinghospital.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team.findinghospital.base.TestBase;
import com.team.findinghospital.pages.LandingPage;
import com.team.findinghospital.util.CaptureScreen;
import com.team.findinghospital.util.ExcelData;
import com.team.findinghospital.util.WriteToExcel;

/*
 * This class used to validate URL
 */
public class URLTest extends TestBase {
	
	public URLTest() {
		super();
	}
	
	/*
	 * Method to access Excel sheet and initialization method
	 */
	@BeforeMethod
	public void setup() {
		try {
		initialization();
		ExcelData excelData = new ExcelData();
		LandinPageData = ExcelData.readExcel();
		}
		catch(Exception e) {
			e.printStackTrace();	 
			 }
		
		
	}
	
	/*
	 * Method used to test with valid URL
	 */
	@Test(groups={"regression"})
	public void validURLTest() {
		try {
		logger = report.createTest("validURLTest" );
		super.URLNavigation(LandinPageData[18]);
		}
		catch(Exception e) {
			e.printStackTrace();	 
			 }
		
	}
	
	/*
	 * Method used to test with Invalid URL
	 */
	@Test(groups={"regression"})
	public void invalidURLTest() {
		try {
		logger = report.createTest("invalidURLTest" );
		super.URLNavigation(LandinPageData[19]);
		}
		catch(Exception e) {
			e.printStackTrace();	 
			 }
		
	}
	
	/*
	 *  close Driver 
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
