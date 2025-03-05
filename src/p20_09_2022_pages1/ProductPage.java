package p20_09_2022_pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public ProductPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	
	public WebElement getQuantityInput() {
		return driver.findElement(By.xpath("//input[@type='number']"));
	}
	
	public WebElement getAddToCartButton() {
		return driver.findElement(By.name("add-to-cart"));
	}
	
	public String getMessageForAddingProductToCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("woocommerce-message")));
		return driver.findElement(By.className("woocommerce-message")).getText();
	}
}
