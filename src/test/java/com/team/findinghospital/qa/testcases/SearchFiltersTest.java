package com.team.findinghospital.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team.findinghospital.base.TestBase;
import com.team.findinghospital.pages.DiagnosticPage;
import com.team.findinghospital.pages.LandingPage;
import com.team.findinghospital.pages.SearchFilters;
import com.team.findinghospital.util.CaptureScreen;
import com.team.findinghospital.util.ExcelData;
import com.team.findinghospital.util.WriteToExcel;

/*
 * This class used to Select Filters (accredited, open24X7, filters, parking)
 */
public class SearchFiltersTest extends TestBase {
	
	
	LandingPage landingPage;
	SearchFilters searchFilters;
	String LandinPageData[] = new String[2];
	
	public SearchFiltersTest() {
		super();

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
		LandinPageData  = ExcelData.readExcel();
		}
		catch(Exception e) {
			e.printStackTrace();	 
			 }
		
	}
	
	/*
	 * Method used to test selected filters
	 */
	@Test(groups={"smoke"})
	public void hospitalList() {
		try {
		logger = report.createTest("All Filters selected");
		landingPage.city(LandinPageData[0], logger);
		searchFilters=landingPage.type(LandinPageData[1],logger);
		//searchFilters.accreditedCheckBox();
		searchFilters.open24X7Checkbox(logger);
		searchFilters.filtersCheckBox(logger); 
		searchFilters.parkingCheckbox(logger);
		String[] hospitalList = searchFilters.getHospitalList(logger);
	
		for(String temp:hospitalList) {
			WriteToExcel.Write(hospitalList);
		}
			searchFilters.diagnostic(logger);
		}
		catch(Exception e) {
			e.printStackTrace();	 
			 }
	}
	
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
