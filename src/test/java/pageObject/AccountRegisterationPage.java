package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends BasePage {

	public AccountRegisterationPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
    WebElement txt_lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(id="input-telephone")
	WebElement num_telephone;
	
	@FindBy(id="input-password")
	WebElement txt_password;
	
	@FindBy(id="input-confirm")
	WebElement txt_confirmPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement ch_policyAgree;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btn_continueBtn;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement accountCreatedMsg;
	
	public void setfirstName(String fname) {
		txt_firstName.sendKeys(fname);
	}
	public void setlastName(String lname) {
		txt_lastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}
	public void setTelephoneNumber(String phone) {
		num_telephone.sendKeys(phone);
	}
	public void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	public void setPasswordConfirm(String pwdConf) {
		txt_confirmPassword.sendKeys(pwdConf);
	}
	public void checkPolicyAgreeChekBox() {
		ch_policyAgree.click();
	}
	public void clickContinueButton() {
		btn_continueBtn.click();
	}
	public String getConfirmationMsg() {
		try {
		return (accountCreatedMsg.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
}
