package d20_09_2022_pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSignupPage {

	private WebDriver driver;

	public LoginSignupPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getLoginEmailInput() {
		return driver.findElement(By.xpath("//input[@data-qa='login-email']"));
	}
	
	public WebElement getLoginPasswordInput() {
		return driver.findElement(By.xpath("//input[@data-qa='login-password']"));
	}

	public WebElement getSignupNameInput() {
		return driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
	}
	
	public WebElement getSignupEmailInput() {
		return driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[@data-qa='login-button']"));
	}
	
	public WebElement getSignupButton() {
		return driver.findElement(By.xpath("//*[@data-qa='signup-button']"));
	}
	
	public void waitForAccountToBeCreated() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.textToBe(By.xpath("//*[contains(@class, 'title')]/b"), "ACCOUNT CREATED!"));
	}
	
	public void waitForAccountToBeDeleted() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.textToBe(By.xpath("//*[contains(@class, 'title')]/b"), "ACCOUNT DELETED!"));
	}
}
