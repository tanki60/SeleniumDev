package com.automation;

import org.testng.annotations.Test;

import com.automation.base.BaseSuite;
import com.automation.dto.CarsTab;

/**
 * 
 * @author Tanky
 * 
 */

public class CarsTabTest extends BaseSuite {

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
