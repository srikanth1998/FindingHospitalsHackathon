package com.team.findinghospital.util;

import org.testng.IReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.relevantcodes.extentreports.LogStatus;


public class ExtetntReport  {
		
	
	public static ExtentReports report;
	
	public static  ExtentReports getReportInstance(){
		try {
		if(report == null ) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output//report.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Environment", "UAT");
		report.setSystemInfo("Build Number", "10.8.1");
		report.setSystemInfo("Browser", "Microsoft Edge");
		htmlReporter.config().setDocumentTitle("UAT UI Automation Results");
		htmlReporter.config().setReportName("All Headlines UI Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		}
		}
		catch(Exception e) {
			e.printStackTrace();	 
			 }
		return report;
			
		
	}
		
	}
	
	

