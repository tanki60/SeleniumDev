package com.automation.dto;


import com.automation.constants.SiteConstants;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.util.GenericMethods;


public class RegisterNewUser {

	static Logger	log	= Logger.getLogger(RegisterNewUser.class);

	WebDriver		driver;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse']/ul/li[2]/a")
	WebElement		signUpOption;

	@FindBy(xpath = "//div[@class='navbar-collapse collapse']/ul/li[2]/ul/li[2]")
	WebElement		clickSignUpOption;

	@FindBy(xpath = "//form[@id='headersignupform']//div/input[@name='firstname']")
	WebElement		firstName;

	@FindBy(xpath = "//form[@id='headersignupform']//div/input[@name='lastname']")
	WebElement		lastName;

	@FindBy(xpath = "//form[@id='headersignupform']//div/input[@name='email']")
	WebElement		email;

	@FindBy(xpath = "//form[@id='headersignupform']//div/input[@name='password']")
	WebElement		password;

	@FindBy(xpath = "//form[@id='headersignupform']//div/input[@name='confirmpassword']")
	WebElement		confirmPassword;

	@FindBy(xpath = "//form[@id='headersignupform']//div/button")
	WebElement		submitButton;

	public RegisterNewUser(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		log.info("Init page factory");

	}

	public void selectRegisterOption() {
		String path1 = "//div[@class='navbar-collapse collapse']/ul/li[2]/a";
		String path2 = "//div[@class='navbar-collapse collapse']/ul/li[2]/ul/li";

		GenericMethods.javaScriptClickByXPath(driver, path1);
		GenericMethods.selectListOptionsByIndex(driver, path2, 1);

		log.info("Clicked on Sign Up option for new user");

	}

	public void setFirstName() {
		firstName.sendKeys(SiteConstants.REGISTER_USER_FIRSTNAME);
		log.info("Clicked setFirstName()");
	}

	public void setLastName() {
		lastName.sendKeys(SiteConstants.REGISTER_USER_LASTNAME);
		log.info("Clicked setLastName()");
	}

	public void setEmail() {
		email.sendKeys(GenericMethods.generateFakeEmail());
		log.info("Clicked setEmail()");
	}

	public void submitInfo() {
		submitButton.click();
		log.info("Clicked setSubmitButton()");
	}

	public void setPassword() {
		password.sendKeys(SiteConstants.REGISTER_USER_PASSWORD);
		log.info("Clicked setPassword()");
	}

	public void setConfirmPassword() {
		confirmPassword.sendKeys(SiteConstants.REGISTER_USER_PASSWORD);
		log.info("Clicked setConfirmPassword()");
	}

	public boolean confirmLogInName() {

		boolean isCorrectName = false;
		String text = GenericMethods.getElementText(driver,
				"//div[@class='container']/div[@style='margin-bottom:25px;margin-right: 0px']/div/div/h3");
		String username = "Hi, " + SiteConstants.REGISTER_USER_FIRSTNAME + " " + SiteConstants.REGISTER_USER_LASTNAME;
		if (text.equals(username)) {
			isCorrectName = true;

		}

		return isCorrectName;
	}

}
