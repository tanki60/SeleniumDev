package com.automation.dto;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.util.GenericMethods;

public class ToursTab {

	static Logger		log	= Logger.getLogger(ToursTab.class);

	private WebDriver	driver;

	@FindBy(xpath = "//div[@class='container']/ul/li[@data-title='TOURS']")
	private WebElement	toursTab;

	@FindBy(css = "#TOURS > div > form > div.go-text-right > div.form-group.go-right.xl > div.row > div:nth-of-type(2) > a > span:nth-of-type(1)")
	private WebElement	toursTxtBox;

	@FindBy(css = "body > div:nth-of-type(20) > div > input")
	private WebElement	toursTxtTypeAhead;

	@FindBy(xpath = "//input[@class='form input-lg tchkin']")
	private WebElement	checkInDateClick;

	@FindBy(xpath = "//div[@class='datepicker dropdown-menu' and contains(@style, 'display: block; top')]//div[@class='datepicker-days']/table/thead/tr[1]/th[3]")
	private WebElement	checkInDateIcon;

	@FindBy(xpath = "//div[@class='datepicker dropdown-menu'][3]//div[@class='datepicker-days'][1]/table/tbody/tr[4]/td[1]")
	private WebElement	checkInDateSelect;

	@FindBy(xpath = "//div[@id='TOURS']//select[@id='adults']")
	private WebElement	numOfAdultDrpDwn;

	@FindBy(xpath = "//select[@id='tourtype']")
	private WebElement	tourType;

	@FindBy(xpath = "//div[@id='TOURS']/div/form/div[5]/div/button")
	private WebElement	performSearch;

	public ToursTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void gotoHome() {
		GenericMethods.selectByLinkText(driver, "Home");
		log.info("Clicked Home");

	}

	public void selectToursTab() {
		GenericMethods.checkVisibilityofElementAndClick(driver, toursTab);
		// toursTab.click();
		log.info("Finished method selectFlightsTab() ");

	}

	public void selectDestinationLocation(String hotelName) {
		this.toursTxtBox.click();
		this.toursTxtTypeAhead.sendKeys(hotelName);
		this.toursTxtTypeAhead.sendKeys(Keys.RETURN);
		log.info("Finished selectDestinationLocation: " + hotelName);
	}

	public void selectCheckInDateTxtBox() {
		checkInDateClick.click();
		log.info("Finished checkInDateClick.click()");
	}

	public void clickNextMonthIcon() {
		GenericMethods.javaScriptClickByElement(driver, checkInDateIcon);
		log.info("Finished checkInDateIcon.click()");
	}

	public void selectCheckInDate() {

		checkInDateSelect.click();
		log.info("Finished checkInDateSelect.click()");
	}

	public void selectNumOfAdultDrpDwn() {

		numOfAdultDrpDwn.click();

		Select adultDrpDwn = new Select(numOfAdultDrpDwn);
		adultDrpDwn.selectByVisibleText("3");
		log.info("Selected selectNumOfAdultDrpDwn()");
	}

	public void selectTourTypeDrpDwn() {

		tourType.click();

		Select tourTypeDrpDwn = new Select(tourType);
		tourTypeDrpDwn.selectByIndex(1);
		log.info("Selected selectTourTypeDrpDwn");

	}

	public void performPackageSearch() {
		performSearch.click();
		log.info("Finished performPackageSearch()");
	}

}
