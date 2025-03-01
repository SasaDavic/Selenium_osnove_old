package p19_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UvodUTestNG {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		driver = new ChromeDriver();				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://google.com/");
	}
	
	@Test (priority = 10)
	public void openHomePage() {
		
			
		String actualTitle = driver.getTitle(); //Naslov stranice - iz taba!
		String expectedTitle = "Google";
		
		Assert.assertEquals(actualTitle, expectedTitle, "Error: Unexpected title.");
		
	/*	if(actualTitle.equals(expectedTitle)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	*/
		
		String actualLang = driver
				.findElement(By.tagName("html"))
				.getAttribute("lang");
		String expectedLang = "sr";
		
		Assert.assertEquals(actualLang, expectedLang, "Expected lang is sr!");
		
		
	}

	@Test (priority = 20)
	public void search() {
		driver.findElement(By.name("q")).sendKeys("IT BOOTCAMP");
		
		new Actions(driver)
			.sendKeys(Keys.ENTER)
			.perform();
		
		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='rso']/div/div/div//a")));
		driver.findElement(By.xpath("//*[@id='rso']/div/div/div//a")).click();
		String actualTitle = driver.getTitle(); //Naslov stranice - iz taba!
		String expectedTitle = "ITBootcamp - Besplatna IT prekvalifikacija - Free IT Bootcamp in cooperation with the Divac Foundation";
		
		Assert.assertEquals(actualTitle, expectedTitle, "Error: Unexpected title.");
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
