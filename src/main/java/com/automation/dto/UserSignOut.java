package com.automation.dto;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.constants.SiteConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UserSignOut {

	static Logger		log	= Logger.getLogger(UserSignOut.class);

	private WebDriver	driver;
	private ExtentTest	extentLogger;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse']/ul/li[2]/ul/li[2]")
	WebElement			logoutOption;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse']/ul/li[2]/a")
	WebElement			myAccountDrpDwn;

	public UserSignOut(WebDriver driver, ExtentTest extentLogger) {
		this.driver = driver;
		this.extentLogger = extentLogger;
		PageFactory.initElements(driver, this);
		log.info("Init page factory");
	}

	public void selectMyAccountDrpDwn() {
		myAccountDrpDwn.click();
		log.info("Logged in user : " + myAccountDrpDwn.getText());
		log.info("Slected My Account drop down");
	}

	public void clickLogoutOption() {
		logoutOption.click();
		log.info("Signed out...");
	}

	public boolean confirmLoggedOut() {
		boolean isLoggedOut = false;
		if (myAccountDrpDwn != null && myAccountDrpDwn.getText().equals(SiteConstants.USER_LOGOUT_TEXT)) {
			log.info("Signed out...");
			log.info("Logged in user : " + myAccountDrpDwn.getText());
			isLoggedOut = true;
		} else {
			log.info("Log-out falied...");
			log.info("Logged in user : " + myAccountDrpDwn.getText());
		}

		return isLoggedOut;
	}

	public void signOut() {

		selectMyAccountDrpDwn();
		extentLogger.log(LogStatus.INFO, "Clicked My Account drop down");
		clickLogoutOption();
		extentLogger.log(LogStatus.INFO, "Signing Out...");
		Assert.assertTrue(confirmLoggedOut());
		extentLogger.log(LogStatus.PASS, "Confirmed Signed Out...");
	}

}
