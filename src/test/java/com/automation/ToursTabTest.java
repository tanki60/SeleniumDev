package com.automation;

import org.testng.annotations.Test;

import com.automation.base.BaseSuite;
import com.automation.dto.ToursTab;

public class ToursTabTest extends BaseSuite {

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
