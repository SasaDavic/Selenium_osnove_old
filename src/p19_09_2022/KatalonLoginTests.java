package p19_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KatalonLoginTests {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://cms.demo.katalon.com";
	
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
		driver.get(baseUrl);
	}
	
	@Test (priority = 100) 
	public void visitLoginPageFromNavBar() {
		
		driver.findElement(By.xpath("//*[contains(@id, 'primary-menu')]/ul/li[3]")).click();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "My account – Katalon Shop";
		Assert.assertEquals(actualTitle, 
				expectedTitle,
				"Error: Not on my account page!");
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrlContains = "/my-account";
		
		/*
		 I nacin
		 Assert.assertEquals(actualUrl, 
				baseUrl + expectedUrlContains,
				"Error: Not on my account page!");
		 */
		boolean contains = actualUrl.contains(expectedUrlContains);
		Assert.assertTrue(contains, "Error: Not on my account page!");
	}
	
	@Test (priority = 200) 
	public void  checkInputTypes() {
		driver.get(baseUrl + "/my-account/"); 
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		Assert.assertEquals(password.getAttribute("type"),
				"password",
				"Invalid password input type!");
		Assert.assertEquals(driver.findElement(By.id("username")).getAttribute("type"),
				"text",
				"Invalid username input type!");
		Assert.assertEquals(driver.findElement(By.id("rememberme")).getAttribute("type"),
				"checkbox",
				"Invalid rememberme input type!");
		Assert.assertTrue(!driver.findElement(By.id("rememberme")).isSelected(), 
				"The chechkbox is selected");
		
	}
	
	@Test (priority = 300) 
	public void displayErrorWhenCredentialsAreWrong() {
		driver.get(baseUrl + "/my-account/"); 
		
		driver.findElement(By.id("username")).sendKeys("invalidemail@gmail.com");
		driver.findElement(By.id("password")).sendKeys("invalid123");
		driver.findElement(By.name("login")).click();
				
		//trazenje elementa je takodje vid validacije
		wait.until(
				ExpectedConditions.presenceOfElementLocated(
						By.className("woocommerce-error")));
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@class, 'entry-content')]/div/div/ul/li")).getText(),
				"Unknown email address. Check again or try your username.",
				"Not expected message");
		
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), 
				"We are not on my account page!");
		
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
