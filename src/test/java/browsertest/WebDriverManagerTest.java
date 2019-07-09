package browsertest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		WebElement textbox = driver.findElement(By.xpath("//input[@name='q']"));
		textbox.sendKeys("Valentino Rossi");
		textbox.submit();

		List<WebElement> inputlist = driver.findElements(By.xpath("//input"));
		int inputelementcount = inputlist.size();
		System.out.println("Total count of input elements in the page : "+ inputelementcount);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();

	}

}
