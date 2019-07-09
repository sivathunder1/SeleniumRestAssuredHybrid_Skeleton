package com.testbanking.testCases;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.testbanking.pageobjects.LoginPage;

public class TC_Login_DDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String uname, String pwd) {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("User name has been provided");
		lp.setPassword(pwd);
		logger.info("Password has been provided");
		lp.clickSubmit();
		logger.info("Button has been clicked");

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			logger.info("Alert has been dismissed");
			driver.switchTo().defaultContent();
			logger.info("Rolled back to default window");
			Assert.assertTrue(false);
			logger.info("Case failed");
		} else {
			Assert.assertTrue(true);
			logger.info("Case succcess");
			lp.logout();
			logger.info("Applicaiton has been logged out");
			driver.switchTo().alert().accept();
			logger.info("Accepeted logout Alert");
			driver.switchTo().defaultContent();
			logger.info("Rolled back to default window");
		}

	}

	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;

		}

	}

}
