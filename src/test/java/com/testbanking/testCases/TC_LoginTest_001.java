package com.testbanking.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.testbanking.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() {

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(userName);
		logger.info("Entered username");

		lp.setPassword(Password);
		logger.info("Entered Password");

		lp.justSubmit();
		logger.info("Succesfully Subitted");

	}

}
