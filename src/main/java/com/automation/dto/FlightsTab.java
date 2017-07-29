package com.automation.dto;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FlightsTab {

	static Logger		log	= Logger.getLogger(FlightsTab.class);

	private WebDriver	driver;
	private ExtentTest	extentLogger;

	@FindBy(xpath = "//a[@href='#TRAVELPAYOUTS']")
	private WebElement	flightsTab;

	@FindBy(xpath = "//input[@placeholder='Origin']")
	private WebElement	flyingFrom;

	@FindBy(xpath = "//div[@class='mewtwo-autocomplete']/ul/li")
	private WebElement	flyingFromTypeAheadSelect;

	@FindBy(xpath = "//input[@placeholder='Destination']")
	private WebElement	flyingTo;

	@FindBy(xpath = "//div[@class='mewtwo-autocomplete']/ul/li")
	private WebElement	flyingToTypeAheadSelect;

	@FindBy(xpath = "//input[@placeholder='Depart date']")
	private WebElement	departDateClick;

	@FindBy(xpath = "//span[@role='datepicker-next']")
	private WebElement	departDateIcon;

	@FindBy(xpath = "//div[@class='mewtwo-datepicker-container']/div/div[1]/table/tr[3]")
	private WebElement	departDateSelect;

	@FindBy(xpath = "//input[@placeholder='Return date']")
	private WebElement	returnDateClick;

	@FindBy(xpath = "//span[@role='datepicker-next']")
	private WebElement	returnDateIcon;

	@FindBy(xpath = "//div[@class='mewtwo-datepicker-container']/div/div[2]/table/tr[3]")
	private WebElement	returnDateSelect;

	@FindBy(xpath = "//div[@role='passengers']/div")
	private WebElement	pickNumOfAdults;

	@FindBy(xpath = "//div[@role='passengers_modal']//div[@role='ready_button']/span[1]")
	private WebElement	numOfAdultOkBtn;

	@FindBy(xpath = "//button[@role='flights_submit']")
	private WebElement	performFlightSearch;

	public FlightsTab(WebDriver driver,ExtentTest extentLogger) {
		this.driver = driver;
		this.extentLogger=extentLogger;
		PageFactory.initElements(driver, this);

	}

	public void gotoHome() {
		// GenericMethods.selectByLinkText(driver, "Home");
		log.info("Clicked Home");

	}

	public void selectFlightsTab() {
		flightsTab.click();
		log.info("Inside method selectFlightsTab() ");

	}

	public void selectFlyingFrom() {
		flyingFrom.click();
		flyingFrom.clear();
		flyingFrom.sendKeys("phl");
		flyingFromTypeAheadSelect.click();

		log.info("Inside method selectFlyingFrom() ");

	}

	public void selectFlyingTo() {
		flyingTo.click();
		flyingTo.clear();
		flyingTo.sendKeys("dca");
		flyingTo.click();
		flyingToTypeAheadSelect.click();

		log.info("Inside method selectFlyingTo()");

	}

	public void selectDepatureDate() {
		departDateClick.click();
		log.info("clicked departDateClick.click() ");
		departDateIcon.click();

		log.info("clicked departDateMonthIcon.click() ");
		departDateSelect.click();
		log.info("clicked departDateSelect.click() ");

		log.info("Finished method selectDepatureDate() ");
	}

	public void selectReturnDate() {
		returnDateClick.click();
		returnDateIcon.click();
		returnDateIcon.click();
		returnDateSelect.click();

		log.info("Finished method selectReturnDate() ");
	}

	public void selectNumOfAdultDrpDwn() {

		pickNumOfAdults.click();

		log.info("Selected method selectNumOfChildDrpDwn()");

	}

	public void setNumOfAdultOkBtn() {

		this.numOfAdultOkBtn.click();

	}

	public void searchFlights() {

		performFlightSearch.click();

		extentLogger.log(LogStatus.INFO, "Clicked flight search button");
		extentLogger.log(LogStatus.PASS, "Verified Flights Tab....");
		log.info("Selected method searchFlights()");

	}

	public void selectFlight() {
		gotoHome();
		extentLogger.log(LogStatus.INFO, "Selected Home Page");
		selectFlightsTab();
		extentLogger.log(LogStatus.INFO, "Selected Flights Tab");
		selectFlyingFrom();
		extentLogger.log(LogStatus.INFO, "Selected departure ");
		selectFlyingTo();
		extentLogger.log(LogStatus.INFO, "Selected arrival ");
		selectDepatureDate();
		extentLogger.log(LogStatus.INFO, "Selected departure date ");
		selectReturnDate();
		extentLogger.log(LogStatus.INFO, "Selected return date ");
		selectNumOfAdultDrpDwn();
		setNumOfAdultOkBtn();
		extentLogger.log(LogStatus.INFO, "Selected number of passengers ");
		extentLogger.log(LogStatus.INFO, "Selected required options before search");
		
	}
}
