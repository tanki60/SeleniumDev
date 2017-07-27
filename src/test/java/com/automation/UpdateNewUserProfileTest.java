package com.automation;

import org.testng.annotations.Test;

import com.automation.base.BaseSuite;
import com.automation.dto.UpdateNewUserProfile;

public class UpdateNewUserProfileTest extends BaseSuite {

	UpdateNewUserProfile	updateUserProfile;

	@Test
	public void updateNewUserProfileAndSave() {

		updateUserProfile = new UpdateNewUserProfile(driver,extentLogger);
		updateUserProfile.updateProfile();
	}
}
