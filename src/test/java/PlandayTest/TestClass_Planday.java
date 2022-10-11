package PlandayTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PlandayPage.HomePage_Planday;
import PlandayPage.LoginPage_Planday;
import PlandayPage.SchedulePage_Planday;
import WebDriverManager.DriverManager;

public class TestClass_Planday {
WebDriver driver;
DriverManager driverManager = new DriverManager();
public String username_invalid="shpa@gmail.com";
public String username_valid="plandayqa@outlook.com";
public String password_invalid="1234";
public String password_valid="APItesting21";
public String from_time="9:00";
public String to_time="17:00";
public String scheduleUrl="https://test1234.planday.com/schedule";

	/*
	 * public LoginPage_Planday loginPage_Planday = new LoginPage_Planday(); public
	 * HomePage_Planday HomePage_Planday = new HomePage_Planday(); public
	 * SchedulePage_Planday SchedulePage_Planday = new SchedulePage_Planday();
	 */
@BeforeClass()
public void initialiseDriver() {
	driver = driverManager.initialiseDriver();
}

	@Test(priority = 1) 
	public void verifyLoginPage() throws InterruptedException {
	LoginPage_Planday loginPage_Planday = new LoginPage_Planday(driver);
	loginPage_Planday.loginFieldsDisplayed();

	loginPage_Planday.enterInvalidLoginCredentials(username_invalid,
			password_invalid); String errorMsg =
			loginPage_Planday.passwordErrorMsg.getText();
			System.out.println("the error message is :"+errorMsg );
			loginPage_Planday.enterValidLoginCredentials(username_valid, password_valid);
  }
 

	@Test(priority = 2) 
	public void navigateToScheduleAndVerify() throws InterruptedException{
//	driver = driverManager.initialiseDriver();
	HomePage_Planday HomePage_Planday = new HomePage_Planday(driver);
	HomePage_Planday.verifyHomepageIsDisplayed();
	HomePage_Planday.clickOnSchedule();
	HomePage_Planday.verifyScheduleUrl();
	}

	
	  @Test(priority = 3) public void createScheduleEntry() throws
	  InterruptedException { 
		  //driver = driverManager.initialiseDriver();
	  SchedulePage_Planday SchedulePage_Planday = new SchedulePage_Planday(driver);
	  SchedulePage_Planday.switcToIframe();
	  SchedulePage_Planday.verifyEmployeeCount();
	  Assert.assertEquals(SchedulePage_Planday.size, 3);
	  SchedulePage_Planday.createShiftAndVerify(from_time, to_time);
	  
	  }
	 

  @AfterClass
   public void closeDriverInstance() { driver.quit(); }
 
}
