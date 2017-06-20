package com.automation;

import com.automation.base.BaseSuite;
import com.automation.dto.UpdateNewUserProfile;
import com.automation.dto.UserSignIn;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class UserSignInTest extends BaseSuite {

	UserSignIn				signIn;
	UpdateNewUserProfile	updateProfile;

	@Test
	public void signIn() {

		signIn = new UserSignIn(driver);

		signIn.clickMyAccountDrpDwn();
		extentLogger.log(LogStatus.INFO, "Clicked My Account drop down");
		signIn.clickSignInOption();
		extentLogger.log(LogStatus.INFO, "Picked Sign-In option");
		signIn.setUserEmail();
		extentLogger.log(LogStatus.INFO, "Entered user email");
		signIn.setPassowrd();
		extentLogger.log(LogStatus.INFO, "Entered user password");
		signIn.clickSigInBtn();
		extentLogger.log(LogStatus.INFO, "Clicked Sign-In botton");

		Assert.assertTrue(signIn.confirmLogInName());
		extentLogger.log(LogStatus.PASS, "Successfully signed-in...");
	}
}
