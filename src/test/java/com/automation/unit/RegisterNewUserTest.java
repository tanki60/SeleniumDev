package com.automation.unit;

import org.testng.annotations.Test;

import com.automation.dto.RegisterNewUser;
import com.automation.integration.BaseSuiteIT;

public class RegisterNewUserTest extends BaseSuiteIT {

	RegisterNewUser	newUser;

	@Test(groups = { "RegisterUpdateSignOut" }, priority = 1)
	public void optionToRegisterNewUser() {

		newUser = new RegisterNewUser(driver, extentLogger);
		newUser.registerUser();

	}

}
