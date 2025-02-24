package p16_09_2022;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
	/*
	 * Napisati program testira upload funkcionalnost: Koristan link https://www.guru99.com/upload-download-file-selenium-webdriver.html
Ucitava stranicu https://crop-circle.imageonline.co/#circlecropresult
Uploadujte sliku na sajt
Kliknite na dugme Crop Circle

	 */
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://crop-circle.imageonline.co/#circlecropresult");
	
		//	driver.findElement(By.id("inputImage")).sendKeys("C:\\Users\\KTG\\Downloads\\lupa.jpeg");
		File slika = new File("img/lupa.jpeg");
		driver.findElement(By.id("inputImage")).sendKeys(slika.getAbsolutePath());
		
		WebElement photoButton = driver.findElement(By.id("photobutton"));
		
		new Actions(driver)
			.moveToElement(photoButton)
			.perform();
		
		photoButton.click();
		
		Thread.sleep(5000);
		driver.quit();

	}

}
