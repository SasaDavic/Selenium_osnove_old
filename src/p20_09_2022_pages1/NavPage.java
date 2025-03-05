package p20_09_2022_pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {

	private WebDriver driver;
	
	
	public NavPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCartLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'nav-menu')]//li[1]/a"));
	}
	
	public WebElement getCheckoutLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'nav-menu')]//li[2]/a"));
	}
	
	public WebElement getMyAccountLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'nav-menu')]//li[3]/a"));
	}
	
	public WebElement getSamplePageLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'nav-menu')]//li[4]/a"));
	}
	
	public WebElement getShopLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'nav-menu')]//li[5]/a"));
	}
	
	
	
	
}
