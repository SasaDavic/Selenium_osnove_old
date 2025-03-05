package p20_09_2022_tests1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import p20_09_2022_pages1.CartPage;
import p20_09_2022_pages1.MyAccountPage;
import p20_09_2022_pages1.NavPage;
import p20_09_2022_pages1.ProductPage;


public class KatalonShopTests {

	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://cms.demo.katalon.com";
	private ProductPage productPage;
	private NavPage navPage;
	private CartPage cartPage;
	private MyAccountPage myAccountPage;
	
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		productPage = new ProductPage(driver, wait);
		navPage = new NavPage(driver);
		cartPage = new CartPage(driver, wait);
		myAccountPage = new MyAccountPage(driver);
	}
	
	@BeforeMethod
	public void BeforeMethod() {
		driver.get(baseUrl);
	}
	
	@Test (priority = 10)
	public void addingProductWithQuantityToTheCart() {
		driver.get(baseUrl + "/product/flying-ninja/");
		productPage.getQuantityInput().clear();
		productPage.getQuantityInput().sendKeys("3");
		productPage.getAddToCartButton().click();
		Assert.assertTrue(productPage.getMessageForAddingProductToCart().contains("Flying Ninja"), 
				"Message for adding product to cart does not contain expected message!");
		
		
		navPage.getCartLink().click();		
		Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), 
				"Url does not contains /cart");
		Assert.assertEquals(cartPage.getAllTableRows().size(), 
				1,
				"Number of product in cart is not 1!");
	}
	
	@Test (priority = 20)
	public void removingProductFromCart() {
		navPage.getCartLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), 
				"Url does not contains /cart");
		Assert.assertEquals(cartPage.getAllTableRows().size(), 
				1,
				"Number of product in cart is not 1!");
		cartPage.getDeleteButtonLink(1).click();
		
		cartPage.waitForNumberOfProductRowsToBe(0);
	//	Assert.assertEquals(cartPage.getAllTableRows().size(), 
	//			0,
	//			"Cart is not empty!");
	}
	
	@Test (priority = 30)
	public void verifyErrorIsDisplayedWhenUsernameIsMissing() {
		navPage.getMyAccountLink().click();
		myAccountPage.getLogInButton().click();
		Assert.assertEquals(driver.findElement(By.className("woocommerce-notices-wrapper")).getText(), 
				"Error: Username is required.",
				"Error message is not as expected!");
	}
	
	@Test (priority = 40)
	public void verifyErrorIsDisplayedWhenPasswordIsMissing() {
		navPage.getMyAccountLink().click();
		myAccountPage.getUsernameInput().sendKeys("customer");
		myAccountPage.getLogInButton().click();
		Assert.assertEquals(driver.findElement(By.className("woocommerce-notices-wrapper")).getText(), 
				"Error: The password field is empty.",
				"Error message is not as expected!");
	}
	
	@Test (priority = 50)
	public void verifyErrorIsDisplayedWhenPasswordIsWrong() {
		navPage.getMyAccountLink().click();
		myAccountPage.getUsernameInput().sendKeys("customer");
		myAccountPage.getPasswordInput().sendKeys("invalidpassword");
		myAccountPage.getLogInButton().click();
		Assert.assertEquals(driver.findElement(By.className("woocommerce-notices-wrapper")).getText(), 
				"Error: The password you entered for the username customer is incorrect. Lost your password?",
				"Error message is not as expected!");
	}
	
	@Test (priority = 60)
	public void verifyErrorIsDisplayedWhenUserDoesNotExist() {
		navPage.getMyAccountLink().click();
		myAccountPage.getUsernameInput().sendKeys("invaliduser");
		myAccountPage.getPasswordInput().sendKeys("pass1234");
		myAccountPage.getLogInButton().click();
		Assert.assertEquals(driver.findElement(By.className("woocommerce-notices-wrapper")).getText(), 
				"Error: The username invaliduser is not registered on this site. If you are unsure of your username, try your email address instead.",
				"Error message is not as expected!");
	}
	
	@Test (priority = 70)
	public void verifySuccessfulLogin() {
		navPage.getMyAccountLink().click();
		myAccountPage.getUsernameInput().sendKeys("customer");
		myAccountPage.getPasswordInput().sendKeys("crz7mrb.KNG3yxv1fbn");
		myAccountPage.getLogInButton().click();
		Assert.assertTrue(driver.findElement(By.className("woocommerce-MyAccount-content")).getText().contains("Hello KatalonLover"), 
				"Error message is not as expected!");
	}
	
	
	@AfterMethod
	public void AfterMethod() {
		
	}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
	
	
	
}
