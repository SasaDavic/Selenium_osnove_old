package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Ucitati stranicu https://cms.demo.katalon.com/
Maksimizovati prozor
Proveriri da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
Prostavite duzinu prozora na 700px i visinu na 700px
Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
		 */
				
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://cms.demo.katalon.com/");
		driver.manage().window().maximize();
		
		boolean display = 
				driver.findElement(By.xpath("//button[contains(@class, 'menu-toggle')]")).isDisplayed();
		if (display == true) {
			System.out.println("Menu dugme je vidljivo!");
		} else {
			System.out.println("Menu dugme nije vidljivo!");
		}
		
		driver.manage().window().setSize(new Dimension(700, 700));
		
		display = 
				driver.findElement(By.xpath("//button[contains(@class, 'menu-toggle')]")).isDisplayed();
		if (display == true) {
			System.out.println("Menu dugme je vidljivo!");
		} else {
			System.out.println("Menu dugme nije vidljivo!");
		}
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
