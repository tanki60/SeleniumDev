package com.automation;

import org.testng.annotations.Test;

import com.automation.base.BaseSuite;
import com.automation.dto.HotelsTab;
import com.automation.util.GenericMethods;
import com.relevantcodes.extentreports.LogStatus;

public class HotelsTabTest extends BaseSuite {

	HotelsTab	hotelsTab;

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

	@Test(priority = 3, enabled = false)
	public void pageLinks() {
		GenericMethods.testPageLinks(driver);
	}

}
