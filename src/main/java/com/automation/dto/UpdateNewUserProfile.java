package com.automation.dto;


import com.automation.constants.SiteConstants;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.util.GenericMethods;


public class UpdateNewUserProfile {

	static Logger	log	= Logger.getLogger(UpdateNewUserProfile.class);
	WebDriver		driver;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse']/ul/li[2]/a")
	WebElement		signUpOption;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse']/ul/li[2]/ul/li[1]/a")
	WebElement		selectAccountUpdate;

	@FindBy(xpath = "//div[@class='col-md-1 offset-0']/ul/li/a[@href='#profile']")
	WebElement		clickMyProfile;

	@FindBy(xpath = "//input[@class='form-control' and @name='address1']")
	WebElement		addressOne;

	@FindBy(xpath = "//input[@class='form-control' and @name='address2']")
	WebElement		addressTwo;

	@FindBy(xpath = "//input[@class='form-control' and @name='city']")
	WebElement		city;

	@FindBy(xpath = "//input[@class='form-control' and @name='state']")
	WebElement		state;

	@FindBy(xpath = "//input[@class='form-control' and @name='zip']")
	WebElement		zip;

	@FindBy(xpath = "//select[@class='form-control' and @name ='country']")
	WebElement		countryDropDwn;

	@FindBy(xpath = "//button[@class='btn btn-action btn-block updateprofile']")
	WebElement		submitInfo;

	@FindBy(xpath = "//div[@class='accountresult']/div")
	WebElement		successMsg;

	public UpdateNewUserProfile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void setSelectAccountUpdate() {
		GenericMethods.javaScriptClickByXPath(driver, "//div[@class='navbar-collapse collapse']/ul/li[2]/a");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GenericMethods.selectListOptionsByStringValue(driver,
				"//div[@class='navbar-collapse collapse']/ul/li[2]/ul/li[1]/a", "Account");
		log.info("Selected Account option from drop down list");

	}

	public void setClickMyProfile() {
		//GenericMethods.selectListOptionsByTagValue(driver, "//div[@class='col-md-1 offset-0']/ul/li/a", "#profile",
			//	"href");
		clickMyProfile.click();
		log.info("Clicked My Profile");
	}

	public void setAddressOne() {
		this.addressOne.sendKeys(SiteConstants.UPDATE_USER_ADDRESS1);
		log.info("Sent address one");
	}

	public void setAddressTwo() {
		this.addressTwo.sendKeys(SiteConstants.UPDATE_USER_ADDRESS2);
		log.info("Sent address two");
	}

	public void setCity() {
		this.city.sendKeys(SiteConstants.UPDATE_USER_CITY);
		log.info("Sent city");
	}

	public void setState() {
		this.state.sendKeys(SiteConstants.UPDATE_USER_STATE);
		log.info("Sent state");
	}

	public void setZip() {
		this.zip.sendKeys(SiteConstants.UPDATE_USER_ZIP);
		log.info("Sent zip");
	}

	public void setCountryDropDwn() {
		GenericMethods.selectByValueFromDropDown(driver, countryDropDwn, "US");
		log.info("Picked country");
	}

	public void submitInfo() {
		submitInfo.click();
		log.info("Submitted new user information");
	}

	public boolean confirmSuccessMsg() {
		boolean isSuccess = false;
		if (this.successMsg.getText().equals(SiteConstants.UPDATE_USER_SUCCESS_SAVE_MSG)) {

			isSuccess = true;
		}

		return isSuccess;
	}

}
