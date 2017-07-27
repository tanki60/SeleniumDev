package com.automation;

import org.testng.annotations.Test;

import com.automation.base.BaseSuite;
import com.automation.dto.HotelsTab;
import com.automation.util.GenericMethods;

public class HotelsTabTest extends BaseSuite {

	HotelsTab	hotelsTab;

	@Test(priority = 1)
	public void selectHotel() throws InterruptedException {
		hotelsTab = new HotelsTab(driver,extentLogger);
		hotelsTab.selectHotel();

	}
	
	@Test(priority = 2, enabled = false, dependsOnMethods = { "selectHotel" })
	public void searchHotel() throws InterruptedException {
		hotelsTab.searchFoResults();

	}

	@Test(priority = 3, enabled = false)
	public void pageLinks() {
		GenericMethods.testPageLinks(driver);
	}

}
