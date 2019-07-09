package com.testbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver = null;

	public LoginPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name = "btnlogin")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath = "/html/body/div[3]/div/u1/li[5]/a")
	@CacheLookup
	WebElement lnklogout;

	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickSubmit() {
		btnLogin.click();

	}

	public void justSubmit() {
		txtPassword.submit();
	}

	public void logout() {
		lnklogout.click();
	}

}
