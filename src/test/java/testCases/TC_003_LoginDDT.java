package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_loginDTT(String email, String password, String exp) {

		logger.info("*** Starting TC_003_LoginDTT***");

		try {
			HomePage hp = new HomePage(driver);
			hp.accountLink();
			hp.clickLoginLink();
			

			LoginPage lp = new LoginPage(driver);
			
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLoginBtn();

			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExist();

			if (exp.equals("Valid")) {
				if (targetPage == true) {
					map.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equals("Invalid")) {
				if (targetPage == true) {
					map.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Finished TC_003_LoginDTT***");

	}

}
