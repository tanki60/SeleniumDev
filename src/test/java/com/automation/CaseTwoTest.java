package com.automation;

import org.testng.annotations.Test;

import com.automation.base.BaseSuite;
import com.automation.dto.HotelResults;
import com.automation.dto.HotelsTab;
import com.automation.util.GenericMethods;

public class CaseTwoTest extends BaseSuite {

	HotelsTab		hotelsTab;
	HotelResults	hotelResults;

	@Test(priority = 1)
	public void selectHotel() throws InterruptedException {
		hotelsTab = new HotelsTab(driver,extentLogger);

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
