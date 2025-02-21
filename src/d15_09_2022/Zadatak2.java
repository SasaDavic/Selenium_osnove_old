package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Napisati program koji ucitava stranicu https://geodata.solutions/
Bira Country, State i City po vasoj zelji
Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
Izabrerit Country, State i City tako da imate podatke da selektujete!

		 */
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://practice.expandtesting.com/dropdown"); 
		
		Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));
		simpleDropdown.selectByVisibleText("Option 2");
		
		Thread.sleep(2000);
		Select dateOfBirth = new Select(driver.findElement(By.className("form-control")));
		dateOfBirth.selectByIndex(0);
		
		Thread.sleep(2000);
		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByValue("BS");
		
		Thread.sleep(1000);
		driver.quit();

		
	}

}
