package com.automation.unit;

import org.testng.annotations.Test;

import com.automation.dto.UserSignOut;
import com.automation.integration.BaseSuiteIT;

public class UserSignOutTest extends BaseSuiteIT {

	UserSignOut	userEndSession;

	@Test()
	public void signOut() {

		userEndSession = new UserSignOut(driver, extentLogger);
		userEndSession.signOut();
	}
}
