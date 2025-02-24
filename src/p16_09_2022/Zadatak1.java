package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
	/*
Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
Implicitno cekanje za trazenje elemenata je maksimalno 10s
Implicitno cekanje za ucitavanje stranice je 5s
Ucitava stranicu https://docs.katalon.com/
Maksimizuje prozor
Od html elementa cita data-theme atribut. 
Korisni linkovi za citanje vrednosti atributa link1 i link2
Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
Klikce na dugme za zamenu tema
Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…kako izvrsavati precice preko Actions objekta
Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search

	 */
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.get("https://docs.katalon.com/");
		
		driver.manage().window().maximize();
		
		WebElement html = driver.findElement(By.tagName("html"));
		String dataThemeAttribute = 
				html.getAttribute("data-theme");
		
		if (dataThemeAttribute.equals("light")) {
			System.out.println("Light theme");
		} else {
			System.out.println("It's not light theme");
		}
		
		driver.findElement(By.xpath("//*[contains(@class, 'clean-btn toggleButton_gllP')]")).click();
		
		dataThemeAttribute = 
				html.getAttribute("data-theme");
		
		if (dataThemeAttribute.equals("light")) {
			System.out.println("It's not dark theme");
		} else {
			System.out.println("Dark theme");
		}
	
		new Actions(driver)
			.keyDown(Keys.CONTROL)
			.sendKeys("K")
			.perform();
		
		if (driver.findElement(By.className("DocSearch-Input")).getAttribute("type").equals("search")) {
			System.out.println("Type is search");
		} else {
			System.out.println("Type is not search");
		}
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
