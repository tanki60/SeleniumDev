package com.automation.base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.automation.constants.SiteConstants;
import com.automation.util.GenericMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*
 * All test classes will extent this for sharing the @methods.
 */
public class BaseSuite {

	protected WebDriver		driver;
	private String			baseUrl;
	protected ExtentReports	reports;
	protected ExtentTest	extentLogger;

	@BeforeClass
	@Parameters({ "browser" })
	public void beforeClass(String browser) {

		// get the substring of class name to be used for name of custom reports
		// generated.
		String partOfReportName = GenericMethods.splitStringByChar(this.getClass().getName(), ".", 2);

		reports = new ExtentReports(SiteConstants.EXTENT_REPORTS_LOCATION + SiteConstants.EXTENT_REPORTS_PREFIX
				+ partOfReportName + SiteConstants.EXTENT_REPORTS_EXT);
		reports.loadConfig(new File(SiteConstants.EXTENT_CONFIG_LOCATION));

		extentLogger = reports.startTest("Verify " + partOfReportName);
		extentLogger.setDescription(partOfReportName);

		PropertyConfigurator.configure(SiteConstants.LOG4J_FILE_LOCATION);

		if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}

		extentLogger.log(LogStatus.INFO, browser + " browser started....");
		baseUrl = SiteConstants.SITE_BASE_URL;
		driver.manage().window().maximize();
		extentLogger.log(LogStatus.INFO, "Browser maximised");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		extentLogger.log(LogStatus.INFO, "Web Application opened");
	}

	@AfterClass
	public void afterClass() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		reports.endTest(extentLogger);
		reports.flush();
	}

}
