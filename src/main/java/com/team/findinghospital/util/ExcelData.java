package com.team.findinghospital.util;

import java.awt.print.Printable;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelData {
	static WebDriver driver;
	public static String path = System.getProperty("user.dir") + "\\TestData\\TestInput.xlsx";
	public static String[] readExcel() {
		int k=2;
		String[] LandingPageData = new String[100];
		try {
			/*
			 * Getting the Relative path for excel from Source Excel folder
			 */
			
			String filePath = System.getProperty("user.dir") + "\\TestData\\TestInput.xlsx";
			FileInputStream file = new FileInputStream(filePath);
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet ws = wb.getSheetAt(0);
			LandingPageData[0] = String.valueOf(ws.getRow(0).getCell(0));
			LandingPageData[1] = String.valueOf(ws.getRow(0).getCell(1));
			for(int i = 1;i<5;i++) {
				for(int j=3;j<7;j++) {
		
			LandingPageData[k] = String.valueOf(ws.getRow(i).getCell(j));
			k++;
				}
			}
			LandingPageData[k++] = String.valueOf(ws.getRow(0).getCell(2));
			LandingPageData[k++] = String.valueOf(ws.getRow(0).getCell(3));
			
			
			
			return LandingPageData ;
		} catch (Exception e) {
			e.printStackTrace();
			return LandingPageData;
		}
		


	}
}

