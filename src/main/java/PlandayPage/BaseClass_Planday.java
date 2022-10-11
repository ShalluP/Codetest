package PlandayPage;

import java.text.SimpleDateFormat;

import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass_Planday {
	public WebDriver driver;
	
	  public BaseClass_Planday(WebDriver driver) { 
		  this.driver = driver;
	  PageFactory.initElements(driver, this); }
	 	
	
	public String returnCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy");
        Date date = new Date();
        return formatter.format(date);
}
	
	
					
	
}
