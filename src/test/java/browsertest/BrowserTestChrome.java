package browsertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTestChrome {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path : " + projectPath);

		System.setProperty("webdriver.chrome.driver",
		"C:\\Users\\sivaram\\workspace\\TagitSeleniumFramework\\drivers\\chrome74\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
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
