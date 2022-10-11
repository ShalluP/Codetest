package PlandayPage;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage_Planday extends BaseClass_Planday{
	
	public String urlSchedule;
	
	//WebDriverWait wait = new WebDriverWait(driver, 40);
	
	public HomePage_Planday(WebDriver driver) {
			super(driver);
	}
	@FindBy(xpath="(//*[@title='Schedule'])[1]")
	private WebElement scheduleLink;
	
	//Methods 
	
	public void verifyHomepageIsDisplayed() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	//	wait.until(ExpectedConditions.elementToBeClickable(scheduleLink));
		Thread.sleep(5000);
		Assert.assertTrue(scheduleLink.isDisplayed(), "FAIL : the Home Page is not displayed");
	}
	public void clickOnSchedule() {
		scheduleLink.click();
	}
	public void verifyScheduleUrl() {
		urlSchedule = driver.getCurrentUrl();
		System.out.println("The current title after schedule is : "+ urlSchedule);
	//	Assert.assertTrue(urlSchedule.equalsIgnoreCase(scheduleUrl));
		}
	
	
}
