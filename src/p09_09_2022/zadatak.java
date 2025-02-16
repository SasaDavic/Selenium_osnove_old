package p09_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class zadatak {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();   
		driver.manage().window().maximize();	//max prozor
		driver.get("https://cms.demo.katalon.com/");	//Ucitava stranicu
		WebElement searshInput = driver.findElement(By.xpath("//input[@name='s']")); //deo za pretragu
													//By.name("s")
		searshInput.sendKeys("Flying Ninja");	//unosi tekst Flying Ninja
		
		Thread.sleep(10000);	//Ceka 10 sekuni
		driver.quit();	//Zatvara pretrazivac

	}

}
