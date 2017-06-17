package com.automation.dto;


import com.automation.constants.SiteConstants;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserSignOut {
	
	static Logger log = Logger.getLogger(UserSignOut.class);
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='navbar-collapse collapse']/ul/li[2]/ul/li[2]")
	WebElement		logoutOption;
	
	@FindBy(xpath = "//div[@class='navbar-collapse collapse']/ul/li[2]/a")
	WebElement		myAccountDrpDwn;
	
	
	public UserSignOut(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		log.info("Init page factory");
	}
	
	public void selectMyAccountDrpDwn()
	{
		myAccountDrpDwn.click();
		log.info("Logged in user : "+myAccountDrpDwn.getText());
		log.info("Slected My Account drop down");
	}

	public void clickLogoutOption()
	{
		logoutOption.click();
		log.info("Signed out...");
	}
	
	public boolean confirmLoggedOut()
	{
		boolean isLoggedOut=false;
		if (myAccountDrpDwn!=null && myAccountDrpDwn.getText().equals(SiteConstants.USER_LOGOUT_TEXT)){
			log.info("Signed out...");
			log.info("Logged in user : "+myAccountDrpDwn.getText());
			isLoggedOut= true;
		}else{
			log.info("Log-out falied...");
			log.info("Logged in user : "+myAccountDrpDwn.getText());
		}
		
		return isLoggedOut;
	}

}
