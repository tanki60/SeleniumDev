package com.automation.unit;

import org.testng.annotations.Test;

import com.automation.dto.UpdateNewUserProfile;
import com.automation.dto.UserSignIn;
import com.automation.integration.BaseSuiteIT;

public class UserSignInTest extends BaseSuiteIT {

	UserSignIn				userSignIn;
	UpdateNewUserProfile	updateProfile;

	@Test
	public void signIn() {

		userSignIn = new UserSignIn(driver,extentLogger);
		userSignIn.signIn();
	}
}
