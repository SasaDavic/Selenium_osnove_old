package p20_09_2022_pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	private WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getUsernameInput() {
		return driver.findElement(By.id("username"));
	}

	public WebElement getPasswordInput() {
		return driver.findElement(By.id("password"));
	}
	
	public WebElement getLogInButton() {
		return driver.findElement(By.name("login"));
	}
	
	
	
	
}
