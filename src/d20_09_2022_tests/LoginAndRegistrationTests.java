package d20_09_2022_tests;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAndRegistrationTests extends AutomationPracticeBasicTests{
		
//	@Test (priority = 10)
	public void newUserRegistration() {
		//provera da li smo na HOME page
		Assert.assertEquals(driver.getTitle(), "Automation Exercise", "You're not on home page!");
		//iz navigacionog menija kliknemo na signup dugme
		navPage.getSignupLoginLink().click();
		//provera da li smo na login/signup stranici
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@class, 'signup-form')]/h2")).getText(),
				"New User Signup!",
				"There is no signUp form!");
		//popunimo formu
		login_signup_page.getSignupNameInput().sendKeys("sasa");
		login_signup_page.getSignupEmailInput().sendKeys("sasa@gmail.com");
		login_signup_page.getSignupButton().click();
		//provera da li smo na signup stranici
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "Not signup page");
		signup_page.waitForFormForSignUpToOpen();
		//popunjavamo formu
		signup_page.getGenderTitleMRSInput().click();
		signup_page.getNameInput().clear();
		signup_page.getNameInput().sendKeys("Cale");
//mail moze da se unese samo preko prethode forme
		signup_page.getPasswordInput().clear();
		signup_page.getPasswordInput().sendKeys("a123");
		Select selectD = new Select(signup_page.getDaysSelect());
		Select selectM = new Select(signup_page.getMonthsSelect());
		Select selectY = new Select(signup_page.getYearsSelect());
		Select selectC = new Select(signup_page.getCountrySelect());
		selectD.selectByIndex(1);
		selectM.selectByValue("2");
		selectY.selectByVisibleText("2000");
		signup_page.getSignupForNewsletterCheckbox().click();
		signup_page.getFirstNameInput().sendKeys("Milan");
		signup_page.getLastNameInput().sendKeys("Jovic");
		signup_page.getCompanyInput().sendKeys("BGi");
		signup_page.getAddressInput().sendKeys("Jovana Ristica 3, Kraljevo");
		selectC.selectByIndex(2);
		signup_page.getStateInput().sendKeys("Srbija");
		signup_page.getCityInput().sendKeys("Kraljevo");
		signup_page.getZipcodeInput().sendKeys("15200");
		signup_page.getMobileNumberInput().sendKeys("+38160 89 89 563");
		signup_page.getCreateAccountButton().click();
		login_signup_page.waitForAccountToBeCreated();
		driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
		//brisemo nalog
	//	navPage.getDeleteAccountLink().click();
	//	login_signup_page.waitForAccountToBeDeleted();
		
		//da bismo nastavili drugi test, ako ne brisemo naloga onda se izlogujemo
		navPage.getLogoutLink().click();
		navPage.waitUntilUserIsLogOut();
	}
	
//	@Test (priority = 15)
	public void logoutUser() {
		
// Launch browser
// Navigate to url 'http://automationexercise.com'
// Verify that home page is visible successfully
  Assert.assertEquals(driver.getCurrentUrl(), 
				"https://www.automationexercise.com/",
				"You are not on right page!");
// Click on 'Signup / Login' button
  navPage.getSignupLoginLink().click();
// Verify 'Login to your account' is visible
  Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@class, 'login-form')]/h2")).getText(),
			"Login to your account",
			"There is no Log in form!");
// Enter correct email address and password
  login_signup_page.getLoginEmailInput().sendKeys("sasa@gmail.com");
  login_signup_page.getLoginPasswordInput().sendKeys("a123");
// Click 'login' button
  login_signup_page.getLoginButton().click();
// Verify that 'Logged in as username' is visible
  navPage.waitUntilUserIsLogIn();
// Click 'Logout' button
  navPage.getLogoutLink().click();
// Verify that user is navigated to login page
  Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/login", "You are not on log in page!");
	 
	}
	
	
//	@Test (priority = 20)
	public void loginUserWithCorrectEmailAndPassword() {
	//Verify that home page is visible successfully
		Assert.assertEquals(driver.getCurrentUrl(), 
				"https://www.automationexercise.com/",
				"You are not on right page!");		
	//Click on 'Signup / Login' button
		navPage.getSignupLoginLink().click();
	//Verify 'Login to your account' is visible
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@class, 'login-form')]/h2")).getText(),
				"Login to your account",
				"There is no Log in form!");
	//Enter correct email address and password
		login_signup_page.getLoginEmailInput().sendKeys("sasa@gmail.com");
		login_signup_page.getLoginPasswordInput().sendKeys("a123");		
	//Click 'login' button
		login_signup_page.getLoginButton().click();
	//Verify that 'Logged in as username' is visible
		navPage.waitUntilUserIsLogIn();
	//Click 'Delete Account' button
		navPage.getDeleteAccountLink().click();
	//Verify that 'ACCOUNT DELETED!' is visible
		login_signup_page.waitForAccountToBeDeleted();
	}
	
//	@Test (priority = 30)
	public void loginUserWithIncorrectEmailAndPassword() {
// Launch browser
// Navigate to url 'http://automationexercise.com'
// Verify that home page is visible successfully
		Assert.assertEquals(driver.getCurrentUrl(), 
				"https://www.automationexercise.com/",
				"You are not on right page!");		
// Click on 'Signup / Login' button
		navPage.getSignupLoginLink().click();
// Verify 'Login to your account' is visible
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@class, 'login-form')]/h2")).getText(),
				"Login to your account",
				"There is no Log in form!");
// Enter incorrect email address and password
		login_signup_page.getLoginEmailInput().sendKeys("lin@sin.ik");
		login_signup_page.getLoginPasswordInput().sendKeys("linSin");
// Click 'login' button
		login_signup_page.getLoginButton().click();
// Verify error 'Your email or password is incorrect!' is visible
		Assert.assertEquals(login_signup_page.getErrorMessageForFailedLogin(), 
				"Your email or password is incorrect!", 
				"There is no error message");
	}
	

//	@Test (priority = 17)
	public void registerUserWithExistingEmail() {
		//provera da li smo na HOME page
				Assert.assertEquals(driver.getTitle(), "Automation Exercise", "You're not on home page!");
				//iz navigacionog menija kliknemo na signup dugme
				navPage.getSignupLoginLink().click();
				//provera da li smo na login/signup stranici
				Assert.assertEquals(driver.findElement(By.xpath("//*[contains(@class, 'signup-form')]/h2")).getText(),
						"New User Signup!",
						"There is no signUp form!");
				//popunimo formu
				login_signup_page.getSignupNameInput().sendKeys("sasa");
				login_signup_page.getSignupEmailInput().sendKeys("sasa@gmail.com");
				login_signup_page.getSignupButton().click();
				Assert.assertEquals(login_signup_page.getErrorMessageForExistingEmail(), 
						"Email Address already exist!", 
						"Didn't get error as expected!");
	}
	
//	@Test (priority = 40)
	public void contactUsForm() {
	//		Launch browser
	//  Navigate to url 'http://automationexercise.com'
	//  Verify that home page is visible successfully
		Assert.assertEquals(driver.getCurrentUrl(), 
				"https://www.automationexercise.com/",
				"You are not on right page!");
	//  Click on 'Contact Us' button
		navPage.getContactUsLink().click();
	//  Verify 'GET IN TOUCH' is visible
		contactUsPage.waitForContactUsPageToLoad();	
	//  Enter name, email, subject and message
		contactUsPage.getNameInput().sendKeys("Sale");
		contactUsPage.getEmailInput().sendKeys("sale@mail.com");
		contactUsPage.getSubjectInput().sendKeys("qa practise");
		contactUsPage.getMessageInput().sendKeys("Page is great for learning. Tanks a lot!");
	//  Upload file
		File file = new File("img/lupa.jpeg");
		contactUsPage.getUploadFileInput().sendKeys(file.getAbsolutePath());
	//  Click 'Submit' button
		contactUsPage.getSubmitInput().click();
	//  Click OK button - Confirmation Box (Potvrdni Alert)
		Alert alertBox = driver.switchTo().alert();
		String alertText = alertBox.getText();
		System.out.println("Text potvrdnog alerta je " + alertText);
		alertBox.accept(); // kliknem ok
		
	//  Verify success message 'Success! Your details have been submitted successfully.' is visible
		contactUsPage.waitForSubmittedSuccessfullyMessage();
	}
	
//	@Test (priority = 50)
	public void  verifyTestCasesPage() {
// Launch browser
// Navigate to url 'http://automationexercise.com'
// Verify that home page is visible successfully
		Assert.assertEquals(driver.getCurrentUrl(), 
				"https://www.automationexercise.com/",
				"You are not on right page!");	
// Click on 'Test Cases' button
		navPage.getTestCasesLink().click();
// Verify user is navigated to test cases page successfully
		Assert.assertEquals(driver.getCurrentUrl(), 
				"https://www.automationexercise.com/test_cases", 
				"You're not on test cases page");
		Assert.assertEquals(testCasesPage.getTitleText(), 
				"TEST CASES", 
				"Title is not as expected!");	
//click on random test case and check if list of tasks are shown
		
		testCasesPage.getTestCaseLink(5).click();
		testCasesPage.waitForTasksForTestCasesToOpen(5);
		
		
		
	}
	
	@Test (priority = 50)
	public void verifyAllProductsAndProductDetailPage() {
// Launch browser
// Navigate to url 'http://automationexercise.com'
// Verify that home page is visible successfully
		Assert.assertEquals(driver.getCurrentUrl(), 
				"https://www.automationexercise.com/",
				"You're not on home page");
// Click on 'Products' button
		navPage.getProductsLink().click();
// Verify user is navigated to ALL PRODUCTS page successfully
		Assert.assertEquals(driver.getCurrentUrl(), 
				"https://www.automationexercise.com/products",
				"You're not on products page. Url is not as expected!");
		Assert.assertEquals(driver.getTitle(), 
				"Automation Exercise - All Products",
				"You're not on products page. Title is not as expected!");
		Assert.assertEquals(productsPage.getProductsTitleText(), 
				"ALL PRODUCTS",
				"You're not on products page. Title above products is not as expected!");
// The products list is visible
		productsPage.waitUntilProductsListIsVisible();
// Click on 'View Product' of first product
		productsPage.getViewProductLink(0).click();
// User is landed to product detail page
		Assert.assertTrue(driver.getCurrentUrl().contains("/product_details"), "You're not on product details page!");
// Verify that detail detail is visible: product name, category, price, availability, condition, brand
		Assert.assertTrue(productDetailsPage.isProductNameVisible(), "Product name is not visible");
        Assert.assertTrue(productDetailsPage.isCategoryVisible(), "Category is not visible");
        Assert.assertTrue(productDetailsPage.isPriceVisible(), "Price is not visible");
        Assert.assertTrue(productDetailsPage.isAvailabilityVisible(), "Availability is not visible");
        Assert.assertTrue(productDetailsPage.isConditionVisible(), "Condition is not visible");
        Assert.assertTrue(productDetailsPage.isBrandVisible(), "Brand is not visible");
	}
	
	
	
}
