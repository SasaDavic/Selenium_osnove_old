package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
	/*
	 * Napisati program koji ucitava stranicu 
	 * https://s.bootsnipp.com/iframe/klDWV i ceka da se ucita 
	 * progress bar na 100% a zatim ispisuje tekst u konzoli “Stranica ucitana”
	 */
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://s.bootsnipp.com/iframe/klDWV");
		;
	//	wait.until(ExpectedConditions
	//			.textToBe(By.id("precent"), "100%"));
	// II nacin	
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated
				(By.xpath("//*[contains(@class,'container')]/div")));
		
		System.out.println("Stranica ucitana");
		Thread.sleep(5000);
		driver.quit();
	}

}
