package d20_09_2022_pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {

	private WebDriver driver;

	public NavPage(WebDriver driver) {
		this.driver = driver;
	}
	public void waitUntilUserIsLogOut() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Signup / Login")));
	}
	
	public void waitUntilUserIsLogIn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Logged in as")));
	}
	
	public WebElement getHomeLink() {
		return driver.findElement(By.className("nav")).findElement(By.partialLinkText("Home"));
	}
	
	public WebElement getProductsLink() {
		return driver.findElement(By.className("nav")).findElement(By.partialLinkText("Products"));
	}
	
	public WebElement getCartLink() {
		return driver.findElement(By.className("nav")).findElement(By.partialLinkText("Cart"));
	}
	
	public WebElement getSignupLoginLink() {
		return driver.findElement(By.className("nav")).findElement(By.partialLinkText("Signup / Login"));
	}
	
	public WebElement getLogoutLink() {
		return driver.findElement(By.className("nav")).findElement(By.partialLinkText("Logout"));
	}
	
	public WebElement getDeleteAccountLink() {
		return driver.findElement(By.className("nav")).findElement(By.partialLinkText("Delete Account"));
	}
	
	public WebElement getTestCasesLink() {
		return driver.findElement(By.className("nav")).findElement(By.partialLinkText("Test Cases"));
	}
	
	public WebElement getAPITestingLink() {
		return driver.findElement(By.className("nav")).findElement(By.partialLinkText("API Testing"));
	}
	
	public WebElement getVideoTutorialsLink() {
		return driver.findElement(By.className("nav")).findElement(By.partialLinkText("Video Tutorials"));
	}
	
	public WebElement getContactUsLink() {
		return driver.findElement(By.className("nav")).findElement(By.partialLinkText("Contact us"));
	}
	
	
	
}
