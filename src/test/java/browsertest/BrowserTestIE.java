package browsertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTestIE {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path : " + projectPath);

		System.setProperty("webdriver.ie.driver", projectPath + "\\drivers\\iedriver\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		

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
