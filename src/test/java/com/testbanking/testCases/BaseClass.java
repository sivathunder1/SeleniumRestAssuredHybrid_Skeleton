package com.testbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.testbanking.utilities.ReadConfig;
import com.testbanking.utilities.XLUtils;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseUrl = readconfig.getApplicaitonURL();
	public String userName = readconfig.getUserName();
	public String Password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		logger = Logger.getLogger("TestBank");
		PropertyConfigurator.configure("log4j.properties");

		if (browser.equalsIgnoreCase("firefox")) {
			String projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();

		}

		else if (browser.equalsIgnoreCase("chrome")) {
			String projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("ie")) {
			String projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);
		logger.info("Opening the base URL");

	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/testbanking/testData/Data.xlsx";

		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j <= colcount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);

			}
		}
		return logindata;

	}

	@AfterClass
	public void tearDown() {
		driver.close();

	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShot Taken");
		logger.info("ScreenShot taken in failure");

	}

	public String randomstring() {
		String generatedString = RandomStringUtils.randomAlphanumeric(6);
		return generatedString;
	}

	public String randomnumeric() {
		String generatedNumeric = RandomStringUtils.randomNumeric(4);
		return generatedNumeric;
	}

	public String randomaplpahabets() {
		String generatedAlphabets = RandomStringUtils.randomAlphabetic(6);
		return generatedAlphabets;
	}

}
