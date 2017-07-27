package com.automation.dto;

import com.automation.constants.SiteConstants;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.util.GenericMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UserSignIn {

	static Logger		log	= Logger.getLogger(UserSignIn.class);

	private WebDriver	driver;
	private ExtentTest	extentLogger;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse']/ul/li[2]/a")
	WebElement			myAccountDrpDwn;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse']/ul/li[2]/ul/li[1]")
	WebElement			signInOption;

	@FindBy(xpath = "//input[@name='username']")
	WebElement			userEmail;

	@FindBy(xpath = "//input[@name='password']")
	WebElement			passowrd;

	@FindBy(css = "button.btn.btn-action.btn-block.loginbtn")
	WebElement			sigInBtn;

	public UserSignIn(WebDriver driver, ExtentTest extentLogger) {

		this.driver = driver;
		this.extentLogger=extentLogger;
		PageFactory.initElements(driver, this);

		log.info("Init page factory");

	}

	public void clickMyAccountDrpDwn() {

		myAccountDrpDwn.click();
		log.info("Clicked on My Account drop down");
	}

	public void clickSignInOption() {

		signInOption.click();
		log.info("Clicked on My Account drop down");
	}

	public void setUserEmail() {
		this.userEmail.sendKeys(SiteConstants.REGISTER_USER_EMAIL);
		log.info("Set user email");
	}

	public void setPassowrd() {
		this.passowrd.sendKeys(SiteConstants.REGISTER_USER_PASSWORD);
		log.info("Enter user password");
	}

	public void clickSigInBtn() {
		this.sigInBtn.click();
		log.info("Click Sign In button");
	}

	public boolean confirmLogInName() {

		boolean isCorrectName = false;
		String text = GenericMethods.getElementText(driver,
				"//div[@class='container']/div[@style='margin-bottom:25px;margin-right: 0px']/div/div/h3");
		String username = "Hi, " + SiteConstants.REGISTER_USER_FIRSTNAME + " " + SiteConstants.REGISTER_USER_LASTNAME;
		if (text.equals(username)) {
			isCorrectName = true;

		}
		System.out.println("**" + username + "**");
		return isCorrectName;
	}
	
	public void signIn(){
		
		clickMyAccountDrpDwn();
		extentLogger.log(LogStatus.INFO, "Clicked My Account drop down");
		clickSignInOption();
		extentLogger.log(LogStatus.INFO, "Picked Sign-In option");
		setUserEmail();
		extentLogger.log(LogStatus.INFO, "Entered user email");
		setPassowrd();
		extentLogger.log(LogStatus.INFO, "Entered user password");
		clickSigInBtn();
		extentLogger.log(LogStatus.INFO, "Clicked Sign-In botton");

		Assert.assertTrue(confirmLogInName());
		extentLogger.log(LogStatus.PASS, "Successfully signed-in...");
	}

}
