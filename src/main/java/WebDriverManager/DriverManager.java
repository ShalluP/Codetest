package WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	WebDriver driver;
	public String baseURL ="https://test1234.planday.com/";
	public WebDriver initialiseDriver() {
		System.setProperty("webdriver.chrome.driver","C://Users//shbassi//eclipse-workspace//CodeTest//Drivers//chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				  driver.get(baseURL);
				  try {
						driver.findElement(By.id("cookie-consent-button")).isDisplayed();
						driver.findElement(By.id("cookie-consent-button")).click();
						return driver;
					} catch (Exception e) {
						e.printStackTrace();
					}
				return driver;
				  
				  }

}
