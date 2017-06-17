package com.automation.dto;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.util.GenericMethods;



/*
 * This is the landing page for Kayak.com, which by default is Hotels tab
 */
public class HotelsTab {

	static Logger	log	= Logger.getLogger(HotelsTab.class);

	WebDriver		driver;

	@FindBy(xpath = "//div[contains(@id,'s2id') and contains(@class,'hotelsearch')]/a")
	WebElement		hotelTextBox;

	@FindBy(xpath = "//div[contains(@id,'s2id') and contains(@class,'hotelsearch')]/a")
	WebElement		hotelSearchText;

	@FindBy(xpath = "//div[@id='select2-drop']/ul/li/ul/li")
	WebElement		hotelListOption;

	@FindBy(xpath = "//div[@class='RTL_Bar searcharea']/div/ul/li/a[@href='#HOTELS']")
	WebElement		hotelTab;

	@FindBy(xpath = "//select[@id='adults']")
	WebElement		numOfAdultDrpDwn;

	@FindBy(xpath = "//select[@id='child']")
	WebElement		numOfChildDrpDwn;

	@FindBy(xpath = "//div[@id='ages' and contains(@style, 'color:')]//button[@class='btn btn-primary']")
	WebElement		childAgePopUp;

	@FindBy(xpath = "//div[@class='datepicker dropdown-menu' and (contains (@style, 'top'))]//div[@class='datepicker-days']/table/tbody/tr[3]/td[@class='day '][1]")
	WebElement		startDate;

	@FindBy(xpath = "//div[@class='datepicker dropdown-menu' and contains(@style, 'top:')]/div[@style='display: block;']/table/tbody/tr[4]/td[3]")
	WebElement		endDate;

	@FindBy(xpath = "//div[@class='datepicker dropdown-menu' and (contains (@style, 'top'))]/div[@class='datepicker-days']/table/thead/tr[1]/th[3]")
	WebElement		skipStartMonth;

	@FindBy(xpath = "//div[@class='datepicker dropdown-menu' and (contains (@style, 'top'))]/div[@class='datepicker-days']/table/thead/tr[1]/th[3]")
	WebElement		skipEndMonth;

	@FindBy(xpath = "//input[@name='checkin']")
	WebElement		calenderStartIcon;

	@FindBy(xpath = "//input[@name='checkout']")
	WebElement		calenderEndIcon;

	@FindBy(xpath = "//div[@class='wow fadeIn searchbg animated']")
	WebElement		airClick;

	@FindBy(css = ".btn-warning.btn.btn-lg.btn-block")
	WebElement		performHotelSearch;

	public HotelsTab(WebDriver webDriver) {

		this.driver = webDriver;
		PageFactory.initElements(webDriver, this);

	}
	
	public void gotoHome() {
		GenericMethods.selectByLinkText(driver, "Home");
		log.info("Clicked Home");

	}

	public void selectHotelTab() {
		this.hotelTab.click();
		log.info("Hotel tab clicked ");
	}

	public void setHotelName() {
		this.hotelTextBox.click();

		log.info("Inside setHotelName");
	}

	public void setHotelNameInput(String hotelName) {
		this.hotelSearchText.sendKeys(hotelName);
		GenericMethods.selectListOptionsByIndex(driver, "//div[@id='select2-drop']/ul/li/ul/li", 1);

		log.info("Inside setHotelNameInput: " + hotelName);
	}

	public void searchFoResults() {
		this.performHotelSearch.click();
		log.info("searchFoResults clicked");

	}

	public void selectNumOfChildDrpDwn() {

		numOfChildDrpDwn.click();
		Select childDrpDwn = new Select(numOfChildDrpDwn);
		childDrpDwn.selectByIndex(1);
		log.info("Selected selectNumOfChildDrpDwn");

	}

	public void selectNumOfAdultDrpDwn() {

		numOfChildDrpDwn.click();
		Select childDrpDwn = new Select(numOfAdultDrpDwn);
		childDrpDwn.selectByValue("1");
		log.info("Selected selectNumOfAdultDrpDwn");

	}

	public void clickChildAgePopUp() {
		if (this.childAgePopUp.isDisplayed()) {
			this.childAgePopUp.click();
		}
		log.info("clickChildAgePopUp clicked");

	}


	public void selectSkipStartMonth() {
		skipStartMonth.click();
		log.info("selectSkipMonth clicked");
	}

	public void selectSkipEndMonth() {
		skipEndMonth.click();
		log.info("selectSkipMonth clicked");
	}

	public void selectCalenderStartIcon() {
		calenderStartIcon.click();
		calenderStartIcon.click();
		calenderStartIcon.clear();
		String currDate = GenericMethods.getCurrentDate(false);
		calenderStartIcon.sendKeys(currDate);
		log.info("selectCalenderStartIcon clicked");
	}

	public void selectCalenderEndIcon() {
		calenderEndIcon.click();
		calenderEndIcon.clear();
		String currDate = GenericMethods.getCurrentDate(true);
		calenderEndIcon.sendKeys(currDate);
		log.info("selectCalenderEndIcon clicked");
	}

	public void clickOnDefaultArea() {
		airClick.click();
	}

}
