package com.automation;




import com.automation.base.BaseSuite;
import com.automation.dto.CarsTab;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
/**
 * 
 * @author Tanky
 *
 */

public class CarsTabTest extends BaseSuite {

	CarsTab	carsTab;

	@Test(priority = 0)
	public void selectCar() {

		carsTab = new CarsTab(driver);
		carsTab.gotoHome();
		extentLogger.log(LogStatus.INFO, "Selected Home Page");
		carsTab.selectCarsTab();
		extentLogger.log(LogStatus.INFO, "Selected Cars Tab");
		carsTab.selectPickUpLocation();
		extentLogger.log(LogStatus.INFO, "Selected PickUp Location");
		carsTab.selectPickUpDateTxtBox();
		carsTab.clickPickUpMonthIcon();
		carsTab.selectPickUpDate();
		extentLogger.log(LogStatus.INFO, "Selected PickUp Date");
		carsTab.selectPickUpTimeDrpDwn();
		extentLogger.log(LogStatus.INFO, "Selected PickUp Time");
		carsTab.selectDrofOffDateTxtBox();
		carsTab.clickDropOffMonthIcon();
		carsTab.clickDropOffMonthIcon();
		carsTab.selectDropOffDate();
		extentLogger.log(LogStatus.INFO, "Selected Drop-Off Date");
		carsTab.selectDropOffTimeDrpDwn();
		extentLogger.log(LogStatus.INFO, "Selected Drop-Off Time");
		extentLogger.log(LogStatus.PASS, "Verified Tab....");

	}
	
	@Test(enabled=false, dependsOnMethods={"selectCar"})
	public void SearchCar() {

		carsTab.searchCarResults();

	}

}
