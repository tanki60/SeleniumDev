package com.automation.unit;

import org.testng.annotations.Test;

import com.automation.dto.ToursTab;
import com.automation.integration.BaseSuiteIT;

public class ToursTabTest extends BaseSuiteIT {

	ToursTab	toursTab;

	@Test(priority = 1)
	public void selectTours() {

		toursTab = new ToursTab(driver, extentLogger);
		toursTab.selectTour();
	}

	@Test(priority = 2, enabled = false, dependsOnMethods = { "selectTours" })
	public void searchTours() {

		toursTab.performPackageSearch();

	}

}
