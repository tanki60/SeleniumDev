package com.automation.dto;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.constants.SiteConstants;
import com.automation.util.GenericMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BookAsGuest {

	static Logger		log	= Logger.getLogger(BookAsGuest.class);

	private WebDriver	driver;
	private ExtentTest extentLogger;

	@FindBy(xpath = "//a[@id='guesttab']")
	private WebElement	asGuestBtn;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement	firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement	lastName;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement	email;

	@FindBy(xpath = "//input[@name='confirmemail']")
	private WebElement	confirmEmail;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement	mobile;

	@FindBy(xpath = "//input[@name='address']")
	private WebElement	address;

	// javascript
	@FindBy(xpath = "//a[@class='select2-choice']/span[1]")
	private WebElement	countryDrpDwn;

	@FindBy(xpath = "//div[@id='select2-drop']/div/input")
	private WebElement	pickCountry;

	@FindBy(css = ".btn.btn-action.btn-lg.btn-block.completebook")
	private WebElement	completeBookingBtn;

	@FindBy(xpath = "//button[@class='btn btn-default arrivalpay']")
	private WebElement	payOnArrival;

	@FindBy(xpath = "//form[@id='bookingdetails']/div[2]/table/tbody/tr[4]/td[4]/label/a")
	private WebElement	extraOptions;

	@FindBy(xpath = "//b[contains(@class,'wow flash animted animated')]")
	private WebElement	confirmSuccessMsg;

	public BookAsGuest(WebDriver driver, ExtentTest extentLogger) {
		this.driver = driver;
		this.extentLogger=extentLogger;
		PageFactory.initElements(driver, this);

	}

	public void clickAsGuestBtn() {

		asGuestBtn.click();

		log.info("Clicked as Guest");

	}

	public void setFirstName() {
		firstName.clear();
		firstName.sendKeys(SiteConstants.REGISTER_USER_FIRSTNAME);
		log.info("Completed setFirstName ");

	}

	public void setLastName() {
		lastName.clear();
		lastName.sendKeys(SiteConstants.REGISTER_USER_LASTNAME);
		log.info("Completed setLastName ");

	}

	public void setEmailAndConfirm() {
		email.clear();
		email.sendKeys(SiteConstants.REGISTER_USER_EMAIL);
		confirmEmail.clear();
		confirmEmail.sendKeys(SiteConstants.REGISTER_USER_EMAIL);
		log.info("Completed setEmailAndConfirm ");

	}

	public void setMobile() {
		mobile.clear();
		mobile.sendKeys(SiteConstants.REGISTER_USER_PHONE);
		log.info("Completed setMobile ");

	}

	public void setAddress() {

		address.clear();
		address.sendKeys(SiteConstants.REGISTER_USER_ADDRESS);
		log.info("Completed setAddress ");

	}

	public void clikAndSelectCountry() {
		countryDrpDwn = countryDrpDwn.findElement(By.xpath("//a[@class='select2-choice']/span[1]"));
		countryDrpDwn.click();
		pickCountry.sendKeys("aus");
		pickCountry.sendKeys(Keys.ENTER);

		log.info("Completed clikAndSelectCountry ");

	}

	public void addExtras() {

		GenericMethods.javaScriptClickByElementLocation(driver, extraOptions, "y");
		log.info("Completed addAirportPickUp ");
	}

	public void clickCompleteBookingBtn() {

		completeBookingBtn.click();
		log.info("Completed clickCompleteBookingBtn ");
	}

	public void selectPayOnArrival() {

		payOnArrival.click();

		GenericMethods.javaScriptPopUpClick(driver);
		log.info("Completed selectPayOnArrival ");
	}

	public void selectPopUp() {

		GenericMethods.javaScriptPopUpClick(driver);
		log.info("Completed selectPopUp ");
	}

	public boolean confirmSuccessMsg() {
		return confirmSuccessMsg.isDisplayed();
	}
	
	public void pickBookAsGuest(){
		
		clickAsGuestBtn();
		extentLogger.log(LogStatus.INFO, "Selected Guest option");
		setFirstName();
		extentLogger.log(LogStatus.INFO, "Typed first name");
		setLastName();
		extentLogger.log(LogStatus.INFO, "Typed last name");
		setEmailAndConfirm();
		extentLogger.log(LogStatus.INFO, "Typed and confirmed email");
		setAddress();
		extentLogger.log(LogStatus.INFO, "Typed address");
		setMobile();
		extentLogger.log(LogStatus.INFO, "Typed phone number");
		clikAndSelectCountry();
		extentLogger.log(LogStatus.INFO, "Selected Country");
		addExtras();
		extentLogger.log(LogStatus.INFO, "Added extra options");
		clickCompleteBookingBtn();
		extentLogger.log(LogStatus.INFO, "Clicked complete booking");
		selectPayOnArrival();
		extentLogger.log(LogStatus.INFO, "Selected Pay of Arrival option");
		selectPopUp();
		extentLogger.log(LogStatus.INFO, "Closed pop up");
		Assert.assertTrue(confirmSuccessMsg(), "Sucessfully Booked!...");
		extentLogger.log(LogStatus.PASS, "Booking Completed...");
	}
}
