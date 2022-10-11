package PlandayPage;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage_Planday extends BaseClass_Planday{
	
public LoginPage_Planday(WebDriver driver) {
	
		super(driver);
	}
@FindBy(id="cookie-consent-button")
private WebElement catchcookieBtn;

@FindBy(id="Username")
private WebElement usernameField;

@FindBy(id="Password")
private WebElement passwordField;

@FindBy(id="MainLoginButton")
private WebElement loginBtn ;

@FindBy(id="Username-validation-error")
private WebElement usernameErrorMsg ;

@FindBy(id="Password-validation-error")
public WebElement passwordErrorMsg ;

//Methods
public void catchCookieIfVisible() {
	try {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		catchcookieBtn.isDisplayed();
		catchcookieBtn.click();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void loginFieldsDisplayed() {
	Assert.assertTrue(usernameField.isDisplayed(), "FAIL : the Username Field is not displayed");
	Assert.assertTrue(passwordField.isDisplayed(), "FAIL : the Password Field is not displayed");
	Assert.assertTrue(loginBtn.isDisplayed(), "FAIL : the Login Button Field is not displayed");
	}
public void enterInvalidLoginCredentials(String Username,String Password) throws InterruptedException {
		
	usernameField.sendKeys(Username);
	passwordField.sendKeys(Password);
	loginBtn.click();
	Thread.sleep(2000);
	Assert.assertTrue(usernameErrorMsg.isDisplayed(), "FAIL : the Username Error Message is not displayed");
	Assert.assertTrue(passwordErrorMsg.isDisplayed(), "FAIL : the Password Error Message is not displayed");
}
public void enterValidLoginCredentials(String Username,String Password) throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	usernameField.clear();
	usernameField.sendKeys(Username);
	passwordField.sendKeys(Password);
	loginBtn.click();
}

}
