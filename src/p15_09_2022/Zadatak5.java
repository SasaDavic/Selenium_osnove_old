package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Ucitava stranicu https://demoqa.com/login
Loginuje se sa usename itbootcamp i lozinkom ITBootcamp2021!
Zatim ceka 5sekundi da se korisnik uloguje
Proverava da li se korisnik ulogovao, tako sto se proverava postojanje dugmeta Logout. 
Ispisati odgovarajucu poruku u konzoli za rezultat loginovanja.
Klikce na dugme za logout
Gasi stranicu

		 */
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/login"); // ne moze da ucita kasnije...
		
		Thread.sleep(5000);
		driver.quit();
	}

}
