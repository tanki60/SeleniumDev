package com.automation.integration;

import org.testng.annotations.Test;

import com.automation.dto.BookAsGuest;
import com.automation.dto.FeaturedHotels;

public class CaseThreeIT extends BaseSuiteIT {

	@Test
	public void featuredHotel() {

		FeaturedHotels featuredHotel = new FeaturedHotels(driver,extentLogger);
		featuredHotel.pickFeturedHotelOptions();
	}

	@Test(dependsOnMethods = { "featuredHotel" })
	public void continueAsGuest() {

		BookAsGuest guest = new BookAsGuest(driver,extentLogger);
		guest.pickBookAsGuest();

	}
}
