package d15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Napisati program koji:
Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i 
ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
POMOC: Brisite elemente odozdo.
(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

		 */
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://s.bootsnipp.com/iframe/Dq2X"); 
		
		List<WebElement> lista = driver.findElements(By.className("close"));
		
		for (int i = 0; i < lista.size(); i++) {
		//	brisanje odogo	
		//	driver.findElement(By.xpath("//button[contains(@class, 'close')]")).click();
			
		// brisanje odozdo
			driver.findElement(By.xpath("//div[contains(@class, 'col-md-12')]/div[last()]/button")).click();
			Thread.sleep(1000);
		}
		
		Thread.sleep(1000);
		driver.quit();

	}

}
