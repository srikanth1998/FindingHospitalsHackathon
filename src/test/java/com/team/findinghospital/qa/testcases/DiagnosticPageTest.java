package com.team.findinghospital.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.team.findinghospital.base.TestBase;
import com.team.findinghospital.pages.DiagnosticPage;
import com.team.findinghospital.pages.LandingPage;
import com.team.findinghospital.pages.SearchFilters;
import com.team.findinghospital.util.CaptureScreen;


/*
 *  This class used To Test all the top cities name & stored in a List from Diagnostics page 
 */
public class DiagnosticPageTest extends TestBase {
	
	DiagnosticPage diagnosticsPage;
	LandingPage landingPage;
	SearchFilters searchFilters;
	public DiagnosticPageTest() {
		super();
	}
	
	/*
	 * Method used to Setting Up pages
	 */
	@BeforeMethod
	public void setup() {
		initialization();
		landingPage = new LandingPage();
		diagnosticsPage = new DiagnosticPage();	
		searchFilters = new SearchFilters();
	}
	
	/*
	 * Method used to test Top cities 
	 */
	@Test(groups={"smoke"})
	public void topCityTest(){
		try {
		
		logger = report.createTest("topCityTest" );
		searchFilters.diagnostic(logger);
		
		String[] topCities = diagnosticsPage.getTopCities(logger);
		for(String temp:topCities)
			System.out.println(temp);
		
		
		diagnosticsPage.CorparateWellness(logger);
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
