package browsertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTestFirefox {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path : " + projectPath);

		System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckoDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://mvnrepository.com/search?q=Junit");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();

	}

}
