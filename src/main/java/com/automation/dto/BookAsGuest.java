package com.automation.dto;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.constants.SiteConstants;
import com.automation.util.GenericMethods;

public class BookAsGuest {

	static Logger		log	= Logger.getLogger(BookAsGuest.class);

	private WebDriver	driver;

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
	//@FindBy(xpath = "//a[@class='select2-choice']/span[1]")
	//private WebElement	countryDrpDwn;

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

	public BookAsGuest(WebDriver driver) {
		this.driver = driver;
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

		GenericMethods.javaScriptClickByPath(driver, "//div[@class='select2-container chosen-select']", true);
		pickCountry.sendKeys("aus");
		pickCountry.sendKeys(Keys.ENTER);

		log.info("Completed clikAndSelectCountry ");

	}

	public void addExtras() {

		GenericMethods.javaScriptClickByElementLocation(driver, extraOptions, "y");
		// extraOptions.click();
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
}
