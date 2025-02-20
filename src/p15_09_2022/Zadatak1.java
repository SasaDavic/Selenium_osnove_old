package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
	/*
	 * Napisati program koji prijavljivanju na stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.

	 */
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://cms.demo.katalon.com/my-account/");
		
		WebElement checkbox = 
				driver.findElement(By.xpath("//input[contains(@type, 'checkbox')]"));
		
		checkbox.click();
		
		if (checkbox.isSelected()) {
			System.out.println("Checked!");
		} else {
			System.out.println("Not checked!");
		}
		Thread.sleep(3000);
		driver.quit();
	}

}
