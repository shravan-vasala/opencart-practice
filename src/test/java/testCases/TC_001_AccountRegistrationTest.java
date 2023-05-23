package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups = {"Regression", "Master"})
	public void test_account_Registration() {
		try {
			
			logger.info("*** Started TC_001_AccountRegistrationTest");
			HomePage home = new HomePage(driver);
			home.clickMyAccount();
			logger.info("Clicked on My Account");
			home.clickRegister();
			logger.info("Clicked on Register");
			
			AccountRegistrationPage registration = new AccountRegistrationPage(driver);
			logger.info("Started registering");
			registration.setFirstName(randomString().toUpperCase());
			registration.setLastName(randomString().toUpperCase());
			registration.setEmail(randomString() + "@gmail.com");
			registration.setTelephone(randomNumber());
			String pass = randomAlphaNumeric();
			registration.setPassword(pass);
			registration.setConfirmPassword(pass);
			registration.clickPrivacy();
			registration.clickContinue();
			logger.info("Clicked continue");
			String message = registration.getConfirmationMessage();
			
			
			Assert.assertEquals(message, "Your Account Has Been Created!");
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Finished TC_001_AccountRegistrationTest");
	}
}
