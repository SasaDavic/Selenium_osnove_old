package p13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		/*
Maksimizuje prozor
Ucitava stranicu https://cms.demo.katalon.com/ 
U delu za pretragu unosi tekst Flying Ninja. 
Xpath za trazenje ovog elementa treba da bude preko name atributa
Klikce na dugme za pretragu. Dugme sa lupom. Kada trazite element dohvatite element koji je po tagu button a ne span. Xpath za trazenje ovog elementa treba da bude preko class atributa.
Ceka 5 sekuni
Zatvara pretrazivac

		 */
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://cms.demo.katalon.com/");
		
		WebElement searchInput =			//element koji trazimo na stranici je tipa WebElement
			driver.findElement(By.xpath("//input[@name='s']"));
//			driver.findElement(By.xpath("//input[contains(@class, 'search-field')]")); 
//				- moze i ovako ali se trazi u zadatku preko name atributa
			
		
		searchInput.sendKeys("Flying Ninja");
		
		WebElement searchButton =
				driver.findElement(By.xpath("//button[contains(@class, 'search-submit')]")); //trazimo dugme za pretragu
		
		searchButton.click();
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
