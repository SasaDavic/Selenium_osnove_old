package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		// Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com/");
		
		Select dropdown = new Select(driver.findElement(By.name("_sacat")));
		dropdown.selectByValue("14339");
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
