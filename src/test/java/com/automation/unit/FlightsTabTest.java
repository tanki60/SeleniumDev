package com.automation.unit;

import org.testng.annotations.Test;

import com.automation.dto.FlightsTab;
import com.automation.integration.BaseSuiteIT;

public class FlightsTabTest extends BaseSuiteIT {

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
