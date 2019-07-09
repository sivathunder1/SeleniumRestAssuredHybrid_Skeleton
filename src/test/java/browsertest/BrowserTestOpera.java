package browsertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserTestOpera {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path : " + projectPath);

		System.setProperty("webdriver.edge.driver", projectPath + "\\drivers\\edgedriver\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		

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
