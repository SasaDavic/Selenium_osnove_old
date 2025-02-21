package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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

		driver.get("https://practice.expandtesting.com/login"); 
		String username = driver.findElement(By.xpath("//div[contains(@class, 'col-9')]/ul/li/b")).getText();
		String pass = driver.findElement(By.xpath("//div[contains(@class, 'col-9')]/ul/li[2]/b")).getText();
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pass);
		
		 WebElement buttonLogin = driver.findElement(By.id("login")).findElement(By.tagName("button")); //odskorlajte do login dugmeta
	        new Actions(driver)
	                .moveToElement(buttonLogin)
	                .perform();
	        
	        driver.findElement(By.id("login")).findElement(By.tagName("button")).click();
		
		boolean elementExist = true;
		try {
			driver.findElement(By.xpath("//div[contains(@class, 'container')]/a"));
		} catch (Exception e) {
			elementExist = false;
		}
		
		if (elementExist) {
			System.out.println("Korisnik se uspesno ulogovao!");
			driver.findElement(By.xpath("//div[contains(@class, 'container')]/a")).click();
		} else {
			System.out.println("Korisnik se nije ulogovao!");
		}
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
