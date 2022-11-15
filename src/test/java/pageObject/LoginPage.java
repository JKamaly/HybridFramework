package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="input-email")
	WebElement txt_email;
	
	@FindBy(id="input-password")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btn_login;
	
	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}
	public void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	public void clickLoginBtn() {
		btn_login.click();
	}
	
	

}
