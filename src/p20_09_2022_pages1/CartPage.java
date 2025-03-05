package p20_09_2022_pages1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	 public void waitForNumberOfProductRowsToBe(int productNum) {
	        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("cart_item"), productNum));
	    }
	 
	public WebElement getDeleteButtonLink(int row) {
		return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[contains(@class, 'product-remove')]/a"));
	}
	
	public WebElement getCuponInput() {
		return driver.findElement(By.name("coupon_code"));
	}
	
	public WebElement getApplyCuponButton() {
		return driver.findElement(By.name("apply_coupon"));
	}
	
	public WebElement getUpdateCartButton() {
		return driver.findElement(By.name("update_cart"));
	}
	
	public List<WebElement> getAllTableRows() {
		return driver.findElements(By.xpath("//*[contains(@class, 'cart_item')]"));
	}
	
}
