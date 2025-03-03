package p20_09_2022_tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import p20_09_2022_pages.BootstrapTablePage;
import p20_09_2022_pages.DeleteDialogPage;
import p20_09_2022_pages.EditDialogPage;

public class BootstrapTableTests {

	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://s.bootsnipp.com";
	private BootstrapTablePage tablePage;
	private EditDialogPage editDialogPage;
	private DeleteDialogPage deleteDialogPage;
	
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//pravimo objekat
		tablePage = new BootstrapTablePage(driver, wait);
		editDialogPage = new EditDialogPage(driver, wait);
		deleteDialogPage = new DeleteDialogPage(driver, wait);
	}
	
	@BeforeMethod
	public void BeforeMethod() {
		driver.get(baseUrl);
	}
	
	@Test (priority = 100)
	public void editRow() {
		driver.get(baseUrl + "/iframe/K5yrx"); 
		Assert.assertEquals(driver.getTitle(), 
				"Table with Edit and Update Data - Bootsnipp.com", 
				"Page title is not as expected!");
		
		tablePage.getEditButtonByRow(0).click();
		
		editDialogPage.waitForDialogToBeVisible(); 
		
		editDialogPage.getFirstNameInput().clear();
		editDialogPage.getFirstNameInput().sendKeys("Milan");
		
		editDialogPage.getLastNameInput().clear();
		editDialogPage.getLastNameInput().sendKeys("Jovanovic");
		
		editDialogPage.getMiddleNameInput().clear();
		editDialogPage.getMiddleNameInput().sendKeys("Nebojsa");
		
		editDialogPage.getUpdateButton().click();
		
		editDialogPage.waitForDialogToBeInvisible();
		
		
		Assert.assertEquals(tablePage.getCell(0, 1).getText(), 
				"Milan", 
				"First name in table is not as expected");
		
		Assert.assertEquals(tablePage.getCell(0, 2).getText(), 
				"Jovanovic", 
				"Last name in table is not as expected");
		
		Assert.assertEquals(tablePage.getCell(0, 3).getText(), 
				"Nebojsa", 
				"Middle name in table is not as expected");
		
	}
	
	@Test (priority = 200)
	public void deleteRow() {
		driver.get(baseUrl + "/iframe/K5yrx"); 
		Assert.assertEquals(driver.getTitle(), 
				"Table with Edit and Update Data - Bootsnipp.com", 
				"Page title is not as expected!");
		
		int numberOfRowsBeforeDelete = tablePage.getRows().size();
		
		tablePage.getDeleteButtonByRow(0).click();
		deleteDialogPage.waitForDialogToBeVisible();
		deleteDialogPage.getDeleteButton().click();
		deleteDialogPage.waitForDialogToBeInvisible();
		
		Assert.assertEquals(tablePage.getRows().size(), 
				numberOfRowsBeforeDelete - 1,
				"The number of rows in the table has not decreased by 1.");
	}
	
	
	@AfterMethod
	public void AfterMethod() {
		
	}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
	
}
