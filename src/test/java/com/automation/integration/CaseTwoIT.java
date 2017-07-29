package com.automation.integration;

import org.testng.annotations.Test;

import com.automation.dto.HotelResults;
import com.automation.dto.HotelsTab;
import com.automation.util.GenericMethods;

public class CaseTwoIT extends BaseSuiteIT {

	HotelsTab		hotelsTab;
	HotelResults	hotelResults;

	@Test(priority = 1)
	public void selectHotel() throws InterruptedException {
		hotelsTab = new HotelsTab(driver,extentLogger);
		hotelsTab.selectHotel();
		hotelsTab.searchFoResults();

	}

	@Test(dependsOnMethods = { "selectHotel" })
	public void modifyResults() {

		hotelResults = new HotelResults(driver,extentLogger);
		hotelResults.modifySearchCriteria();
		

	}

	@Test(priority = 3, enabled = false)
	public void pageLinks() {
		GenericMethods.testPageLinks(driver);
	}

}
