package com.automation;

import com.automation.base.BaseSuite;
import com.automation.dto.ToursTab;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class ToursTabTest extends BaseSuite {

	ToursTab	toursTab;

	@Test()
	public void silectTours() {

		toursTab = new ToursTab(driver);
		toursTab.gotoHome();
		extentLogger.log(LogStatus.INFO, "Selected Home Page");
		toursTab.selectToursTab();
		extentLogger.log(LogStatus.INFO, "Selected Tours Tab");
		toursTab.selectDestinationLocation("Cairo");
		extentLogger.log(LogStatus.INFO, "Selected location");
		toursTab.selectCheckInDateTxtBox();
		toursTab.clickNextMonthIcon();
		toursTab.selectCheckInDate();
		extentLogger.log(LogStatus.INFO, "Selected check-in date");
		toursTab.selectNumOfAdultDrpDwn();
		extentLogger.log(LogStatus.INFO, "Selected number of adults");
		toursTab.selectTourTypeDrpDwn();
		extentLogger.log(LogStatus.INFO, "Selected type of tour");
		extentLogger.log(LogStatus.PASS, "Verified Tours Tab...");

	}

	@Test(priority = 2, enabled = false)
	public void searchTours() {

		toursTab.performPackageSearch();

	}

}
