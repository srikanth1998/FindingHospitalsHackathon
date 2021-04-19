package com.team.findinghospital.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.team.findinghospital.base.DriverSetup;
import com.team.findinghospital.base.TestBase;

public class LandingPage extends TestBase {

	/*
	 * XPath Location for 'Search location' Box to enter City name
	 */
	@FindBy(xpath = "//input[@placeholder='Search location']")
	WebElement city;

	/*
	 * XPath Location for 'Search doctors, clinics, hospitals, etc.' to choose
	 * hospital
	 */
	@FindBy(xpath = "//input[@placeholder='Search doctors, clinics, hospitals, etc.']")
	WebElement type;

	/*
	 * XPath Location for 'Accredited' to select rating above
	 */
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[2]/label[1]")
	WebElement accredited;

	public LandingPage() {
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method for Enter the city name as 'Bangalore' in Search location Box
	 */
	public void city(String cit, ExtentTest logger) {
		try {

			logger.log(Status.INFO, "Entering city name");
			List<WebElement> l = new ArrayList<WebElement>();

			while (!city.getAttribute("value").equals(""))
			city.sendKeys(Keys.BACK_SPACE);
			city.sendKeys(cit);

			Thread.sleep(2000);
			l = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
					"//span[@class='c-omni-suggestion-item__content']/div[@class='c-omni-suggestion-item__content__title']")));
			for (WebElement e1 : l) {
				String s1 = e1.getText();
				System.out.println(s1);
				if (e1.getText().equalsIgnoreCase(cit)) {
					System.out.println(s1);
					e1.click();
					break;
				}
			}
			logger.log(Status.PASS, "City name Entered");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method for choosing Hospital in "Search doctors, clinics, hospitals, etc" Box
	 */
	public SearchFilters type(String hospital, ExtentTest logger) {
		try {
			logger.log(Status.INFO, "Entering search context");

			List<WebElement> l1 = new ArrayList<WebElement>();
			type.clear();
			Thread.sleep(2000);
			type.sendKeys(hospital);
			Thread.sleep(2000);
			l1 = driver.findElements(By.xpath("//div[@class='c-omni-suggestion-item__content__title']"));
			Thread.sleep(2000);
			for (WebElement e : l1) {
				String s = e.getText();
				if (s.equalsIgnoreCase(hospital)) {
					e.click();
					System.out.println(s);
					break;
				}
			}
			logger.log(Status.PASS, "Search context entered");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SearchFilters();

	}

}
