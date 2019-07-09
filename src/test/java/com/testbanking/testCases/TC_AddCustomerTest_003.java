package com.testbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testbanking.pageobjects.AddCustomerPage;
import com.testbanking.pageobjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("User name is provided");
		lp.setPassword(Password);
		logger.info("Passsword is provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();

		logger.info("providing customer details....");

		addcust.custName("Sivaram");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("CHE");
		addcust.custstate("TN");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");

		String email = randomstring() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();

		Thread.sleep(3000);

		logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");

		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}

	}

	

}
