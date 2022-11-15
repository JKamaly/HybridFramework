package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	
	@Test(groups= {"Sanity", "Master"})
	public void test_login() {
		
		try {
		logger.info("*** Starting TC_002_LoginTest");
		
		HomePage hp = new HomePage(driver);
		hp.accountLink();
		logger.info("Clicked on myAccount");
		hp.clickLoginLink();
		logger.info("Clicked on Register Link");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Providing login details");
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLoginBtn();
		logger.info("Clicked on login button");
		
		MyAccountPage map = new MyAccountPage(driver);
		boolean targetPage=map.isMyAccountPageExist();
		Assert.assertEquals(targetPage, true, "Invalid login data");
		
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*** Finished TC_002_LoginTest***");
	}

}
