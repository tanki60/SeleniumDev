package com.automation;

import org.testng.annotations.Test;

import com.automation.base.BaseSuite;
import com.automation.dto.UserSignOut;

public class UserSignOutTest extends BaseSuite {

	UserSignOut	userEndSession;

	@Test()
	public void signOut() {

		userEndSession = new UserSignOut(driver, extentLogger);
		userEndSession.signOut();
	}
}
