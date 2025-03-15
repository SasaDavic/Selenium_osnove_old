package d20_09_2022_pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCasesPage {
	
	private WebDriver driver;

	public TestCasesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitleText() {
		return driver.findElement(By.xpath("//*[contains(@class, 'title')]/b")).getText();
	}

	public WebElement getTestCaseLink(int testCaseNumber) {
		List<WebElement> testCases = driver.findElements(By.xpath("//*[contains(@class, 'panel-title')]/a"));
		return testCases.get(testCaseNumber - 1);
	}
	
	public void waitForTasksForTestCasesToOpen(int testCaseNumber) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("collapse" + testCaseNumber)));
	}
	
}
