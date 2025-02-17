package d13_09_2022;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
	/*
Napisati program koji matematicku formulu koju korisnik unese izvrsava na stranici:
Ucitati stranicu https://www.calculatorsoup.com/calculators/math/basic.php
Korisnik unosi formulu, samo osnovne matematicke operacija, npr:
1243+329=
21912-4=
12913÷4=
U programu se formula unosi kao jedan string i potrebno je razbiti formulu na karaktere. Za to imate metodu https://www.geeksforgeeks.org/convert-a-string-to-a-list-of-characters-in-java/
Zatim u odnosu na karakter uradite odredjenu logiku

	 */
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.calculatorsoup.com/calculators/math/basic.php");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Napisite formulu:");
		String formula = s.next();
		
		for (int i = 0; i < formula.length(); i++) {
			if (formula.charAt(i) == '0') {
				driver.findElement(By.name("cs_zero")).click();
			} else if (formula.charAt(i) == '1') {
				driver.findElement(By.name("cs_one")).click();
			} else if (formula.charAt(i) == '2') {
				driver.findElement(By.name("cs_two")).click();
			} else if (formula.charAt(i) == '3') {
				driver.findElement(By.name("cs_three")).click();
			} else if (formula.charAt(i) == '4') {
				driver.findElement(By.name("cs_four")).click();
			} else if (formula.charAt(i) == '5') {
				driver.findElement(By.name("cs_five")).click();
			} else if (formula.charAt(i) == '6') {
				driver.findElement(By.name("cs_six")).click();
			} else if (formula.charAt(i) == '7') {
				driver.findElement(By.name("cs_seven")).click();
			} else if (formula.charAt(i) == '8') {
				driver.findElement(By.name("cs_eight")).click();
			} else if (formula.charAt(i) == '9') {
				driver.findElement(By.name("cs_nine")).click();
			} else if (formula.charAt(i) == '+') {
				driver.findElement(By.name("cs_add")).click();
			} else if (formula.charAt(i) == '-') {
				driver.findElement(By.name("cs_subtract")).click();
			} else if (formula.charAt(i) == '*') {
				driver.findElement(By.name("cs_multiply")).click();
			} else if (formula.charAt(i) == '/') {
				driver.findElement(By.name("cs_divide")).click();
			} else if (formula.charAt(i) == '=') {
				driver.findElement(By.name("cs_equal")).click();
			}
		}
		
		Thread.sleep(5000);
		driver.quit();
		
		

	}
	
	

}
