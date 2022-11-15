package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	WebElement myAccountLink;
	
	@FindBy(linkText="Register")
	WebElement myRegisterLink;
	
	@FindBy(linkText="Login")
	WebElement loginLink;

	public void accountLink() {
		myAccountLink.click();
		
	}
	public void registerLink() {
		myRegisterLink.click();
	}
	public void clickLoginLink() {
		loginLink.click();
	}
}
