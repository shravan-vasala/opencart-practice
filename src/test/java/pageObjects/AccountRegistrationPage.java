package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	// WebElements and locators
	
	@FindBy(name = "firstname")
	WebElement inputFirstName;
	
	@FindBy(name = "lastname")
	WebElement inputLastName;
	
	@FindBy(name = "email")
	WebElement inputEmail;
	
	@FindBy(name = "telephone")
	WebElement inputTelephone;
	
	@FindBy(name = "password")
	WebElement inputPassword;
	
	@FindBy(name = "confirm")
	WebElement inputConfirmPassword;
	
	@FindBy(name = "agree")
	WebElement checkPrivacy;
	
	@FindBy(xpath = "//input[@value = 'Continue']")
	WebElement buttonContinue;
	
	@FindBy(xpath = "//h1[normalize-space() = 'Your Account Has Been Created!']")
	WebElement confirmMessage;
	
	public void setFirstName(String fname) {
		inputFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		inputLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		inputEmail.sendKeys(email);
	}
	
	public void setTelephone(String phone) {
		inputTelephone.sendKeys(phone);
	}
	
	public void setPassword(String pass) {
		inputPassword.sendKeys(pass);
	}
	
	public void setConfirmPassword(String pass) {
		inputConfirmPassword.sendKeys(pass);
	}
	
	public void clickPrivacy() {
		checkPrivacy.click();
	}
	
	public void clickContinue() {
		buttonContinue.click();
	}
	
	public String getConfirmationMessage() {
		try {
			return confirmMessage.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
