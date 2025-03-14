package d20_09_2022_pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
	private WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForContactUsPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.textToBe(By.xpath("//*[contains(@class, 'contact-form')]/h2"), "GET IN TOUCH"));
	}
	
	public void waitForSubmittedSuccessfullyMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.textToBe(By.xpath("//*[contains(@class, 'contact-form')]/div[2]"), "Success! Your details have been submitted successfully."));
	}
	
	public WebElement getNameInput() {
		return driver.findElement(By.name("name"));
	}
	
	public WebElement getEmailInput() {
		return driver.findElement(By.name("email"));
	}
	
	public WebElement getSubjectInput() {
		return driver.findElement(By.name("subject"));
	}
	
	public WebElement getMessageInput() {
		return driver.findElement(By.name("message"));
	}
	
	public WebElement getUploadFileInput() {
		return driver.findElement(By.name("upload_file"));
	}
	
	public WebElement getSubmitInput() {
		return driver.findElement(By.name("submit"));
	}
	
	
	
}
