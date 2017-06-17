package com.automation;


import com.automation.base.BaseSuite;
import com.automation.dto.UserSignOut;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class UserSignOutTest extends BaseSuite {

	UserSignOut	userEndSession;

	@Test()
	public void signOut() {

		userEndSession = new UserSignOut(driver);

		userEndSession.selectMyAccountDrpDwn();
		extentLogger.log(LogStatus.INFO, "Clicked My Account drop down");
		userEndSession.clickLogoutOption();
		extentLogger.log(LogStatus.INFO, "Signed Out...");
	}
}
