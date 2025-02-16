package p13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

	public static void main(String[] args) throws InterruptedException {
	/*	Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
			Hvata sve elemente prve kolone i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku 
			Ceka 1s
			Hvata sve elemente prvog reda i stampa tekst svakog elementa 
			Ceka 5s
			Zatvara pretrazivac */


		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://s.bootsnipp.com/iframe/z80en");
		
		List<WebElement> textKolona =
				driver.findElements(By.xpath("//*[@id='lorem']//tbody/tr/td[1]"));
		
		for (int i = 0; i < textKolona.size(); i++) {
			System.out.println(textKolona.get(i).getText());
			Thread.sleep(1000);
		}
		
		List<WebElement> textRed =
				driver.findElements(By.xpath("//*[@id='lorem']//tbody/tr[1]/td"));
		
		for (int i = 0; i < textRed.size(); i++) {
			System.out.println(textRed.get(i).getText());
		}

		Thread.sleep(5000);
		driver.quit();
	}

}
