package com.automation;

import org.testng.annotations.Test;

import com.automation.base.BaseSuite;
import com.automation.dto.FlightsTab;

public class FlightsTabTest extends BaseSuite {

	FlightsTab	flightsTab;

	@Test(priority = 1)
	public void selectFlights() {

		flightsTab = new FlightsTab(driver,extentLogger);
		flightsTab.selectFlight();
	}

	@Test(priority = 2, enabled = false, dependsOnMethods = { "selectFlights" })
	public void searchFlights() {

		flightsTab.searchFlights();
	}

}
