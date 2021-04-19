package com.team.findinghospital.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.team.findinghospital.base.TestBase;
import com.team.findinghospital.util.WriteToExcel;

public class SearchFilters extends TestBase {
	ExtentTest logger;
	List<String> HosRat = null;
	HashMap<String, Float> map = new HashMap<String, Float>();
	List<WebElement> l1 = new ArrayList();
	List<WebElement> l2 = new ArrayList();

	/*
	 * XPath Location for 'accredited' CheckBox
	 */
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[2]/label[1]")
	WebElement accredited;

	/*
	 * XPath Location for 'diagnostic' CheckBox
	 */
	@FindBy(xpath = "//div[contains(text(),'Diagnostics')]")
	WebElement diagnostic;

	/*
	 * XPath Location for 'open 24/7' CheckBox
	 */
	@FindBy(xpath = "//div[@data-qa-id='Open_24X7_checkbox']")
	WebElement open24_7;

	/*
	 * XPath Location for 'Filter' CheckBox
	 */
	@FindBy(xpath = "//div[@class='u-d-inlineblock u-color--white u-c-pointer']")
	WebElement filter;

	/*
	 * XPath Location for 'Parking' CheckBox
	 */
	@FindBy(xpath = "//div[@data-qa-id='Has_Parking_checkbox']")
	WebElement parking;

	/*
	 * XPath Location for 'Hospital' CheckBox
	 */
	@FindBy(xpath = "//h2[@data-qa-id='hospital_name']")
	List<WebElement> hospital;

	/*
	 * XPath Location for 'topCities' CheckBox
	 */
	@FindBy(xpath = "//div[@class='u-margint--standard o-f-color--primary']")
	List<WebElement> topCities;

	Wait<WebDriver> wait1 = fluentWeight();

	public SearchFilters() {
		try {
			PageFactory.initElements(driver, this);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/*
	 * Method to click open 24X7 CheckBox
	 */
	public void open24X7Checkbox(ExtentTest logger) {
		try {
			logger.log(Status.INFO, "Clicking 24x7 checkbox ");
			wait1.until(ExpectedConditions.elementToBeClickable(open24_7)).click();
			Thread.sleep(1000);
			logger.log(Status.PASS, "Clicked 24x7 checkbox");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Method to click filters CheckBox
	 */
	public void filtersCheckBox(ExtentTest logger) {
		try {
			logger.log(Status.INFO, "Clicking Filters dropdown box ");

			filter.click();
			Thread.sleep(1000);
			logger.log(Status.PASS, "Clicked Filters dropdown box");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method to click parking CheckBox
	 */
	public void parkingCheckbox(ExtentTest logger) {
		try {
			logger.log(Status.INFO, "Clicking parkingCheckbox checkbox");

			parking.click();
			Thread.sleep(1000);
			logger.log(Status.PASS, "Clicked parkingCheckbox checkbox");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method to click get Hospital List
	 */
	public String[] getHospitalList(ExtentTest logger) {
		try {
			logger.log(Status.INFO, "Getting hospital list");

			java.util.List<WebElement> rating = null;
			java.util.List<WebElement> links = null;
			java.util.List<WebElement> next = driver.findElements(By.xpath("//ul[@class='c-paginator']/li"));
			Thread.sleep(1000);
			Iterator<WebElement> nxt = next.iterator();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			int z = 0;
			while (z < next.size()) {
				Thread.sleep(1000);
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				rating = wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='u-pos-rel u-d-inlineblock ']")));
				Thread.sleep(100);
				links = wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//*[@data-qa-id='hospital_name']")));
				z++;
			}
			Iterator<WebElement> itr = rating.iterator();
			Iterator<WebElement> itr1 = links.iterator();
			int k = 0;
			String[] hospitalList = new String[links.size()];

			for (WebElement e : links) {

				while (itr.hasNext() && itr1.hasNext()) {

					String hos = ((WebElement) itr1.next()).getText();
					String rat = ((WebElement) itr.next()).getAttribute("title");

					float f = Float.parseFloat(rat);
					if (f > 3.5) {
						// HosRat.add(hos);
						hospitalList[k] = hos;
						System.out.println(hos + "  " + f);
						k++;
					}

				}
			}
			logger.log(Status.PASS, "Stores hospital list in Excel sheet");

			return hospitalList;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * Method to click DiagnosticPage
	 */
	public DiagnosticPage diagnostic(ExtentTest logger) {
		try {
			logger.log(Status.INFO, "Clicking on Diagnostic button");

			Thread.sleep(1000);
			diagnostic.click();
			logger.log(Status.PASS, "Clickewd on Diagnostic button");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DiagnosticPage();

	}

}
