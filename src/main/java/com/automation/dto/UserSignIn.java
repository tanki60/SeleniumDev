package com.automation.dto;

import com.automation.constants.SiteConstants;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.util.GenericMethods;

public class UserSignIn {

	static Logger		log	= Logger.getLogger(UserSignIn.class);

	private WebDriver	driver;

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

	public UserSignIn(WebDriver driver) {

		this.driver = driver;
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

}
