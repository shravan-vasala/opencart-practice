package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups = {"Sanity", "Master"})
	public void test_Login() {
		
		try {
			logger.info("*** Started TC_002_LoginTest***");
			HomePage home = new HomePage(driver);
			home.clickMyAccount();
			home.clickLogin();
			
			LoginPage login = new LoginPage(driver);
			login.setEmail(rb.getString("email"));
			login.setPassword(rb.getString("password"));
			login.clickLogin();
			
			MyAccountPage account = new MyAccountPage(driver);
			boolean status = account.isMyAccountPageExists();
			Assert.assertEquals(status, true);
			
		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("*** Ended TC_002_LoginTest***");
		
	}
}
