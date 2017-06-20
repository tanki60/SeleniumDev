package com.automation;

import com.automation.base.BaseSuite;
import com.automation.dto.FlightsTab;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class FlightsTabTest extends BaseSuite {

	FlightsTab	flightsTab;

	@Test(priority = 0)
	public void selectFlights() {

		flightsTab = new FlightsTab(driver);
		flightsTab.gotoHome();
		extentLogger.log(LogStatus.INFO, "Selected Home Page");
		flightsTab.selectFlightsTab();
		extentLogger.log(LogStatus.INFO, "Selected Flights Tab");
		flightsTab.selectFlyingFrom();
		extentLogger.log(LogStatus.INFO, "Selected departure ");
		flightsTab.selectFlyingTo();
		extentLogger.log(LogStatus.INFO, "Selected arrival ");
		flightsTab.selectDepatureDate();
		extentLogger.log(LogStatus.INFO, "Selected departure date ");
		flightsTab.selectReturnDate();
		extentLogger.log(LogStatus.INFO, "Selected return date ");
		flightsTab.selectNumOfAdultDrpDwn();
		flightsTab.setNumOfAdultOkBtn();
		extentLogger.log(LogStatus.INFO, "Selected number of passengers ");
		extentLogger.log(LogStatus.PASS, "Verified Flights Tab....");
	}

	@Test(priority = 1, enabled = false, dependsOnMethods = { "selectFlights" })
	public void searchFlights() {

		flightsTab.searchFlights();
	}

}
