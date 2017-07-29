package com.automation.unit;

import org.testng.annotations.Test;

import com.automation.dto.CarsTab;
import com.automation.integration.BaseSuiteIT;

/**
 * 
 * @author Tanky
 * 
 */

public class CarsTabTest extends BaseSuiteIT {

	CarsTab	carsTab;

	@Test(priority = 0)
	public void car() {

		carsTab = new CarsTab(driver,extentLogger);
		carsTab.selectCar();

	}

	@Test(enabled = false, dependsOnMethods = { "selectCar" })
	public void searchCar() {

		carsTab.searchCarResults();

	}

}
