package com.automation;


import com.automation.base.BaseSuite;
import com.automation.dto.HotelResults;
import com.automation.dto.HotelsTab;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.automation.util.GenericMethods;
import com.relevantcodes.extentreports.LogStatus;

public class CaseTwoTest extends BaseSuite {

	HotelsTab		hotelsTab;
	HotelResults	hotelResults;

	@Test(priority = 1)
	public void selectHotel() throws InterruptedException {
		hotelsTab = new HotelsTab(driver);
		hotelsTab.gotoHome();
		extentLogger.log(LogStatus.INFO, "Selected Home Page");
		hotelsTab.selectHotelTab();
		extentLogger.log(LogStatus.INFO, "Selected Hotels Tab");
		hotelsTab.setHotelName();
		hotelsTab.setHotelNameInput("new");
		extentLogger.log(LogStatus.INFO, "Selected name");
		hotelsTab.selectNumOfChildDrpDwn();
		extentLogger.log(LogStatus.INFO, "Selected number of children");
		hotelsTab.selectNumOfAdultDrpDwn();
		extentLogger.log(LogStatus.INFO, "Selected number of adult");
		hotelsTab.selectCalenderStartIcon();
		extentLogger.log(LogStatus.INFO, "Selected Arrival date");
		hotelsTab.selectCalenderEndIcon();
		hotelsTab.clickOnDefaultArea();
		extentLogger.log(LogStatus.INFO, "Selected departure date");

		hotelsTab.searchFoResults();
		extentLogger.log(LogStatus.PASS, "Verified Hotels Tab...");

	}

	@Test(dependsOnMethods = { "selectHotel" })
	public void modifyResults() {

		hotelResults = new HotelResults(driver);
		hotelResults.clickCheckInDate();
		hotelResults.clickFlipMonthIcon();
		hotelResults.clickPickDay();
		extentLogger.log(LogStatus.INFO, "Updated check-in date");
		hotelResults.clickStarGrade();
		extentLogger.log(LogStatus.INFO, "Updated Star Garde");
		hotelResults.selectPriceRange();
		extentLogger.log(LogStatus.INFO, "Updated price range");
		hotelResults.clickPropertyType();
		extentLogger.log(LogStatus.INFO, "Updated property type");
		hotelResults.clickAmenities();
		extentLogger.log(LogStatus.INFO, "Updated amenities");
		hotelResults.clickSearch();
		extentLogger.log(LogStatus.INFO, "re-searched");
		Assert.assertTrue(hotelResults.checkResults());
		extentLogger.log(LogStatus.PASS, "Verified Results...");

	}

	@Test(priority = 3, enabled = false)
	public void pageLinks() {
		GenericMethods.testPageLinks(driver);
	}

}
