package com.team.findinghospital.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import com.team.findinghospital.base.TestBase;

/*
 *  This class used To pick all the top cities name & store in a List from Diagnostics page
 */
public class DiagnosticPage extends TestBase {
	 
	 /*
	  * XPath location to  get Top Cities
	  */
	@FindBy(xpath="//div[@class ='u-margint--standard o-f-color--primary']")
	List<WebElement> topCities;
	 @FindBy(id="name")
	 public WebElement name;
	 
	 /*
	  * XPath location for organization name 
	  */
	 @FindBy(id="organization_name")
	 public WebElement organizationName;
	 
	 /*
	  * XPath location for official email id
	  */
	 @FindBy(id="official_email_id")
	 public WebElement emailId;

	 /*
	  * XPath location for official phone no 
	  */	 
	 @FindBy(id="official_phone_no")
	 public WebElement phoneNo;
	 
	 /*
	  * XPath location to click button  
	  */
	 @FindBy(id="button-style")
	 public WebElement schedule;
	
	List<WebElement>  l2 = new ArrayList<WebElement>();	
	
	public void DiagnosticsPage() {
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * This method used to get Top Cities From Diagnostics page
	 */
	public String[] getTopCities(ExtentTest logger) throws InterruptedException {
		logger.log(Status.INFO, "Getting top cites names");
		topCities = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class ='u-margint--standard o-f-color--primary']")));
		//topCities = driver.findElements(By.xpath("//div[@class ='u-margint--standard o-f-color--primary']"));
		String[] cities = new String[topCities.size()];
		
		for(int i=0;i<topCities.size();i++) {
			cities[i]=topCities.get(i).getText();	
		
		}
		logger.log(Status.PASS, "Received top cites names");
		driver.navigate().back();
		return cities;
		
	}
	
	String child =null;
	String parent=driver.getWindowHandle();
	
	/*
	 * This method used to navigate CorparateWellness Page
	 */
	public CorporateWellnessPage CorparateWellness(ExtentTest logger) {
		logger.log(Status.INFO, "Switching to child window");

		driver.findElement(By.cssSelector("div.global-nav-bar:nth-child(1) div.practo_GlobalNavigation div.navbar.desktop.en:nth-child(2) div.wrapper.branding div.nav-right.text-right > div.providers-marketing.nav-items.nav-items--additional-link.hover-dark.u-d-trigger.dropdown-toggle:nth-child(1)")).click();
		driver.findElement(By.cssSelector("div.global-nav-bar:nth-child(1) div.practo_GlobalNavigation div.navbar.desktop.en:nth-child(2) div.wrapper.branding div.nav-right.text-right div.providers-marketing.nav-items.nav-items--additional-link.hover-dark.u-d-trigger.dropdown-toggle:nth-child(1) div.u-d.nav-dropdown.text-left.active-state div.u-d-item:nth-child(4) > a.nav-interact")).click();
		Set<String>s=driver.getWindowHandles();
		
		for(String c:s) {
			if(!parent.equalsIgnoreCase(c)) {
				driver.switchTo().window(c);			
			}
		}
		logger.log(Status.PASS, "Switched to child window");
		return new CorporateWellnessPage();	
		}

}
