package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Ucitati stranicu https://demoqa.com/modal-dialogs
Kliknuti na dugme Large modal
Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke

		 */

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/modal-dialogs");// ne moze da ucita kasnije...
		
		Thread.sleep(2000);
		driver.quit();
	}

}
