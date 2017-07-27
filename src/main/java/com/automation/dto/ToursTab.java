package com.automation.dto;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.util.GenericMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ToursTab {

	static Logger		log	= Logger.getLogger(ToursTab.class);

	private WebDriver	driver;
	private ExtentTest extentLogger;

	@FindBy(xpath = "//div[@class='container']/ul/li[@data-title='TOURS']")
	private WebElement	toursTab;

	@FindBy(css = "#TOURS > div > form > div.go-text-right > div.form-group.go-right.xl > div.row > div:nth-of-type(2) > a > span:nth-of-type(1)")
	private WebElement	toursTxtBox;

	@FindBy(css = "body > div:nth-of-type(20) > div > input")
	private WebElement	toursTxtTypeAhead;

	@FindBy(xpath = "//input[@class='form input-lg tchkin']")
	private WebElement	checkInDateClick;

	@FindBy(xpath = "//div[@class='datepicker dropdown-menu' and contains(@style, 'display: block; top')]//div[@class='datepicker-days']/table/thead/tr[1]/th[3]")
	private WebElement	checkInDateIcon;

	@FindBy(xpath = "//div[@class='datepicker dropdown-menu'][3]//div[@class='datepicker-days'][1]/table/tbody/tr[4]/td[1]")
	private WebElement	checkInDateSelect;

	@FindBy(xpath = "//div[@id='TOURS']//select[@id='adults']")
	private WebElement	numOfAdultDrpDwn;

	@FindBy(xpath = "//select[@id='tourtype']")
	private WebElement	tourType;

	@FindBy(xpath = "//div[@id='TOURS']/div/form/div[5]/div/button")
	private WebElement	performSearch;

	public ToursTab(WebDriver driver,ExtentTest extentLogger) {
		this.driver = driver;
		this.extentLogger=extentLogger;
		PageFactory.initElements(driver, this);

	}

	public void gotoHome() {
		GenericMethods.selectByLinkText(driver, "Home");
		log.info("Clicked Home");

	}

	public void selectToursTab() {
		GenericMethods.checkVisibilityofElementAndClick(driver, toursTab);
		// toursTab.click();
		log.info("Finished method selectFlightsTab() ");

	}

	public void selectDestinationLocation(String hotelName) {
		this.toursTxtBox.click();
		this.toursTxtTypeAhead.sendKeys(hotelName);
		this.toursTxtTypeAhead.sendKeys(Keys.RETURN);
		log.info("Finished selectDestinationLocation: " + hotelName);
	}

	public void selectCheckInDateTxtBox() {
		checkInDateClick.click();
		log.info("Finished checkInDateClick.click()");
	}

	public void clickNextMonthIcon() {
		GenericMethods.javaScriptClickByElement(driver, checkInDateIcon);
		log.info("Finished checkInDateIcon.click()");
	}

	public void selectCheckInDate() {

		checkInDateSelect.click();
		log.info("Finished checkInDateSelect.click()");
	}

	public void selectNumOfAdultDrpDwn() {

		numOfAdultDrpDwn.click();

		Select adultDrpDwn = new Select(numOfAdultDrpDwn);
		adultDrpDwn.selectByVisibleText("3");
		log.info("Selected selectNumOfAdultDrpDwn()");
	}

	public void selectTourTypeDrpDwn() {

		tourType.click();

		Select tourTypeDrpDwn = new Select(tourType);
		tourTypeDrpDwn.selectByIndex(1);
		log.info("Selected selectTourTypeDrpDwn");

	}

	public void performPackageSearch() {
		performSearch.click();
		extentLogger.log(LogStatus.INFO, "Clicked on search button");
		extentLogger.log(LogStatus.PASS, "Verified Tours Tab...");
		log.info("Finished performPackageSearch()");
	}
	
	public void selectTour(){
		
		gotoHome();
		extentLogger.log(LogStatus.INFO, "Selected Home Page");
		selectToursTab();
		extentLogger.log(LogStatus.INFO, "Selected Tours Tab");
		selectDestinationLocation("Cairo");
		extentLogger.log(LogStatus.INFO, "Selected location");
		selectCheckInDateTxtBox();
		clickNextMonthIcon();
		selectCheckInDate();
		extentLogger.log(LogStatus.INFO, "Selected check-in date");
		selectNumOfAdultDrpDwn();
		extentLogger.log(LogStatus.INFO, "Selected number of adults");
		selectTourTypeDrpDwn();
		extentLogger.log(LogStatus.INFO, "Selected type of tour");
		extentLogger.log(LogStatus.INFO, "Selected all fields before search");
	}

}
