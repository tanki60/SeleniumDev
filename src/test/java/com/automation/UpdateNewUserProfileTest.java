package com.automation;


import com.automation.base.BaseSuite;
import com.automation.dto.UpdateNewUserProfile;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class UpdateNewUserProfileTest extends BaseSuite{

	UpdateNewUserProfile	updateProfile;

	@Test
	public void updateNewUserProfileAndSave() {

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
}
