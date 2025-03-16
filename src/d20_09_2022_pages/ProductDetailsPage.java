package d20_09_2022_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	
	private WebDriver driver;
	//probamo drugaciji nacin
	@FindBy(xpath = "//div[contains(@class,'product-information')]/h2")
    private WebElement productName;

    @FindBy(xpath = "//p[contains(text(),'Category')]")
    private WebElement category;

    @FindBy(xpath = "//span[contains(text(),'Rs.')]")
    private WebElement price;

    @FindBy(xpath = "//b[contains(text(),'Availability:')]/parent::p")
    private WebElement availability;

    @FindBy(xpath = "//b[contains(text(),'Condition:')]/parent::p")
    private WebElement condition;

    @FindBy(xpath = "//b[contains(text(),'Brand:')]/parent::p")
    private WebElement brand;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductNameVisible() {
        return productName.isDisplayed();
    }

    public boolean isCategoryVisible() {
        return category.isDisplayed();
    }

    public boolean isPriceVisible() {
        return price.isDisplayed();
    }

    public boolean isAvailabilityVisible() {
        return availability.isDisplayed();
    }

    public boolean isConditionVisible() {
        return condition.isDisplayed();
    }

    public boolean isBrandVisible() {
        return brand.isDisplayed();
    }
	
	
}
