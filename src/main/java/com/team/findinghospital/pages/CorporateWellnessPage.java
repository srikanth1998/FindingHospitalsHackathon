package com.team.findinghospital.pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.team.findinghospital.base.TestBase;
import com.team.findinghospital.util.CaptureScreen;


/*
 * This class used To click Corporate Wellness, To schedule & capture the warning message from the alert by giving invalid data
 */
public class CorporateWellnessPage extends TestBase{

	
	CaptureScreen cs;
	public void CorporateWellnessPage() throws InterruptedException {
		PageFactory.initElements(driver, this);
		
	}
	
	/*
	 * This method used to give data name, Organisation name, Email, number 
	 */
	 public void scheduleDemo(String name,String c, String Email, String number,ExtentTest logger ){
		 try {
				logger.log(Status.INFO, "Entering field values");
			   String winHandleBefore= driver.getWindowHandle();
			   driver.findElement(By.id("name")).sendKeys(name);
			   driver.findElement(By.id("organization_name")).sendKeys(name);
			   driver.findElement(By.id("official_email_id")).sendKeys(Email);
			   driver.findElement(By.id("official_phone_no")).sendKeys(number);
			   driver.findElement(By.id("button-style")).click();
			
			
			   try {
				   Alert alert = driver.switchTo().alert();
					
					Thread.sleep(1000);
				   alert.accept();
			   }
			   catch(NoAlertPresentException ex) {
			  
			   }
			  
				logger.log(Status.PASS, "Entered field values");

			  } 
	 
		 catch(Exception e) {
				e.printStackTrace();	 
				 }
	 }

	
		 
}
