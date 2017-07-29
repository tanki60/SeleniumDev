package com.automation.unit;

import org.testng.annotations.Test;

import com.automation.dto.UpdateNewUserProfile;
import com.automation.integration.BaseSuiteIT;

public class UpdateNewUserProfileTest extends BaseSuiteIT {

	UpdateNewUserProfile	updateUserProfile;

	@Test
	public void updateNewUserProfileAndSave() {

		updateUserProfile = new UpdateNewUserProfile(driver,extentLogger);
		updateUserProfile.updateProfile();
	}
}
