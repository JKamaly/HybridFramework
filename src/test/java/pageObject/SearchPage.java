package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//i[@class='fa fa-home']")
	WebElement myHomePageLink;
	
	@FindBy(xpath="//input[@name='search']")
	WebElement searchInputField;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement searchBtn;
	
	@FindBy(xpath="//div[@class='product-thumb']")
	WebElement iPhoneDetails;
	
	
	@FindBy(xpath="//span[normalize-space()='Add to Cart']")
	WebElement addToCartOption;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement addToCartValidationMsg;
	
	@FindBy(id="cart-total")
	WebElement totalAddToCart;
	
	public void clickHomePage() {
		myHomePageLink.click();
	}
	public void inputIntoSearchField(String input) {
		searchInputField.sendKeys(input);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	public boolean isIPhoneDetailsExist() {
		try {
		return iPhoneDetails.isDisplayed();
		}catch(Exception e) {
			return false;
		}
		
	}
	public void clickAddToCart() {
		addToCartOption.click();
	}
	public boolean getAddToCartSuccessMsg() {
		try {
		return addToCartOption.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	public boolean addedToCartTotal() {
		try {
		return totalAddToCart.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
		

}
