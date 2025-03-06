package d20_09_2022_pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

	private WebDriver driver;

	public SignupPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForFormForSignUpToOpen() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.textToBe(By.xpath("//*[contains(@class, 'title')]/b"), "ENTER ACCOUNT INFORMATION"));
	}
	
	public void waitForEmailtoBeClickable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
	}
	
	
	public WebElement getGenderTitleMRInput() {
		return driver.findElement(By.id("id_gender1"));
	}
	
	public WebElement getGenderTitleMRSInput() {
		return driver.findElement(By.id("id_gender2"));
	}
	
	public WebElement getNameInput() {
		return driver.findElement(By.xpath("//*[@data-qa='name']"));
	}
	
	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getPasswordInput() {
		return driver.findElement(By.xpath("//*[@data-qa='password']"));
	}
	
	public WebElement getDaysSelect() {
		return driver.findElement(By.xpath("//*[@data-qa='days']"));
	}
	
	public WebElement getMonthsSelect() {
		return driver.findElement(By.xpath("//*[@data-qa='months']"));
	}
	
	public WebElement getYearsSelect() {
		return driver.findElement(By.xpath("//*[@data-qa='years']"));
	}
	
	public WebElement getSignupForNewsletterCheckbox() {
		return driver.findElement(By.id("newsletter"));
	}
	
	public WebElement getReceiveSpecialOffersCheckbox() {
		return driver.findElement(By.id("uniform-optin"));
	}
	
	public WebElement getFirstNameInput() {
		return driver.findElement(By.xpath("//*[@data-qa='first_name']"));
	}
	
	public WebElement getLastNameInput() {
		return driver.findElement(By.xpath("//*[@data-qa='last_name']"));
	}
	
	public WebElement getCompanyInput() {
		return driver.findElement(By.xpath("//*[@data-qa='company']"));
	}
	
	public WebElement getAddressInput() {
		return driver.findElement(By.xpath("//*[@data-qa='address']"));
	}
	
	public WebElement getAddress2Input() {
		return driver.findElement(By.xpath("//*[@data-qa='address2']"));
	}
	
	public WebElement getCountrySelect() {
		return driver.findElement(By.xpath("//*[@data-qa='country']"));
	}
	
	public WebElement getStateInput() {
		return driver.findElement(By.xpath("//*[@data-qa='state']"));
	}
	
	public WebElement getCityInput() {
		return driver.findElement(By.xpath("//*[@data-qa='city']"));
	}
	
	public WebElement getZipcodeInput() {
		return driver.findElement(By.xpath("//*[@data-qa='zipcode']"));
	}
	
	public WebElement getMobileNumberInput() {
		return driver.findElement(By.xpath("//*[@data-qa='mobile_number']"));
	}
	
	public WebElement getCreateAccountButton() {
		return driver.findElement(By.xpath("//*[@data-qa='create-account']"));
	}
}
