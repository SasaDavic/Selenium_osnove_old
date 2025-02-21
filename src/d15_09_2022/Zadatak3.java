package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Napisati program koji 
Ucitava https://seeds.sproutsocial.com/components/loader-button/
Odskrola do Loader buttons are used to display a loading indicator inside of a button. paragrafa. Koristan link
Klikce ne dugme 
Ceka da dugme zavrsi sa loadingom 
Ispisati poruku na ekranu
Zatvoriti pretrazivac
HINT: Koristite data-qa-button-isloading  atribut elementa za cekanje odredjenog stanja tog elementa

		 */
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://seeds.sproutsocial.com/components/loader-button/");
		
		WebElement loadButton = driver.findElement(By.tagName("button"));
		new Actions(driver)
			.moveToElement(loadButton)
			.perform();
		
		driver.findElement(By.tagName("button")).click();
		
		boolean loadingStops = true;
		try {
			driver.findElement(By.xpath("//*[contains(@data-qa-button-isloading, 'false')]"));
		} catch (Exception e) {
			loadingStops = false;
		}
		
		if (loadingStops) {
			System.out.println("Loading end");
		} else {
			System.out.println("Loading didn't end");
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}
