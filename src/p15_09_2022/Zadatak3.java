package p15_09_2022;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {

		/*
Napisati program koji:
Ucitava stranicu  https://www.ebay.com/
Zatim iz selekta za kategoriju povlaci sve opcije. Koristan link
Zatim bira random element iz niza opcija koristeci Random. Vodite racuna da random element bude u opsegu broja elemenata niza. 
Random podsetnik
Selektuje random kategoriju izabranu u koraku iznad
Zatvara pretrazivac

		 */

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com/");
		
		Select dropbox = new Select(driver.findElement(By.id("gh-cat")));
		List<WebElement> opcije =
				dropbox.getOptions();
		
		Random random = new Random();
		int x = random.nextInt(opcije.size());
//		dropbox.selectByIndex(x);
		
		String name = opcije.get(x).getText();
		dropbox.selectByVisibleText(name);
		
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
