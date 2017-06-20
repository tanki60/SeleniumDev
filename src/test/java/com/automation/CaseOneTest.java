package com.automation;

import java.util.Date;

import com.automation.base.BaseSuite;
import com.automation.dto.RegisterNewUser;
import com.automation.dto.UpdateNewUserProfile;
import com.automation.dto.UserSignIn;
import com.automation.dto.UserSignOut;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class CaseOneTest extends BaseSuite {

	UserSignIn				signIn;
	UpdateNewUserProfile	updateProfile;
	UserSignOut				userEndSession;
	RegisterNewUser			newUser;
	SoftAssert				softAssert	= null;
	Date					date;

	@BeforeMethod
	public void logStartTimeForEachTest() {
		// add time for performance
	}

	@Test(priority = 1)
	public void register() {
		newUser = new RegisterNewUser(driver);

		newUser.selectRegisterOption();
		extentLogger.log(LogStatus.INFO, "Selected 'My Account'- 'Sign Up' option");
		newUser.setFirstName();
		extentLogger.log(LogStatus.INFO, "Set first name");
		newUser.setLastName();
		extentLogger.log(LogStatus.INFO, "Set last name");
		newUser.setEmail();
		extentLogger.log(LogStatus.INFO, "Set email");
		newUser.setPassword();
		extentLogger.log(LogStatus.INFO, "Set password");
		newUser.setConfirmPassword();
		extentLogger.log(LogStatus.INFO, "Confirm password");
		newUser.submitInfo();
		extentLogger.log(LogStatus.INFO, "Submit the form");

		Assert.assertTrue(newUser.confirmLogInName(), "Successfully created profile...");
		extentLogger.log(LogStatus.PASS, "Successfully created profile...");
	}

	@Test(priority = 2)
	public void updateProfile() {

		updateProfile = new UpdateNewUserProfile(driver);

		updateProfile.setSelectAccountUpdate();
		extentLogger.log(LogStatus.INFO, "Selected Account option");
		updateProfile.setClickMyProfile();
		extentLogger.log(LogStatus.INFO, "Selected My Profile");
		updateProfile.setAddressOne();
		extentLogger.log(LogStatus.INFO, "Provided Address One");
		updateProfile.setAddressTwo();
		extentLogger.log(LogStatus.INFO, "Provided Address Two");
		updateProfile.setCity();
		extentLogger.log(LogStatus.INFO, "Provided City");
		updateProfile.setState();
		extentLogger.log(LogStatus.INFO, "Provided State");
		updateProfile.setZip();
		extentLogger.log(LogStatus.INFO, "Provided Zip");
		updateProfile.setCountryDropDwn();
		extentLogger.log(LogStatus.INFO, "Selected Country");
		updateProfile.submitInfo();
		extentLogger.log(LogStatus.INFO, "Execute Submit....");
		Assert.assertTrue(updateProfile.confirmSuccessMsg());
		extentLogger.log(LogStatus.PASS, "Successfully updated profile information....");

	}

	@Test(priority = 3)
	public void signOut() {

		userEndSession = new UserSignOut(driver);

		userEndSession.selectMyAccountDrpDwn();
		extentLogger.log(LogStatus.INFO, "Clicked My Account drop down");
		userEndSession.clickLogoutOption();
		extentLogger.log(LogStatus.INFO, "Signing Out...");
		Assert.assertTrue(userEndSession.confirmLoggedOut());
		extentLogger.log(LogStatus.PASS, "Confirmed Signed Out...");

	}

	@AfterMethod
	public void logEndTimeForEachTest() {
		// add time for performance
	}
}
