package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchPage extends BaseClass{
	
	@Test(groups= {"Sanity", "Master"})
	public void searchPageTest() {
		logger.info("***Started TC_004_SearchPage****");
		
		HomePage hp = new HomePage(driver);
		hp.accountLink();
		logger.info("Clicked on myAccountLink");
		hp.clickLoginLink();
		logger.info("Clicked on myRegisterLink");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Provided email and password");
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLoginBtn();
		logger.info("Clicked on continue button");
		
		SearchPage sp = new SearchPage(driver);
		sp.clickHomePage();
		logger.info("Clicked on my HomePage");
		sp.inputIntoSearchField("iPhone");
		logger.info("Searched for iPhone on the search bar");
		sp.isIPhoneDetailsExist();
		logger.info("Validating iPhone presence");
		sp.clickAddToCart();
		logger.info("Clicked on add to cart button");
		try {
		boolean status=sp.getAddToCartSuccessMsg();
		logger.info("Validating add to cart success message");
		Assert.assertEquals(status, true);
		}catch(Exception e) {
			Assert.fail();
		}
		try {
		boolean addToCarMsg=sp.addedToCartTotal();
		logger.info("Validating add to cart total is present");
		Assert.assertEquals(addToCarMsg, true);
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("***Finished TC_004_SearchPage****");
	}
	
}
