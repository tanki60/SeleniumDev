package com.automation.dto;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.constants.SiteConstants;
import com.automation.util.GenericMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FeaturedHotels {

	static Logger		log	= Logger.getLogger(FeaturedHotels.class);

	private WebDriver	driver;
	private ExtentTest	extentLogger;

	@FindBy(xpath = "//div[@class='bgwhite']/div/div[2]/div[4]")
	private WebElement	hotelImg;

	@FindBy(xpath = "//select[@id='adults']")
	private WebElement	adultDrpdwn;

	@FindBy(css = ".btn.btn-block.btn-success-small.textupper")
	private WebElement	modify;

	@FindBy(xpath = "//div[@id='accordion']/div[1]/button[1]")
	private WebElement	details;

	@FindBy(xpath = "//div[@id='accordion']/div[1]/button[2]")
	private WebElement	availability;

	@FindBy(xpath = "//*[@id='44']")
	private WebElement	availabilityDrpDwnDates;

	@FindBy(xpath = "//section[@id='ROOMS']/form[1]/div/div[2]/div[1]/button")
	private WebElement	bookNowBtn;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement	guestName;

	@FindBy(xpath = "//input[@placeholder='Passport']")
	private WebElement	guestPassport;

	@FindBy(xpath = "//input[@placeholder='Age']")
	private WebElement	guestAge;


	public FeaturedHotels(WebDriver driver, ExtentTest extentLogger) {

		this.driver = driver;
		this.extentLogger=extentLogger;
		PageFactory.initElements(driver, this);
		log.info("Completed custructor FeaturedHotels ");
	}

	public void selectFeaturedHotel() {
		hotelImg.click();
		log.info("Completed selectFeaturedHotel ");

	}

	public void selectAdultDrpDwn() {

		GenericMethods.javaScriptClickByElementLocation(driver, adultDrpdwn, "y");

		GenericMethods.selectByValueFromDropDown(driver, adultDrpdwn, "1");
		log.info("Completed selectAdultDrpDwn ");
	}

	public void modifyResults() {

		// modify.click();
		GenericMethods.javaScriptClickByElementLocation(driver, modify, "y");
		log.info("Completed modifyResults ");

	}

	public void viewDetails() {

		details.click();
		log.info("Completed viewDetails ");
	}

	public void viewAvailability() {

		GenericMethods.selectListOptionsByIndex(driver, "//div[@id='accordion']/div[1]/button[2]", 1);
		log.info("Completed viewAvailability ");
	}

	public void clickBookNow() {

		bookNowBtn.click();
		log.info("Completed clickBookNow ");
	}

	public void setGuestName() {

		guestName.sendKeys(SiteConstants.FEDTURED_USER_FIRSTNAME);
		log.info("Completed setGuestName ");
	}

	public void setGuestPassport() {

		guestPassport.sendKeys(SiteConstants.FEDTURED_USER_PASSPORT);
		log.info("Completed setGuestPassport ");
	}

	public void setGuestAge() {

		guestAge.sendKeys(SiteConstants.FEDTURED_USER_AGE);
		log.info("Completed setGuestAge ");

	}
	
	public void pickFeturedHotelOptions(){
		
		selectFeaturedHotel();
		extentLogger.log(LogStatus.INFO, "Clicked on featured hotel deal");
		selectAdultDrpDwn();
		extentLogger.log(LogStatus.INFO, "Clicked on number of adults drop down");
		modifyResults();
		extentLogger.log(LogStatus.INFO, "Updated the result by clicking Modify button");
		viewDetails();
		extentLogger.log(LogStatus.INFO, "Viewed hotel details");
		viewAvailability();
		extentLogger.log(LogStatus.INFO, "Confirmed hotel availability");
		clickBookNow();
		extentLogger.log(LogStatus.PASS, "Clicked on book now button");
	}

	

}
