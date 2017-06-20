package com.automation.dto;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.util.GenericMethods;

public class CarsTab {

	static Logger		log	= Logger.getLogger(CarsTab.class);

	private WebDriver	driver;

	@FindBy(xpath = "//a[@href='#CARS']")
	private WebElement	carsTab;

	// javascript
	@FindBy(xpath = "//div[@id='s2id_carlocations']/a")
	private WebElement	pickUp;

	@FindBy(xpath = "//input[@id='departcar']")
	private WebElement	pickUpDate;

	@FindBy(xpath = "//div[@class='datepicker dropdown-menu' and contains(@style,'display: block')]/div[1]/table/thead/tr/th[@class='next']")
	private WebElement	pickUpDateIcon;

	@FindBy(xpath = "//div[@class='datepicker dropdown-menu' and contains(@style,'top')]/div[contains(@style,'block')]/table/tbody/tr[3]/td[4]")
	private WebElement	pickUpDateSelect;

	@FindBy(xpath = "//div[@id='CARS']/div/form/div[4]/div/select[@name='pickupTime']")
	private WebElement	pickUpTimeDrpDown;

	@FindBy(xpath = "//input[@name='dropoffDate']")
	private WebElement	dropOffDate;

	@FindBy(xpath = "//div[@id='CARS']/div/form/div[6]/div/select[@name='dropoffTime']")
	private WebElement	dropOffTimeDrpDown;

	@FindBy(xpath = "//div[@class='datepicker-days' and @style='display: block;']/table/thead/tr/th[@class='next']")
	private WebElement	dropOffDateIcon;

	@FindBy(xpath = "//div[@class='datepicker dropdown-menu' and contains(@style, 'display: block;')]/div/table/tbody/tr[3]/td[4]")
	private WebElement	dropOffDateSelect;

	@FindBy(xpath = "//div[@id='CARS']//button[@type='submit']")
	private WebElement	searchCars;

	public CarsTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void gotoHome() {
		// GenericMethods.selectByLinkText(driver, "Home");
		log.info("Clicked Home");

	}

	public void selectCarsTab() {
		carsTab.click();

		log.info("Finished method selectCarsTab() ");

	}

	public void selectPickUpLocation() {

		pickUp.click();
		pickUp.sendKeys("kauai");
		pickUp.sendKeys(Keys.ENTER);
		log.info("Selected selectPickUpLocation()");
	}

	public void selectPickUpDateTxtBox() {
		pickUpDate.click();
		log.info("Finished selectpickUpDateTxtBox()");
	}

	public void clickPickUpMonthIcon() {
		GenericMethods.javaScriptClickByElement(driver, pickUpDateIcon);
		pickUpDateIcon.click();
		log.info("Finished clickPickUpMonthIcon()");
	}

	public void selectPickUpDate() {

		pickUpDateSelect.click();
		log.info("Finished selectCheckInDate()");
	}

	public void selectPickUpTimeDrpDwn() {

		pickUpTimeDrpDown.click();

		Select adultDrpDwn = new Select(pickUpTimeDrpDown);
		adultDrpDwn.selectByIndex(3);
		log.info("Selected selectPickUpTimeDrpDwn()");
	}

	public void selectDrofOffDateTxtBox() {
		dropOffDate.click();
		log.info("Finished selectDrofOffDateTxtBox()");
	}

	public void clickDropOffMonthIcon() {
		GenericMethods.javaScriptClickByElement(driver, dropOffDateIcon);
		log.info("Finished clickDropOffMonthIcon()");
	}

	public void selectDropOffDate() {

		dropOffDateSelect.click();
		log.info("Finished selectDropOffDate()");
	}

	public void selectDropOffTimeDrpDwn() {

		dropOffTimeDrpDown.click();

		Select adultDrpDwn = new Select(dropOffTimeDrpDown);
		adultDrpDwn.selectByIndex(3);
		log.info("Selected selectDropOffTimeDrpDwn()");
	}

	public void searchCarResults() {

		searchCars.click();
		log.info("Finished searchCarResults()");
	}

}
