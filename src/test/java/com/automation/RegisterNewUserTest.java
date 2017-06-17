package com.automation;


import com.automation.base.BaseSuite;
import com.automation.dto.RegisterNewUser;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


public class RegisterNewUserTest extends BaseSuite {

	RegisterNewUser	newUser;

	@Test(groups={"RegisterUpdateSignOut"}, priority=1)
	public void optionToRegisterNewUser() {

		newUser = new RegisterNewUser(driver);
		
		newUser.selectRegisterOption();
		
		extentLogger.log(LogStatus.INFO, "Selected 'My Account'- 'Sign Up' option");

	}
	
	@Test(dependsOnMethods={"optionToRegisterNewUser"})
	public void fillAndSubmitNewUserInfo() {

		
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
		
		Assert.assertTrue(newUser.confirmLogInName());
		extentLogger.log(LogStatus.PASS, "Successfully created profile...");

	}

}
