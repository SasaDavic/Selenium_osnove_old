package d20_09_2022_pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

	private WebDriver driver;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getProductsTitleText() {
		return driver.findElement(By.xpath("//*[contains(@class, 'features_items')]/h2")).getText();
	}
	
	public WebElement getViewProductLink(int productIndex) {
		List<WebElement> products = 
				driver.findElements(By.xpath("//*[contains(@class, 'product-image-wrapper')]//ul[contains(@class, 'nav')]/li/a"));
		return products.get(productIndex);
	}
	
	public void waitUntilProductsListIsVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("features_items")));
	}
	
}
