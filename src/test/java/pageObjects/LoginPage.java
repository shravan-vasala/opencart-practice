package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	// Locators and elements
	
	@FindBy(name = "email")
	WebElement inputEmail;
	
	@FindBy(name = "password")
	WebElement inputPassword;

	@FindBy(xpath = "//input[@value = 'Login']")
	WebElement buttonLogin;
	
	public void setEmail(String email) {
		inputEmail.sendKeys(email);
	}
	
	public void setPassword(String pass) {
		inputPassword.sendKeys(pass);
	}
	
	public void clickLogin() {
		buttonLogin.click();
	}
}


	