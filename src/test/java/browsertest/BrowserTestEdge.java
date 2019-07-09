package browsertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserTestEdge {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path : " + projectPath);

		System.setProperty("webdriver.opera.driver", projectPath + "\\drivers\\operadriver\\operadriver.exe");
		WebDriver driver = new OperaDriver();

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
