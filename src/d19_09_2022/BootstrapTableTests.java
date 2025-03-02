package d19_09_2022;


import java.nio.file.Files;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class BootstrapTableTests {
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://s.bootsnipp.com";
	private String imePolaznika = "Sasa";
	private String prezimePolaznika = "Zivkovic";
	private String srednjeImePolaznika = "Spira";
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@BeforeMethod
	public void BeforeMethod() {
		driver.get(baseUrl);
	}
	
	@Test (priority = 100)
	public void editRow() {
		driver.get(baseUrl + "/iframe/K5yrx"); 
		Assert.assertEquals(driver.getTitle(), 
				"Table with Edit and Update Data - Bootsnipp.com", 
				"Page title is not as expected!");
		driver.findElement(By.xpath("//tr[@id='d1']/td[5]/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit")));
		
		for (int j = 1; j < 4; j++) {
			driver.findElement(By.className("modal-body")).findElement(By.xpath("//input[" + j + "]")).clear();
		}
		driver.findElement(By.id("fn")).sendKeys(imePolaznika);
		driver.findElement(By.id("ln")).sendKeys(prezimePolaznika);
		driver.findElement(By.id("mn")).sendKeys(srednjeImePolaznika);
		driver.findElement(By.id("up")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("edit")));
		
		Assert.assertEquals(driver.findElement(By.xpath("//tr[@id='d1']/td[2]")).getText(), 
				imePolaznika, 
				"First name in table is not as expected");
		
		Assert.assertEquals(driver.findElement(By.xpath("//tr[@id='d1']/td[3]")).getText(), 
				prezimePolaznika, 
				"Last name in table is not as expected");
		
		Assert.assertEquals(driver.findElement(By.xpath("//tr[@id='d1']/td[4]")).getText(), 
				srednjeImePolaznika, 
				"Middle name in table is not as expected");
		
	}
	
	@Test (priority = 200)
	public void deleteRow() {
		driver.get(baseUrl + "/iframe/K5yrx"); 
		Assert.assertEquals(driver.getTitle(), 
				"Table with Edit and Update Data - Bootsnipp.com", 
				"Page title is not as expected!");
		
		int numOfRows = driver.findElements(By.xpath("//tbody/tr/td[1]")).size();
		
		driver.findElement(By.xpath("//tr[@id='d1']/td[6]/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("del")));
		driver.findElement(By.id("del")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("del")));
		Assert.assertEquals(numOfRows - 1, 
				driver.findElements(By.xpath("//tbody/tr/td[1]")).size(),
				"The number of rows in the table has not decreased by 1.");
	}
	
	@Test (priority = 300)
	public void takeAScreenshot() {
		driver.get(baseUrl + "/iframe/K5yrx"); 
		Assert.assertEquals(driver.getTitle(), 
				"Table with Edit and Update Data - Bootsnipp.com", 
				"Page title is not as expected!");
		
		 try {  // Napravi screenshot
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File screenshot = ts.getScreenshotAs(OutputType.FILE);

	            // Postavi folder gde želimo da sačuvamo sliku
	            Path destination = Path.of("img/screenshot.png");

	            // Kreiraj folder ako ne postoji
	  //           Files.createDirectories(destination.getParent());

	            // Kopiraj screenshot u zadati folder
	            Files.copy(screenshot.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

	            System.out.println("Screenshot uspešno sačuvan na: " + destination.toAbsolutePath());
	        } catch (IOException e) {
	            System.out.println("Greška pri čuvanju screenshota: " + e.getMessage());
	        }
	}
	
	@AfterMethod
	public void AfterMethod() {
	}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}

}
