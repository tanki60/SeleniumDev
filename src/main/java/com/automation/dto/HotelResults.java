package com.automation.dto;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.util.GenericMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HotelResults {

	private WebDriver	driver;
	private ExtentTest	extentLogger;

	static Logger		log	= Logger.getLogger(HotelResults.class);

	@FindBy(css = ".form.input-lg.dpd1")
	private WebElement	checkInDate;

	@FindBy(css = ".next")
	private WebElement	flipMonthIcon;

	@FindBy(xpath = "//div[@class='datepicker dropdown-menu' and contains(@style,'display: block')]/div/table/tbody/tr[3]/td[3]")
	private WebElement	pickDay;

	@FindBy(xpath = "//div[@id='collapse1']//input[@id='4']")
	private WebElement	starGrade;

	@FindBy(xpath = "//div[@id='collapse2']/div/div/div[1]/div[2]")
	private WebElement	priceRange;

	@FindBy(xpath = "//div[@id='collapse3']/div[1]/div[2]/div/ins")
	private WebElement	propertyType;

	@FindBy(xpath = "//div[@id='collapse4']/div[1]/div[2]/div/ins")
	private WebElement	amenities;

	@FindBy(css = "#searchform")
	private WebElement	search;

	@FindBy(xpath = "//div[@class='itemscontainer']/h1")
	private WebElement	results;

	public HotelResults(WebDriver driver, ExtentTest extentLogger) {

		this.driver = driver;
		this.extentLogger = extentLogger;
		PageFactory.initElements(driver, this);
	}

	public void clickCheckInDate() {
		checkInDate.click();
		log.info("Clicked clickCheckInDate");
	}

	public void clickFlipMonthIcon() {
		flipMonthIcon.click();
		log.info("Clicked clickFlipMonthIcon");
	}

	public void clickPickDay() {
		pickDay.click();
		log.info("Clicked clickPickDay");
	}

	public void clickStarGrade() {

		GenericMethods.javaScriptClickByElementLocation(driver, starGrade, "y");
		// starGrade.click();
		log.info("Clicked clickStarGrade");
	}

	public void selectPriceRange() {

		GenericMethods.javaScriptClickByElementLocation(driver, priceRange, "y");
		Actions action = new Actions(driver);
		action.dragAndDropBy(priceRange, 50, 0).perform();
		log.info("Clicked selectPriceRange");
	}

	public void clickPropertyType() {

		GenericMethods.javaScriptClickByElementLocation(driver, propertyType, "y");
		// propertyType.click();
		log.info("Clicked clickPropertyType");
	}

	public void clickAmenities() {
		GenericMethods.javaScriptClickByElementLocation(driver, amenities, "y");
		// amenities.click();
		log.info("Clicked clickAmenities");
	}

	public void clickSearch() {

		GenericMethods.javaScriptClickByElementLocation(driver, search, "y");
		// search.click();
		log.info("Clicked clickSearch");
	}

	public boolean checkResults() {

		boolean isEmpty = false;
		String txt = GenericMethods.getElementText(driver, "//div[@class='itemscontainer']/h1");
		if (txt.equals("No Results!!")) {

			isEmpty = true;
		}

		return isEmpty;
	}

	public void modifySearchCriteria() {

		clickCheckInDate();
		clickFlipMonthIcon();
		clickPickDay();
		extentLogger.log(LogStatus.INFO, "Updated check-in date");
		clickStarGrade();
		extentLogger.log(LogStatus.INFO, "Updated Star Garde");
		selectPriceRange();
		extentLogger.log(LogStatus.INFO, "Updated price range");
		clickPropertyType();
		extentLogger.log(LogStatus.INFO, "Updated property type");
		clickAmenities();
		extentLogger.log(LogStatus.INFO, "Updated amenities");
		clickSearch();
		extentLogger.log(LogStatus.INFO, "re-searched");
		Assert.assertTrue(checkResults());
		extentLogger.log(LogStatus.PASS, "Verified Results...");
	}

}
