package com.team.findinghospital.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.team.findinghospital.base.TestBase;

public class CaptureScreen extends TestBase {
	
	/*Calling the getScreenshotAs() method to 
	 *create an image file
	 */
	public static void screenShot(){
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			
			FileUtils.copyFile(scrFile, new File(currentDir + "//Sreenshot//Screenshot" + System.currentTimeMillis() + ".png"));
			
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		}
	
}
