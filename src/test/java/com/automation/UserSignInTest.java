package com.automation;

import org.testng.annotations.Test;

import com.automation.base.BaseSuite;
import com.automation.dto.UpdateNewUserProfile;
import com.automation.dto.UserSignIn;

public class UserSignInTest extends BaseSuite {

	UserSignIn				userSignIn;
	UpdateNewUserProfile	updateProfile;

	@Test
	public void signIn() {

		userSignIn = new UserSignIn(driver,extentLogger);
		userSignIn.signIn();
	}
}
