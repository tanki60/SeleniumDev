package com.automation.util;

import com.automation.constants.SiteConstants;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is a utility class that shares common method between all test
 * suites.
 * 
 * @author Tanky
 * 
 */
public class GenericMethods {

	static Logger	log	= Logger.getLogger(GenericMethods.class);

	public synchronized static void javaScriptClickByElement(WebDriver driver, WebElement element) {
		try {

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

			log.debug("Clicked on element with using java script click");

		} catch (StaleElementReferenceException e) {
			log.debug("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			log.debug("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			log.debug("Unable to click on element " + e.getStackTrace());
		}
	}

	/*
	 * 
	 * Scroll down to the element x/y axis and click on that element
	 */
	public synchronized static void javaScriptClickByElementLocation(WebDriver driver, WebElement element, String axis) {
		try {

			if (axis.equals("x")) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + element.getLocation().x + ")");
			}

			else {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + element.getLocation().y + ")");
			}

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

			log.info("Scrolled to location:" + element.getLocation());

		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			log.info("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			log.info("Unable to click on element " + e.getStackTrace());
		}
	}

	public synchronized static void javaScriptPopUpClick(WebDriver driver) {

		try {
			// Wait 10 seconds till alert is present
			WebDriverWait wait = new WebDriverWait(driver, 3);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			// Accepting alert.
			alert.accept();
			System.out.println("Accepted the alert successfully.");
		} catch (Throwable e) {
			System.err.println("Error came while waiting for the alert popup. " + e.getMessage());
		}
	}

	public synchronized static void javaScriptClickByPath(WebDriver driver, String path, boolean isXpath) {
		try {

			WebElement element;

			if (isXpath == true) {
				element = driver.findElement(By.xpath(path));
			} else {

				element = driver.findElement(By.cssSelector(path));
			}

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			log.info("Clicked on xPath with using java script click");
		} catch (StaleElementReferenceException e) {
			log.debug("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			log.debug("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			log.debug("Unable to click on element " + e.getStackTrace());
		}
	}

	public synchronized static void checkVisibilityofElementAndClick(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement waitElement = wait.until(ExpectedConditions.visibilityOf(element));
		waitElement.click();
	}

	public synchronized static void checkVisibilityofElementLocatedAndClick(WebDriver driver, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement waitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		waitElement.click();
	}

	/*
	 * This method will select the option from drop down
	 * 
	 * @xpath= drop down to click
	 * 
	 * @optionAtIndex= option to select of drop down
	 * 
	 * @isNewTab = if option is new URL, then could open in new windows tab
	 */
	public synchronized static void selectListOptionsByIndex(WebDriver driver, String xpath, int optionAtIndex) {

		List<WebElement> listOptions = driver.findElements(By.xpath(xpath));
		WebElement option = listOptions.get(optionAtIndex);
		option.click();
	}

	/*
	 * This method is called when we want to switch the handle of a current page
	 * to a new handle. It will close the desired handle and focus on the needed
	 * one
	 */
	public synchronized static void windowsHandleHelper(WebDriver driver, String mainHandle, String purpose) {

		log.info("Main Handle Is: " + mainHandle);
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> handleIter = allWindowHandles.iterator();
		int handleSize = allWindowHandles.size();
		log.info("Total handle size is: " + handleSize);

		if (handleSize > 1) {
			while (handleIter.hasNext()) {

				String handle = handleIter.next();
				if (purpose.equals(SiteConstants.CLOSE_HANDLE_WINDOW)) {
					if (!mainHandle.equals(handle)) {

						driver.switchTo().window(handle);
						driver.close();
						driver.switchTo().window(mainHandle);
						log.info("PopUp Handle Closed: " + handle);
					}
				} else if (purpose.equals(SiteConstants.SWITCH_TO_NEW_HANDLE)) {
					if (!mainHandle.equals(handle)) {

						driver.switchTo().window(handle);
						log.info("Switch to Handle : " + handle);
					} else {
						driver.close();
						log.info("Closing Handle before Switching: " + handle);
					}
				} else {
					log.info("ERROR: There must be atlest 2 window handles: handleSize = " + handleSize);
				}

			}

		} else {
			log.info("ERROR: There must be atlest 2 window handles: handleSize = " + handleSize);
		}

	}

	public synchronized static boolean checkIfDisplayed(WebElement element) {

		boolean isDisplayed = element.isDisplayed();
		return isDisplayed;
	}

	public synchronized static boolean checkIfEnabled(WebElement element) {

		boolean isEnabled = element.isEnabled();
		return isEnabled;
	}

	/*
	 * Returns a current Date to be used in picking a Calendar date on page. If
	 * boolean if True, it will return +1 day to be used as futureDate (eg:
	 * carDropOff date)
	 */
	public synchronized static String getCurrentDate(boolean future) {

		Calendar c = Calendar.getInstance();
		Date date = Calendar.getInstance().getTime();

		c.setTime(date);

		if (future) {
			c.add(Calendar.DATE, 1);
			date = c.getTime();
		}

		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String formattedDate = formatter.format(date);

		return formattedDate;

	}

	/*
	 * Returns a list of all links in a given page.
	 */
	public synchronized static List<WebElement> getClickableLinks(WebDriver driver) {
		List<WebElement> pageClickableLinks = new ArrayList<WebElement>();
		List<WebElement> pageLinks = new ArrayList<WebElement>(driver.findElements(By.tagName("a")));
		pageLinks.addAll(driver.findElements(By.tagName("img")));

		for (WebElement aLink : pageLinks) {
			if (aLink.getAttribute("href") != null) {
				pageClickableLinks.add(aLink);
			} else {
				log.info("Not a clickble click" + aLink.getTagName());
			}
		}
		return pageClickableLinks;
	}

	/*
	 * This method checks the status of a given link
	 */
	public synchronized static String getLinkStatus(URL url) {
		String linkResponse = "";

		HttpURLConnection http;
		try {
			http = (HttpURLConnection) url.openConnection();
			http.connect();
			linkResponse = http.getResponseMessage();
			http.disconnect();
		} catch (IOException e) {
			log.info("Malformed URL: " + url + "		" + e.toString());
		}
		return linkResponse;
	}

	public synchronized static void testPageLinks(WebDriver driver) {
		List<WebElement> listOfClickableLinks = getClickableLinks(driver);

		for (WebElement alink : listOfClickableLinks) {
			String link = alink.getAttribute("href");

			try {
				getLinkStatus(new URL(link));
			} catch (MalformedURLException e) {
				log.info("Malformed URL: " + link);
				e.printStackTrace();
			}
		}
	}

	/*
	 * This method will return the desired substring of class name
	 */
	public synchronized static String splitStringByChar(String originalStr, String tokennizer, int tokenAt) {

		String[] parts = originalStr.split("\\" + tokennizer);
		System.out.println(parts);
		System.out.println(parts[tokenAt]);
		return parts[tokenAt];

	}

	public synchronized static String getElementText(WebDriver driver, String xpath) {

		WebElement element = driver.findElement(By.xpath(xpath));
		String text = element.getText();

		return text;
	}

	/*
	 * Generates fake email of size 10 chars
	 */
	public synchronized static String generateFakeEmail() {

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString().concat("@fake.co");

		return generatedString;
	}

	public synchronized static void selectByValueFromDropDown(WebDriver driver, WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);
	}

	public synchronized static void selectByLinkText(WebDriver driver, String value) {

		driver.findElement(By.linkText(value)).click();

	}

	public synchronized static void selectListOptionsByStringValue(WebDriver driver, String xpath, String find) {

		List<WebElement> listOptions = driver.findElements(By.xpath(xpath));

		Iterator<WebElement> accountIter = listOptions.iterator();

		while (accountIter.hasNext()) {

			WebElement element = accountIter.next();
			System.out.println("ALL:" + element.getText() + "     " + element.getText().length());
			if (element.getText().equals(find)) {
				element.click();
			} else {
			}
		}
	}

}
