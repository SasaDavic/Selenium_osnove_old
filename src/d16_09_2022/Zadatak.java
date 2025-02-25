package d16_09_2022;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Napisati program koji ima:
Podesava:
implicitno cekanje za trazenje elemenata od 10s
implicitno cekanje za ucitavanje stranice od 10s
eksplicitno cekanje podeseno na 10s
Podaci:
Potrebno je u projektu ukljuciti 4 slike.
Imenovanje slika neka bude po pravilu pozicija_ime_prezime_polaznika.ekstenzija
Npr: front_milan_jovanovic.jpg, left_milan_jovanovic.jpg …
Koraci:
Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
Maksimizuje prozor
Selektuje Image - Front klikom na tu karticu u dnu ekrana
Klik na add photo iz levog navigacionog menia
Upload slike. Upload preko File objekta koristeci getAbsolutePath
Sacekati da broj prikazanih slika u donjem uglu navigacije bude za 1 veca
Kliknuti na poslednje dodatu sliku kako bi bila izabrana za postavljanje
Ceka da dijalog bude vidljiv
Klik na Use One Side Only dugme
Ceka da se pojavi dijalog sa slikom
Klik na Done
Ponoviti proces za Left, Right i Back
Zatim iz desnog gornjeg ugla izabrati random jedan od ponudjenih konfeta
Kliknuti na Add To Cart dugme
Verifikovati postojanje greske Oops! It looks like you`ve not added an text to this field, please add one before continuing.
Xpath: //*[@action='error']
Zatvorite pretrazivac


		 */
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
		driver.manage().window().maximize();
		
		File slika1 = new File("img/front.png");
		File slika2 = new File("img/left.png");
		File slika3 = new File("img/right.jpeg");
		File slika4 = new File("img/back.jpg");
		
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("cube-0-image")));
		driver.findElement(By.id("cube-0-image")).click();
		driver.findElement(By.id("active-face")).click();
		//saceka da se pojavi meni za promenu slike
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//main/div[2]/div/div")));
		driver.findElement(By.id("image-option-replace")).click();
		//ceka da se pojavi dugme za upload
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("imageUpload")));
		//salje sliku iz projekta i bira je
		driver.findElement(By.id("imageUpload"))
				.sendKeys(slika1.getAbsolutePath());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'sc-iGgWBj')]/div[2]/div")));
		driver.findElement(By.id("image-option-0")).click();
		//ceka da se otvori novi meni za editovanje slike
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("image-crop-done-button")));
		driver.findElement(By.id("image-crop-done-button")).click();
		Thread.sleep(2000);
		
		//isti postupak za ostale 3 slike
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("cube-1-image")));
		driver.findElement(By.id("cube-1-image")).click();
		driver.findElement(By.id("active-face")).click();
		//ceka da se pojavi dugme za upload
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("imageUpload")));
		//salje sliku iz projekta i bira je
		driver.findElement(By.id("imageUpload"))
				.sendKeys(slika2.getAbsolutePath());
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'sc-iGgWBj')]/div[2]/div")));
		driver.findElement(By.id("image-option-0")).click();
		//ceka da se otvori novi meni za editovanje slike
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("image-crop-done-button")));
		driver.findElement(By.id("image-crop-done-button")).click();
		//treca slika
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("cube-2-image")));
		driver.findElement(By.id("cube-2-image")).click();
		driver.findElement(By.id("active-face")).click();
		//ceka da se pojavi dugme za upload
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("imageUpload")));
		//salje sliku iz projekta i bira je
		driver.findElement(By.id("imageUpload"))
				.sendKeys(slika3.getAbsolutePath());
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'sc-iGgWBj')]/div[2]/div")));
		driver.findElement(By.id("image-option-0")).click();
		//ceka da se otvori novi meni za editovanje slike
	//	wait.until(ExpectedConditions
	//			.visibilityOfElementLocated(By.id("image-crop-done-button")));
	//	driver.findElement(By.id("image-crop-done-button")).click();
		//cetvrta slika
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("cube-3-image")));
		driver.findElement(By.id("cube-3-image")).click();
		driver.findElement(By.id("active-face")).click();
		//ceka da se pojavi dugme za upload
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("imageUpload")));
		//salje sliku iz projekta i bira je
		driver.findElement(By.id("imageUpload"))
				.sendKeys(slika4.getAbsolutePath());
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'sc-iGgWBj')]/div[2]/div")));
		driver.findElement(By.id("image-option-0")).click();
		//ceka da se otvori novi meni za editovanje slike
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("image-crop-done-button")));
		driver.findElement(By.id("image-crop-done-button")).click();
		
		driver.findElement(By.id("next-button")).click();
		
		driver.findElement(By.id("textareaID")).sendKeys("Cestitamo!");
		Thread.sleep(2000);
		driver.findElement(By.id("next-button")).click();
		
		driver.findElement(By.id("confetti-1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("next-button")).click();
		//nakon dodavanja u korpu, stranica se ucitava vise od 5 min... nema svrhe raditi ostatak zadatka
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
