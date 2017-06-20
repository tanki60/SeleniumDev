package com.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseSuite;
import com.automation.dto.BookAsGuest;
import com.automation.dto.FeaturedHotels;
import com.relevantcodes.extentreports.LogStatus;

public class CaseThreeTest extends BaseSuite {

	@Test
	public void featuredHotel() {

		FeaturedHotels featureHotl = new FeaturedHotels(driver);

		featureHotl.selectFeaturedHotel();
		extentLogger.log(LogStatus.INFO, "Clicked on featured hotel deal");
		featureHotl.selectAdultDrpDwn();
		extentLogger.log(LogStatus.INFO, "Clicked on number of adults drop down");
		featureHotl.modifyResults();
		extentLogger.log(LogStatus.INFO, "Updated the result by clicking Modify button");
		featureHotl.viewDetails();
		extentLogger.log(LogStatus.INFO, "Viewed hotel details");
		featureHotl.viewAvailability();
		extentLogger.log(LogStatus.INFO, "Confirmed hotel availability");
		featureHotl.clickBookNow();
		extentLogger.log(LogStatus.PASS, "Clicked on book now button");
	}

	@Test(dependsOnMethods = { "featuredHotel" })
	public void continueAsGuest() {

		BookAsGuest guest = new BookAsGuest(driver);

		guest.clickAsGuestBtn();
		extentLogger.log(LogStatus.INFO, "Selected Guest option");
		guest.setFirstName();
		extentLogger.log(LogStatus.INFO, "Typed first name");
		guest.setLastName();
		extentLogger.log(LogStatus.INFO, "Typed last name");
		guest.setEmailAndConfirm();
		extentLogger.log(LogStatus.INFO, "Typed and confirmed email");
		guest.setAddress();
		extentLogger.log(LogStatus.INFO, "Typed address");
		guest.setMobile();
		extentLogger.log(LogStatus.INFO, "Typed phone number");
		guest.clikAndSelectCountry();
		extentLogger.log(LogStatus.INFO, "Selected Country");
		guest.addExtras();
		extentLogger.log(LogStatus.INFO, "Added extra options");
		guest.clickCompleteBookingBtn();
		extentLogger.log(LogStatus.INFO, "Clicked complete booking");
		guest.selectPayOnArrival();
		extentLogger.log(LogStatus.INFO, "Selected Pay of Arrival option");
		guest.selectPopUp();
		extentLogger.log(LogStatus.INFO, "Closed pop up");
		Assert.assertTrue(guest.confirmSuccessMsg(), "Sucessfully Booked!...");
		extentLogger.log(LogStatus.PASS, "Booking Completed...");

	}
}
