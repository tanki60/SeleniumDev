package com.automation;

import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseSuite;
import com.automation.dto.RegisterNewUser;
import com.automation.dto.UpdateNewUserProfile;
import com.automation.dto.UserSignIn;
import com.automation.dto.UserSignOut;

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
		newUser = new RegisterNewUser(driver, extentLogger);
		newUser.registerUser();

	}

	@Test(priority = 2)
	public void updateProfile() {

		newUser.registerUser();
	}

	@Test(priority = 3)
	public void signOut() {

		userEndSession = new UserSignOut(driver, extentLogger);

	}

	@AfterMethod
	public void logEndTimeForEachTest() {
		// add time for performance
	}
}
