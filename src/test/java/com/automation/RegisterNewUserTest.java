package com.automation;

import org.testng.annotations.Test;

import com.automation.base.BaseSuite;
import com.automation.dto.RegisterNewUser;

public class RegisterNewUserTest extends BaseSuite {

	RegisterNewUser	newUser;

	@Test(groups = { "RegisterUpdateSignOut" }, priority = 1)
	public void optionToRegisterNewUser() {

		newUser = new RegisterNewUser(driver, extentLogger);
		newUser.registerUser();

	}

}
