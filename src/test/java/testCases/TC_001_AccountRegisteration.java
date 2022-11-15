package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObject.AccountRegisterationPage;
import pageObject.HomePage;
import testBase.BaseClass;


public class TC_001_AccountRegisteration extends BaseClass{

	@Test(groups = {"Regression", "Master"})
	public void text_account_Registration() {
		logger.debug("Application log..........");
		logger.info("*** Starting TC_001_AccountRegisteration ***");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.accountLink();
		logger.info("Clicked on account link");
		
		hp.registerLink();
		logger.info("Clicked on register link");
		
		AccountRegisterationPage regp=new AccountRegisterationPage(driver);
		
		logger.info("Providing customer data");
		regp.setfirstName(randomString().toUpperCase());
		regp.setlastName(randomString().toUpperCase());
		regp.setEmail(randomString()+"@gmail.com");
		regp.setTelephoneNumber(randomNumeric());
		String password =randomAphaNum();
		regp.setPassword(password);
		regp.setPasswordConfirm(password);
		regp.checkPolicyAgreeChekBox();
		
		regp.clickContinueButton();
		logger.info("Clicked on continue");
		
		String confmsg=regp.getConfirmationMsg();
		logger.info("Validating expected message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		}catch(Exception e) {
			logger.info("Test failed");
			Assert.fail();
		}
		
		logger.info("***Finished logging test***");
		
		
	}


}
